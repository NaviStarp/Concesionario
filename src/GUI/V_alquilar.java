package GUI;
import Clases.*;
import BD.*;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mysql.cj.jdbc.ha.BestResponseTimeBalanceStrategy;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTable;

public class V_alquilar extends JFrame {
	boolean pulsado = false;
    private static Cliente cliente = new Cliente();
	private JPanel contentPane;
	private final JPanel frameGeneral = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private ArrayList<String> matriculas = new ArrayList<String>();
	private DefaultTableModel tabla;
	String[] titulos = 	new String[] {
			"Matricula", "Marca", "Modelo", "Año", "Color", "Precio","Tipo"
	};
	private LinkedList<Integer> dias = new LinkedList<>();
	String[] datos = new String[7];


// lanzar aplicacion
	public static void main(String[] args) {
				try {
					V_alquilar frame = new V_alquilar();
					frame.setVisible(true);
			        frame.setResizable(false);//que no se pueda cambiar el tamaño
			        frame.setLocationRelativeTo(null);//que se muestre en el centro de la pantalla
				} catch (Exception e) {
					e.printStackTrace();
				}
			
	
	}

	/**
	 * Crear marco
	 */
	public V_alquilar(Cliente cliente) {
        this.cliente = cliente;
        matriculas.clear();
		V_alquilar frame = new V_alquilar();
		frame.setVisible(true);
        frame.setResizable(false);//que no se pueda cambiar el tamaño
        frame.setLocationRelativeTo(null);//que se muestre en el centro de la pantalla
	}
	public V_alquilar() {
		setTitle("Clicars");
		setIconImage(Toolkit.getDefaultToolkit().getImage(V_alquilar.class.getResource("/imagenes/2.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1413, 793);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		frameGeneral.setBackground(new Color(192, 192, 192));
		frameGeneral.setBounds(0, 0, 1397, 754);
		contentPane.add(frameGeneral);
		frameGeneral.setLayout(null);

		/*
		 * Inicio panel lateral
		 * 
		 * 
		 * 
		 * 
		 */
		JPanel panelLateral = new JPanel();
		panelLateral.setBackground(new Color(203, 41, 41));
		panelLateral.setBounds(0, 0, 93, 754);
		frameGeneral.add(panelLateral);
		panelLateral.setLayout(null);
		/*
		 * Inicioboton
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		JToggleButton btnInicio = new JToggleButton("");
		btnInicio.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/coche (2).png")));
		btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
		btnInicio.setBackground(new Color(203, 41, 41));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnInicio.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnInicio);
		btnInicio.setVisible(false);
		btnInicio.setBounds(10, 208, 248, 43);
		btnInicio.addActionListener(e -> {
			System.out.println("Diriguiendote a Inicio....");
			V_inicio inicio = new V_inicio(cliente);
			dispose();
		});
		panelLateral.add(btnInicio);
		/*
		 * Catalogo boton
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		JButton btnCatalogo = new JButton("");
		btnCatalogo.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/catalogo.png")));
		btnCatalogo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCatalogo.setBackground(new Color(203, 41, 41));
		btnCatalogo.setForeground(new Color(255, 255, 255));
		btnCatalogo.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnCatalogo.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnCatalogo);
		btnCatalogo.setBounds(10, 250, 248, 43);
		btnCatalogo.setVisible(false);
		btnCatalogo.addActionListener(e -> {
			System.out.println("Diriguiendote a catalogo....");
			V_catalogo catalogo = new V_catalogo(cliente);
			dispose();

		});
		panelLateral.add(btnCatalogo);
		/*
		 * Alquilar boton
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		JButton btnalquilar = new JButton("");
		btnalquilar.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/alquilar.png")));
		btnalquilar.setHorizontalAlignment(SwingConstants.LEFT);
		btnalquilar.setBackground(new Color(203, 41, 41));
		btnalquilar.setForeground(new Color(255, 255, 255));
		btnalquilar.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnalquilar.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnalquilar);
		btnalquilar.setVisible(false);
		btnalquilar.setBounds(10, 292, 248, 43);
		btnalquilar.addActionListener(e -> {
			System.out.println("Diriguiendote a alquilar....");
			V_alquilar alquilarv = new V_alquilar(cliente);
			dispose();

		});
		panelLateral.add(btnalquilar);
		/*
		 * Comprar boton
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		JButton btnComprar = new JButton("");
		btnComprar.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/carrito.png")));
		btnComprar.setHorizontalAlignment(SwingConstants.LEFT);
		btnComprar.setBackground(new Color(203, 41, 41));
		btnComprar.setForeground(new Color(255, 255, 255));
		btnComprar.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnComprar.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnComprar);
		btnComprar.setBounds(10, 333, 248, 43);
		btnComprar.setVisible(false);
		btnComprar.addActionListener(e -> {
			System.out.println("Diriguiendote a comprar....");
			V_compra ComprarV = new V_compra(cliente);
			dispose();
		});
		panelLateral.add(btnComprar);
		/*
		 * Salir boton
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		JButton btnsalir = new JButton("");
		btnsalir.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/salir.png")));
		btnsalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnsalir.setBackground(new Color(203, 41, 41));
		btnsalir.setForeground(new Color(255, 255, 255));
		btnsalir.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnsalir.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnsalir);
		btnsalir.setBounds(10, 686, 248, 56);
		btnsalir.setVisible(false);
		btnsalir.addActionListener(e -> {
			System.out.println("Cerrando Sesiom....");
			V_IniciarSesion InciarSesion = new V_IniciarSesion();
			InciarSesion.setVisible(true);
			InciarSesion.setResizable(false);
			InciarSesion.setLocationRelativeTo(null);
			dispose();
		});
		panelLateral.add(btnsalir);
		/*
		 * Mis datos boton
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		JButton btnMisdatos = new JButton("");
		btnMisdatos.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/mis datos.png")));
		btnMisdatos.setHorizontalAlignment(SwingConstants.LEFT);
		btnMisdatos.setBackground(new Color(203, 41, 41));
		btnMisdatos.setForeground(new Color(255, 255, 255));
		btnMisdatos.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnMisdatos.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnMisdatos);
		btnMisdatos.setBounds(10, 376, 248, 43);
		btnMisdatos.setVisible(false);
		btnMisdatos.addActionListener(e -> {
			System.out.println("Diriguiendote a Mis datos....");
			V_misdatos misDatos = new V_misdatos(cliente);
			dispose();
			System.out.println("**Mis datos**");
			System.out.println("* DNI: " + cliente.getDNI());
			System.out.println("* Nombre: " + cliente.getNombre());
			System.out.println("* Apellido: " + cliente.getApellido());
			System.out.println("* Contraseña: " + cliente.getcontraseña());
			System.out.println("* Telefono: " + cliente.getTelefono());
			System.out.println("* Año del carnet: " + cliente.getAñodelCarnet() + "\n");
			System.out.println("* Mi rol es:  " + cliente.getrol());
		});
		panelLateral.add(btnMisdatos);
		/*
		 * 
		 * Boton desplegar menu
		 * 
		 * 
		 * 
		 * 
		 */
		JButton btnmenu = new JButton("");
		btnmenu.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/menu_icon.png")));
		btnmenu.setBorder(new LineBorder(new Color(203, 41, 41), 0)); // Ajusta el borde si es necesario
		btnmenu.setBorderPainted(false); // Quita el borde
		btnmenu.setBackground(new Color(203, 41, 41));
		btnmenu.setBounds(20, 117, 59, 67);
		panelLateral.add(btnmenu);

		JLabel lbllogo = new JLabel("");
		lbllogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogo.setIcon(new ImageIcon(V_inicio.class.getResource("/imagenes/logo_3_alto.png")));
		lbllogo.setBounds(0, 0, 100, 113);
		lbllogo.setVisible(true);
		panelLateral.add(lbllogo);

		JLabel lbllogo2 = new JLabel("");
		lbllogo2.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogo2.setBounds(0, 0, 302, 113);
		panelLateral.add(lbllogo2);
		lbllogo2.setIcon(new ImageIcon(V_inicio.class.getResource("/imagenes/logo_3_grande.png")));
		lbllogo2.setVisible(false);
		/*
		 * Fin panel lateral
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		JLabel lblcarretera = new JLabel("");
		lblcarretera.setIcon(new ImageIcon(V_alquilar.class.getResource("/imagenes/carretera.png")));
		lblcarretera.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarretera.setBounds(135, 254, 135, 500);
		frameGeneral.add(lblcarretera);
		lblcarretera.setVisible(true);
		
		JLabel lblcarretera2 = new JLabel("");
		lblcarretera2.setIcon(new ImageIcon(V_alquilar.class.getResource("/imagenes/carretera.png")));
		lblcarretera2.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarretera2.setBounds(135, 44, 135, 442);
		frameGeneral.add(lblcarretera2);
		lblcarretera2.setVisible(true);

		
		JPanel panelsuperior = new JPanel();
		panelsuperior.setBackground(new Color(24, 2, 3));
//		panel_2.setBackground(new Color(203, 41, 41));
		panelsuperior.setBounds(58, 0, 1460, 44);
		frameGeneral.add(panelsuperior);
		panelsuperior.setLayout(null);

		JLabel lblbienvenido = new JLabel("Bienvenido/a  " + cliente.getNombre());
		lblbienvenido.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblbienvenido.setBounds(418, 65, 381, 61);
		frameGeneral.add(lblbienvenido);

		JPanel panelacceso = new JPanel();
		panelacceso.setBackground(new Color(203, 41, 41));
		panelacceso.setBounds(398, 127, 999, 78);
		frameGeneral.add(panelacceso);
		panelacceso.setLayout(null);

		JLabel lblAcceso = new JLabel("Acceso concedido como:  " + cliente.getrol());

		lblAcceso.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblAcceso.setForeground(new Color(255, 255, 255));
		lblAcceso.setBounds(22, 0, 335, 75);
		panelacceso.add(lblAcceso);

		LocalDateTime fecha = LocalDateTime.now();

		JLabel lblFecha = new JLabel("" + fecha.toLocalDate());
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblFecha.setBounds(812, 21, 154, 41);
		panelacceso.add(lblFecha);

		JPanel panelCentro = new JPanel();
		panelCentro.setBounds(358, 238, 976, 462);
		frameGeneral.add(panelCentro);
		panelCentro.setLayout(null);

		JPanel panelCatalogo = new JPanel();
		panelCatalogo.setBackground(new Color(128, 128, 128));
		panelCatalogo.setBounds(10, 11, 956, 440);

		panelCentro.add(panelCatalogo);
		panelCatalogo.setLayout(null);
		 tabla = new DefaultTableModel(
					new Object[][] {
						{"Matricula", "Marca", "Modelo", "Año", "Color", "Precio","Tipo"},

					},
					new String[] {
							"Matricula", "Marca", "Modelo", "Año", "Color", "Precio","Tipo"
					}
				);
		table = new JTable(tabla);
		table.setFont(new Font("cascadia mono",Font.BOLD, 15));
		actualizarTabla(tabla);
		table.setBounds(35, 30, 886, 385);
		table.enable(false);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setCellSelectionEnabled(false);
        
        scrollPane.setBounds(35, 94, 886, 321);
        panelCatalogo.add(scrollPane);
        
        JButton btncarrito = new JButton("");
        btncarrito.setIcon(new ImageIcon(V_alquilar.class.getResource("/imagenes/alquiler-small.png")));
        btncarrito.setBounds(43, 11, 77, 75);
        panelCatalogo.add(btncarrito);
        btncarrito.setBorderPainted(false);
        btncarrito.setBackground(Color.GRAY);
        btncarrito.addActionListener(e ->{
      
        	seleccionarVehiculo();
         });
        
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(203,41,41));
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);
        header.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		panelCatalogo.add(btncarrito);
		
		JButton btncomprar = new JButton("");
		btncomprar.setIcon(new ImageIcon(V_alquilar.class.getResource("/iconos/confirmacion compra-small-small.png")));
		btncomprar.setBorderPainted(false);
		btncomprar.setBackground(Color.GRAY);
		btncomprar.setBounds(844, 11, 77, 75);

		// Registro del ActionListener
		btncomprar.addActionListener(e -> {
		    int opcion = JOptionPane.showConfirmDialog(null, "Seras redirigido/a a la pagina de confirmacion de pago", "Confirmacion", JOptionPane.YES_NO_OPTION);
		    if (opcion == 0) {
				V_ConfirmacionCompraAlquiler v_ConfirmacionCompraAlquiler = new V_ConfirmacionCompraAlquiler(cliente,matriculas,true,dias );
				v_ConfirmacionCompraAlquiler.setBounds(0, 0, 976, 462);
				for(Component component : panelCentro.getComponents()) {
					if (component instanceof JPanel) {
						panelCentro.remove(component);
						
					}
				}
				panelCentro.add(v_ConfirmacionCompraAlquiler);
				panelCentro.revalidate();
				panelCentro.repaint();
		    	
		    }
		});
		panelCatalogo.add(btncomprar);

		btnInicio.setVisible(true);
		btnCatalogo.setVisible(true);
		btnalquilar.setVisible(true);
		btnComprar.setVisible(true);
		btnsalir.setVisible(true);
		btnMisdatos.setVisible(true);
	    /*
         * Funcion de el boton de desplegar menu
         * 
         *  
         *  
         *  
         *  */
        btnmenu.addActionListener(e -> {
            if (!pulsado) {
                btnInicio.setText("Inicio");
                btnInicio.setBackground(new Color(203, 41, 41));

                btnCatalogo.setText("Ver catalogo");
                btnCatalogo.setBackground(new Color(203, 41, 41));

                btnalquilar.setText("Alquilar");
                btnalquilar.setBackground(new Color(203, 41, 41));

                btnComprar.setText("Comprar");
                btnComprar.setBackground(new Color(203, 41, 41));

                btnsalir.setText("Salir");
                btnsalir.setBackground(new Color(203, 41, 41));

                btnMisdatos.setText("Mis datos");
                btnMisdatos.setBackground(new Color(203, 41, 41));

                lbllogo.setVisible(false);
                lbllogo2.setVisible(true);

                lblcarretera.setVisible(false);
                lblcarretera2.setVisible(false);
                AnimacionBarraLateral(panelLateral, 280, 10, 5);

                pulsado = true;
            } else {
                AnimacionBarraLateral(panelLateral, 93, 10, 5);
                btnInicio.setText("");
                btnCatalogo.setText("");
                btnalquilar.setText("");
                btnComprar.setText("");
                btnsalir.setText("");
                btnMisdatos.setText("");

                lbllogo.setVisible(true);
                lbllogo2.setVisible(false);

                lblcarretera.setVisible(true);
                lblcarretera2.setVisible(true);

                pulsado = false;
            }
        });
        /*
         * Fin de la funcion 
         * 
         * 
         * 
         * 
         * */
    }

    private void AnimacionBarraLateral(JComponent component, int AnchoFinal, int frames, int intervalo) {
        Timer timer = new Timer(intervalo, new ActionListener() {
            int Ancho = component.getWidth();
            int TransicionAncho = (AnchoFinal - Ancho) / frames;
            int ContadorFrame = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (ContadorFrame < frames) {
                    Ancho += TransicionAncho;
                    component.setSize(Ancho, component.getHeight());
                    component.revalidate();
                    component.repaint();
                    ContadorFrame++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
 
	public boolean mensaje(boolean opc) {
		if(opc == true) {
			JOptionPane.showMessageDialog(null, "Operacion aprobada.", "", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Operacion denegada, vuelve a intentarlo", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return opc;
	}
	 public void actualizarTabla(DefaultTableModel tabla) {
			String sSQL = "SELECT * FROM VEHICULOS";
			tabla = new DefaultTableModel(null, titulos);
			ConexionBD msql = new ConexionBD();
			Connection con = msql.conectar();
//			tabla.addRow(titulos);
	        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
	        
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sSQL);
				while(rs.next()) {
					if(rs.getString("Comprado-Alquilado").equalsIgnoreCase("Si")) { // Si esta comprado alquilado no se añade
						continue;
					}
					datos[0]=rs.getString("Matricula");
					datos[1]=rs.getString("Marca");
					datos[2]=rs.getString("Modelo");
					datos[3]=rs.getString("Año");
					datos[4]=rs.getString("Color");
					datos[5]=rs.getString("Precio");
					datos[6]=rs.getString("Tipo");
					tabla.addRow(datos);
				}

				table.setModel(tabla);
			} catch (SQLException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "error " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	 }
	 public boolean seleccionarVehiculo() {
	        String buscar = JOptionPane.showInputDialog("Introduce la matricula del vehiculo que quieres alquilar: ");
	        System.out.println("Matricula introducida: " + buscar);
	        for(String matriculas:matriculas) {
	        	if (matriculas.equalsIgnoreCase(buscar)) {
					JOptionPane.showMessageDialog(null, "Vehiculo ya seleccionado ", "ERROR", JOptionPane.ERROR_MESSAGE);
                     return false;
				}
	        }
	        if (new ConexionBD().existeVehiculo(buscar) == false || new ConexionBD().sePuedeComprarAlquilar(buscar) == false) {
	        	JOptionPane.showMessageDialog(null, "Vehiculo no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
	        int dia = 1;
	        if (new ConexionBD().existeVehiculo(buscar)) {
	        	try {
	               dia = Integer.parseInt(JOptionPane.showInputDialog("Introduce cuantos dias quieres alquilar el vehiculo: "));
	               if(dia == 0) {
						JOptionPane.showMessageDialog(null, "No puedes alquilar un coche 0 dias ", "ERROR", JOptionPane.ERROR_MESSAGE);
						return false;
	               }else if(dia < 0) {
						JOptionPane.showMessageDialog(null, "No puedes alquilar un coche dias negativos", "ERROR", JOptionPane.ERROR_MESSAGE);
						return false;
	               }else {
	            	   this.dias.add(dia);
	            	   System.out.println("Dias introducidos: " + this.dias);
	               }
				} catch (Exception e) {
					System.out.println("Fallo al obtener numero de dias: " + e.getMessage());
					JOptionPane.showMessageDialog(null, "No se considera un dia valido ", "ERROR", JOptionPane.ERROR_MESSAGE);
					return false;
				}

			}
	         
	        int resultado = JOptionPane.showConfirmDialog(null, String.format("¿Se confirmara el alquiler estas seguro?\nEl coste seria %.2f €",((new ConexionBD().BuscarPrecio(buscar)*0.5)/100)*dia), "Confirmacion", JOptionPane.YES_NO_OPTION);
	        if(resultado == 0) {
	        	mensaje(true);
	        	matriculas.add(buscar);
	        	System.out.println("Se ha confirmado el alquiler.");
	        }else {
	        	mensaje(false);
	        	System.out.println("Se ha cancelado el alquiler.");
	        }
	        //
	        actualizarTabla(tabla);
	        return true;
	 }
	   static class CustomTableCellRenderer extends DefaultTableCellRenderer { // Cambiar de color la tabla
	         
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        
	                cell.setBackground(Color.LIGHT_GRAY);  // Color de fondo por defecto
	                cell.setForeground(Color.WHITE);  // Color del texto por defecto

	            return cell;
	        }
	    }
}
