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

public class V_misdatos extends JFrame {
	boolean pulsado = false;
	private  static Cliente cliente = new Cliente();
	private JPanel contentPane;
	private final JPanel framegeneral = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,Cliente cliente) {
		try {
			V_misdatos frame = new V_misdatos();
			frame.cliente = cliente;
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public V_misdatos(Cliente cliente) {
		this.cliente = cliente;
		if (cliente==null) {
			System.out.println("es nulo");
		}else {
			main(null,cliente);
		}
	
	}

	/**
	 * Create the frame.
	 */
	public V_misdatos() {
		setTitle("Clicars");
		setIconImage(Toolkit.getDefaultToolkit().getImage(V_misdatos.class.getResource("/imagenes/2.png")));
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
			System.out.println("Dirigiendote a inicio....");
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
			System.out.println("Dirigiendote a catalogo....");
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
			System.out.println("Dirigiendote a alquilar....");
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
			System.out.println("Dirigiendote a comprar....");
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
			System.out.println("Cerrando Sesion....");
			V_IniciarSesion InciarSesion = new V_IniciarSesion();
			InciarSesion.setVisible(true);
			InciarSesion.setResizable(false);
			InciarSesion.setLocationRelativeTo(null);
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
			System.out.println("Dirigiendote a Mis datos....");
			V_misdatos misDatos = new V_misdatos();
			dispose();
			misDatos.setVisible(true);
			misDatos.setResizable(false);
			misDatos.setLocationRelativeTo(null);
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
		lblcarretera.setIcon(new ImageIcon(V_misdatos.class.getResource("/imagenes/carretera.png")));
		lblcarretera.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarretera.setBounds(135, 254, 135, 500);
		framegeneral.add(lblcarretera);
		lblcarretera.setVisible(true);

		JLabel lblcarretera2 = new JLabel("");
		lblcarretera2.setIcon(new ImageIcon(V_misdatos.class.getResource("/imagenes/carretera.png")));
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

		JLabel lblacceso = new JLabel("Acceso concedido como:  " + cliente.getrol());

		lblacceso.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblacceso.setForeground(new Color(255, 255, 255));
		lblacceso.setBounds(22, 0, 335, 75);
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
		lblmiinformacion.setIcon(new ImageIcon(V_misdatos.class.getResource("/iconos/mis datos.png")));
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

		JLabel lblrol = new JLabel("Rol: " + cliente.getrol());
		lblrol.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblrol.setBounds(361, 35, 272, 32);
		panelMiinformacion.add(lblrol);

		JLabel lblfotousuario = new JLabel("");
		lblfotousuario.setIcon(new ImageIcon(V_misdatos.class.getResource("/imagenes/perfil.png")));
		lblfotousuario.setBounds(638, 103, 272, 272);
		panelMiinformacion.add(lblfotousuario);

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
		 */
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
