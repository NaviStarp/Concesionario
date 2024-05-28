package GUI;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

import com.mysql.cj.protocol.x.ContinuousOutputStream;
import com.mysql.cj.util.EscapeTokenizer;

import Clases.Vehiculo;
import BD.ConexionBD;
import Clases.Cliente;
import Clases.Factura;

public class V_ConfirmacionCompraAlquiler extends JPanel {
    
    private Cliente cliente;
    private Vehiculo vehiculo;
    private JPanel tareasContenedor;
    private JLabel totalLabel;
    private JButton enviarButton;
    private  ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    int yPos = 10; // Inicializar posición Y


    public V_ConfirmacionCompraAlquiler(Cliente cliente, ArrayList<String> matriculas, boolean alquilado, LinkedList<Integer> dias) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.setSize(800, 500);
 
        this.setLayout(new BorderLayout(10, 10));

        tareasContenedor = new JPanel();
        tareasContenedor.setLayout(null); // Cambiado a layout nulo para posicionamiento absoluto

        // Añadir tarea por defecto

        new ConexionBD().buscarVehiculos(matriculas,vehiculos);
        bucleTareas(vehiculos);

        JScrollPane tareasScroll = new JScrollPane(tareasContenedor,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, // Añadido para que el scroll vertical esté siempre visible
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Deshabilitado el scroll horizontal
        tareasScroll.setPreferredSize(new Dimension(700, 350));
        this.add(tareasScroll, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        double total = 0;
        if (alquilado) {
            LinkedList<Integer> dias2 = new LinkedList<Integer>(dias);

            for(Vehiculo vehiculo : vehiculos) {
            	if (dias2.isEmpty()) {
					break;
				}
                int dia = dias2.get(0);
                vehiculo.setDiasAlquilados(dia);
                total += ((vehiculo.getPrecio() * 0.5) / 100) * dia;
                dias2.remove(0);

            }
        } else {
            for(Vehiculo vehiculo : vehiculos)
                 total += vehiculo.getPrecio();
        }

        bottomPanel.setBackground(new Color(102, 102, 102));
        
        totalLabel = new JLabel(" El total es " + total + "€");
        totalLabel.setFont(new Font("Cascadia Mono", Font.BOLD, 16));
        totalLabel.setForeground(Color.WHITE);
        bottomPanel.add(totalLabel, BorderLayout.WEST);
        enviarButton = new JButton("Comprar");
        if (alquilado) {
            enviarButton = new JButton("Alquilar");

        }
        enviarButton.setFont(new Font("Cascadia Mono", Font.BOLD, 17));
        enviarButton.setBackground(new Color(203, 41, 41));
        enviarButton.setForeground(Color.WHITE);
        enviarButton.addActionListener(e->{
            LinkedList<Integer> dias2 = new LinkedList<Integer>(dias) ;
            int resultado = JOptionPane.showConfirmDialog(null, "Se va a confirmar la compra esta seguro/a?","Confirmacion", JOptionPane.YES_NO_OPTION);
            if (resultado == 0) {
                for(Vehiculo vehiculo:vehiculos) {
                	int dia;
                        if(alquilado && dias2.isEmpty()) {
                        	break;
                        }
                        if(alquilado) {
                        dia = dias2.get(0);
                        dias2.remove(0);
                        }else {
                        	dia = 0;
                        }
                        new ConexionBD().actualizarVehiculo(vehiculo.getMatricula(), cliente, alquilado,dia);
                        
                }
                resultado = JOptionPane.showConfirmDialog(null, "Quieres factura?","Facturacion", JOptionPane.YES_NO_OPTION);
                
                if (resultado==0) {
                	Factura f = new Factura(cliente, vehiculos,alquilado);
                    f.guardarFacturaEnArchivo();
                	System.out.println("Se ha guardado la factura");
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    if (topFrame != null) {
                        V_inicio v_inicio = new V_inicio(cliente);
                        topFrame.dispose();
                    }
                }else {
                	System.out.println("No se a guardado factura");
                	 JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    if (topFrame != null) {
                        V_inicio v_inicio = new V_inicio(cliente);
                        topFrame.dispose();
                    }
                }

            }
            

        });
        bottomPanel.add(enviarButton, BorderLayout.EAST);

        this.add(bottomPanel, BorderLayout.SOUTH);
    }

 

    public void bucleTareas(ArrayList<Vehiculo> tareas) {
        for (Vehiculo tareaInfo : tareas) {
            JPanel tarea = crearTarea(tareaInfo);
            tarea.setBounds(10, yPos, 1600, 151); 
            // Establecer posición y tamaño preferido
            tareasContenedor.add(tarea);
            yPos += 160; // Incrementar posición Y para la siguiente tarea
        }
        tareasContenedor.setPreferredSize(new Dimension(700, yPos)); // Ajustar tamaño del panel contenedor
        tareasContenedor.revalidate(); // Revalidar el contenedor para que se actualice el scroll
        tareasContenedor.repaint();
    }

    public JPanel crearTarea(Vehiculo vehiculo) {
        return new PanelCoche(vehiculo);
    }

  

    public static void main(String[] args) {
//        JFrame frame = new JFrame("Confirmación Compra/Alquiler");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 500);
//        frame.getContentPane().add(new V_ConfirmacionCompraAlquiler(new Cliente(), new Vehiculo()));
//        frame.setVisible(true);
    }
}
