
package GUI;
import Clases.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Event;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.Button;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class V_misdatosAdmin extends JFrame {
	boolean pulsado = false;
    private static Cliente cliente = new Cliente();
	private JPanel contentPane;
	private final JPanel framegeneral = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_misdatosAdmin frame = new V_misdatosAdmin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public V_misdatosAdmin(Cliente cliente2) {
        this.cliente = cliente2;
        main(null);
	}
	/**
	 * Create the frame.
	 */
	
	/**
	 * falta cambiar botones lateral
	 * */
	public V_misdatosAdmin() {
		setTitle("Clicars");
		setIconImage(Toolkit.getDefaultToolkit().getImage(V_misdatosAdmin.class.getResource("/imagenes/2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1413, 793);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		framegeneral.setBackground(new Color(192, 192, 192));
		framegeneral.setBounds(0, 0, 1397, 754);
		contentPane.add(framegeneral);
		framegeneral.setLayout(null);

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
		framegeneral.add(panelLateral);
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
		lblcarretera.setIcon(new ImageIcon(V_misdatosAdmin.class.getResource("/imagenes/carretera.png")));
		lblcarretera.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarretera.setBounds(135, 254, 135, 500);
		framegeneral.add(lblcarretera);
		lblcarretera.setVisible(true);
		
		JLabel lblcarretera2 = new JLabel("");
		lblcarretera2.setIcon(new ImageIcon(V_misdatosAdmin.class.getResource("/imagenes/carretera.png")));
		lblcarretera2.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarretera2.setBounds(135, 44, 135, 442);
		framegeneral.add(lblcarretera2);
		lblcarretera2.setVisible(true);

		
		JPanel panelsuperior = new JPanel();
		panelsuperior.setBackground(new Color(24, 2, 3));
//		panel_2.setBackground(new Color(203, 41, 41));
		panelsuperior.setBounds(58, 0, 1460, 44);
		framegeneral.add(panelsuperior);
		panelsuperior.setLayout(null);

		JLabel lblbienvenido = new JLabel("Bienvenido/a  " + cliente.getNombre());
		lblbienvenido.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblbienvenido.setBounds(418, 65, 381, 61);
		framegeneral.add(lblbienvenido);

		JPanel panelacceso = new JPanel();
		panelacceso.setBackground(new Color(203, 41, 41));
		panelacceso.setBounds(398, 127, 999, 78);
		framegeneral.add(panelacceso);
		panelacceso.setLayout(null);

		JLabel lblacceso = new JLabel("Acceso concedido como:  Administrador");

		lblacceso.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblacceso.setForeground(new Color(255, 255, 255));
		lblacceso.setBounds(22, 0, 514, 75);
		panelacceso.add(lblacceso);

		LocalDateTime fecha = LocalDateTime.now();

		JLabel lblFecha = new JLabel("" + fecha.toLocalDate());
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblFecha.setBounds(812, 21, 154, 41);
		panelacceso.add(lblFecha);

		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(358, 238, 976, 462);
		framegeneral.add(panelCentral);
		panelCentral.setLayout(null);

		JPanel panelMiinformacion = new JPanel();
		panelMiinformacion.setBackground(new Color(128, 128, 128));
		panelMiinformacion.setBounds(10, 11, 956, 440);
		panelCentral.add(panelMiinformacion);
		panelMiinformacion.setLayout(null);
		
		JLabel lblmiinformacion = new JLabel("  Mi información:");
		lblmiinformacion.setIcon(new ImageIcon(V_misdatosAdmin.class.getResource("/iconos/mis datos.png")));
		lblmiinformacion.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblmiinformacion.setBounds(43, 11, 215, 81);
		panelMiinformacion.add(lblmiinformacion);
		
		JLabel lbldni = new JLabel("DNI: " + cliente.getDNI());
		lbldni.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lbldni.setBounds(70, 170, 272, 32);
		panelMiinformacion.add(lbldni);
		
		JLabel lblapellido = new JLabel("Apellido: " + cliente.getApellido());
		lblapellido.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblapellido.setBounds(70, 288, 272, 32);
		panelMiinformacion.add(lblapellido);
		
		JLabel lblnombre = new JLabel("Nombre: " + cliente.getNombre());
		lblnombre.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblnombre.setBounds(70, 226, 272, 32);
		panelMiinformacion.add(lblnombre);
		
		JLabel lblañocarnet = new JLabel("Año del carnet: " + cliente.getAñodelCarnet());
		lblañocarnet.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblañocarnet.setBounds(368, 288, 272, 32);
		panelMiinformacion.add(lblañocarnet);
		
		JLabel lbltelefono = new JLabel("Telefono: " + cliente.getTelefono());
		lbltelefono.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lbltelefono.setBounds(368, 226, 272, 32);
		panelMiinformacion.add(lbltelefono);
		
		JLabel lblcontraseña = new JLabel("Contraseña: " + cliente.getcontraseña());
		lblcontraseña.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblcontraseña.setBounds(368, 170, 272, 32);
		panelMiinformacion.add(lblcontraseña);
		
		JLabel lblrol = new JLabel("Rol: Administrador");
		lblrol.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblrol.setBounds(361, 35, 272, 32);
		panelMiinformacion.add(lblrol);
		
		JLabel lblfotousuario = new JLabel("");
		lblfotousuario.setIcon(new ImageIcon(V_misdatosAdmin.class.getResource("/imagenes/perfil.png")));
		lblfotousuario.setBounds(638, 103, 272, 272);
		panelMiinformacion.add(lblfotousuario);
		
		
		/*
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


}
