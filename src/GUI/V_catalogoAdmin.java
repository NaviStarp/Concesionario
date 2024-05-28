package GUI;
import Clases.*;
import BD.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTable;

public class V_catalogoAdmin extends JFrame {
	boolean pulsado = false;
    private static Cliente cliente = new Cliente();
	private JPanel contentPane;
	private final JPanel frameGeneral = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	DefaultTableModel tabla;
	String[] titulos = {"Matricula", "Marca", "Modelo", "Año", "Color", "Precio", "Tipo","Comprado-alquilado","Dni-propietario","FechaFinAlquiler"};
	String[] datos = new String[10];

// lanzar aplicacion
	public static void main(String[] args) {
				try {
					V_catalogoAdmin frame = new V_catalogoAdmin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
	
	}

	/**
	 * Crear marco
	 */
	public V_catalogoAdmin(Cliente cliente) {
        this.cliente = cliente; 
		main(null);
	}
	public V_catalogoAdmin() {
		setTitle("Clicars");
		setIconImage(Toolkit.getDefaultToolkit().getImage(V_catalogoAdmin.class.getResource("/imagenes/2.png")));
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
		JToggleButton btnInicioadmin = new JToggleButton("");
		btnInicioadmin.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/coche (2).png")));
		btnInicioadmin.setHorizontalAlignment(SwingConstants.LEFT);
		btnInicioadmin.setBackground(new Color(203, 41, 41));
		btnInicioadmin.setForeground(new Color(255, 255, 255));
		btnInicioadmin.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 15));
		btnInicioadmin.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnInicioadmin);
		btnInicioadmin.setVisible(false);
		btnInicioadmin.setBounds(10, 208, 248, 43);
		btnInicioadmin.addActionListener(e -> {
			System.out.println("Dirigiendote a Inicio Admini....");
            V_inicioAdmin inicioAdmin = new V_inicioAdmin(cliente);
            dispose();
		});
		panelLateral.add(btnInicioadmin);
		/*
		 * Catalogo boton
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		JButton btnCatalogoadmin = new JButton("");
		btnCatalogoadmin.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/catalogo.png")));
		btnCatalogoadmin.setHorizontalAlignment(SwingConstants.LEFT);
		btnCatalogoadmin.setBackground(new Color(203, 41, 41));
		btnCatalogoadmin.setForeground(new Color(255, 255, 255));
		btnCatalogoadmin.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 15));
		btnCatalogoadmin.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnCatalogoadmin);
		btnCatalogoadmin.setBounds(10, 250, 248, 43);
		btnCatalogoadmin.setVisible(false);
		btnCatalogoadmin.addActionListener(e -> {
			System.out.println("Dirigiendote a catalogo Admini....");
			V_catalogoAdmin catalogo = new V_catalogoAdmin(cliente);
			dispose();

		});
		panelLateral.add(btnCatalogoadmin);
		/*
		 * Alquilar boton
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		JButton btngesusuarios = new JButton("");
		btngesusuarios.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/usuario2.png")));
		btngesusuarios.setHorizontalAlignment(SwingConstants.LEFT);
		btngesusuarios.setBackground(new Color(203, 41, 41));
		btngesusuarios.setForeground(new Color(255, 255, 255));
		btngesusuarios.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 15));
		btngesusuarios.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btngesusuarios);
		btngesusuarios.setVisible(false);
		btngesusuarios.setBounds(10, 292, 248, 43);
		btngesusuarios.addActionListener(e -> {
			System.out.println("Dirigiendote a Gestion de usuarios....");
			V_gesUsuarios gesUsuarios = new V_gesUsuarios(cliente);
			dispose();

		});
		panelLateral.add(btngesusuarios);
		/*
		 * Comprar boton
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		JButton btngesvehiculos = new JButton("");
		btngesvehiculos.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/coche.png")));
		btngesvehiculos.setHorizontalAlignment(SwingConstants.LEFT);
		btngesvehiculos.setBackground(new Color(203, 41, 41));
		btngesvehiculos.setForeground(new Color(255, 255, 255));
		btngesvehiculos.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 15));
		btngesvehiculos.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btngesvehiculos);
		btngesvehiculos.setBounds(10, 333, 248, 43);
		btngesvehiculos.setVisible(false);
		btngesvehiculos.addActionListener(e -> {
			System.out.println("Dirigiendote a Gestion de Vehiculos....");
			V_gesVehiculos vGesVehiculos = new V_gesVehiculos(cliente);
			dispose();
		});
		panelLateral.add(btngesvehiculos);
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
		btnsalir.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 15));
		btnsalir.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnsalir);
		btnsalir.setBounds(10, 686, 248, 56);
		btnsalir.setVisible(false);
		btnsalir.addActionListener(e -> {
			System.out.println("Cerrando Sesión....");
			V_IniciarSesion InciarSesion = new V_IniciarSesion();
			InciarSesion.setVisible(true);
			InciarSesion.setResizable(false);
			InciarSesion.setLocationRelativeTo(null);
			dispose();
			System.out.println("Sesion cerrada correctamente.... \nHasta proto Administrador 👋");
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
		JButton btnMisdatosadmin = new JButton("");
		btnMisdatosadmin.setIcon(new ImageIcon(V_inicio.class.getResource("/iconos/mis datos.png")));
		btnMisdatosadmin.setHorizontalAlignment(SwingConstants.LEFT);
		btnMisdatosadmin.setBackground(new Color(203, 41, 41));
		btnMisdatosadmin.setForeground(new Color(255, 255, 255));
		btnMisdatosadmin.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 15));
		btnMisdatosadmin.setBorderPainted(false); // Quita el borde
		buttonGroup.add(btnMisdatosadmin);
		btnMisdatosadmin.setBounds(10, 376, 248, 43);
		btnMisdatosadmin.setVisible(false);
		btnMisdatosadmin.addActionListener(e -> {
			V_misdatosAdmin misDatos = new V_misdatosAdmin(cliente);
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
		panelLateral.add(btnMisdatosadmin);
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
		lblcarretera.setIcon(new ImageIcon(V_catalogoAdmin.class.getResource("/imagenes/carretera.png")));
		lblcarretera.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarretera.setBounds(135, 254, 135, 500);
		frameGeneral.add(lblcarretera);
		lblcarretera.setVisible(true);
		
		JLabel lblcarretera2 = new JLabel("");
		lblcarretera2.setIcon(new ImageIcon(V_catalogoAdmin.class.getResource("/imagenes/carretera.png")));
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

		JLabel lblAcceso = new JLabel("Acceso concedido como: Administrador");

		lblAcceso.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblAcceso.setForeground(new Color(255, 255, 255));
		lblAcceso.setBounds(22, 0, 519, 75);
		panelacceso.add(lblAcceso);

		LocalDateTime fecha = LocalDateTime.now();

		JLabel lblFecha = new JLabel("" + fecha.toLocalDate());
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblFecha.setBounds(812, 21, 154, 41);
		panelacceso.add(lblFecha);

		JPanel panelCentro = new JPanel();
		panelCentro.setBounds(358, 238, 1010, 462);
		frameGeneral.add(panelCentro);
		panelCentro.setLayout(null);

		/*
		 * 
		 * Tabla del catalogo
		 * 
		 * */
		JPanel panelCatalogo = new JPanel();
		panelCatalogo.setBackground(new Color(128, 128, 128));
		panelCatalogo.setBounds(10, 11, 979, 440);
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
        
        scrollPane.setBounds(20, 30, 937, 385);
        panelCatalogo.add(scrollPane);
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(203,41,41));
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);
        header.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		/*
		 * Fin de la tabla 
		 * Inicio de las funciones de los botones
		 * 
		 * 
		 * */
		btnInicioadmin.setVisible(true);
		btnCatalogoadmin.setVisible(true);
		btngesusuarios.setVisible(true);
		btngesvehiculos.setVisible(true);
		btnsalir.setVisible(true);
		btnMisdatosadmin.setVisible(true);
        /*
         * Funcion de el boton de desplegar menu
         * 
         *  
         *  
         *  
         *  */
		btnmenu.addActionListener(e -> {
			if (!pulsado) {
				btnInicioadmin.setText("Inicio");
				btnInicioadmin.setBackground(new Color(203, 41, 41));

				btnCatalogoadmin.setText("Ver catalogo");
				btnCatalogoadmin.setBackground(new Color(203, 41, 41));

				btngesusuarios.setText("Gestionar usuarios");
				btngesusuarios.setBackground(new Color(203, 41, 41));

				btngesvehiculos.setText("Gestionar vehiculos");
				btngesvehiculos.setBackground(new Color(203, 41, 41));

				btnsalir.setText("Salir");
				btnsalir.setBackground(new Color(203, 41, 41));

				btnMisdatosadmin.setText("Mis datos");
				btnMisdatosadmin.setBackground(new Color(203, 41, 41));

				lbllogo.setVisible(false);
				lbllogo2.setVisible(true);

				lblcarretera.setVisible(false);
				lblcarretera2.setVisible(false);
				AnimacionBarraLateral(panelLateral, 300, 10, 5);

				pulsado = true;
			} else {
				AnimacionBarraLateral(panelLateral, 93, 10, 5);
				btnInicioadmin.setText("");
				btnCatalogoadmin.setText("");
				btngesusuarios.setText("");
				btngesvehiculos.setText("");
				btnsalir.setText("");
				btnMisdatosadmin.setText("");

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
		 */
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
	 public void actualizarTabla(DefaultTableModel tabla) {
			String sSQL = "";
			tabla = new DefaultTableModel(null, titulos);
			ConexionBD msql = new ConexionBD();
			Connection con = msql.conectar();
			sSQL = "SELECT * FROM vehiculos";
			try {
				Statement st = con.createStatement();
				ResultSet rs =st.executeQuery(sSQL);
				while(rs.next()) {
					datos[0]=rs.getString("Matricula");
					datos[1]=rs.getString("Marca");
					datos[2]=rs.getString("Modelo");
					datos[3]=rs.getString("Año");
					datos[4]=rs.getString("Color");
					datos[5]=rs.getString("Precio");
					datos[6]=rs.getString("Tipo");
					datos[7] = rs.getString("Comprado-alquilado");
					String dni = rs.getString("DNI-PROPIETARIO");
					datos[8] = "--";
					if(dni !=null) {
						datos[8] = dni;
					}
				
					Date d = rs.getDate("FechaFinAlquiler");
					datos[9] ="---";
					if(d !=null) {
				        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				        String fecha = dateFormat.format(d);
						datos[9] = fecha;
					 }
					tabla.addRow(datos);
				}
				table.setModel(tabla);
			} catch (SQLException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "error " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	 }
	   static class CustomTableCellRenderer extends DefaultTableCellRenderer {
	         
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        
	                cell.setBackground(Color.LIGHT_GRAY);  // Color de fondo
	                cell.setForeground(Color.WHITE);  // Color del texto

	            return cell;
	        }
	    }
}
