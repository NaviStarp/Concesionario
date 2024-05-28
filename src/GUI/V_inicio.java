package GUI;

import Clases.*;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class V_inicio extends JFrame {
	boolean pulsado = false;
	private static Cliente cliente = new Cliente();
	private JPanel contentPane;
	private final JPanel frameGeneral = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	// lanzar aplicacion
	public static void main(String[] args) {
		try {
			V_inicio frame = new V_inicio();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			

	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public V_inicio(Cliente cliente) {
		this.cliente = cliente;
		main(null);
	}

	public V_inicio() {
		setTitle("Clicars");
		setIconImage(Toolkit.getDefaultToolkit().getImage(V_inicio.class.getResource("/imagenes/2.png")));
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
			System.out.println("Dirigiendote a Inicio....");
			main(null);
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
			catalogo.setResizable(false);
			catalogo.setLocationRelativeTo(null);
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
			alquilarv.setResizable(false);
			alquilarv.setLocationRelativeTo(null);
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
			System.out.println("Dirigiendote a compra....");
			V_compra ComprarV = new V_compra(cliente);
			ComprarV.setResizable(false);
			ComprarV.setLocationRelativeTo(null);
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
			System.out.println("Cerrando Sesión....");
			V_IniciarSesion InciarSesion = new V_IniciarSesion();
			InciarSesion.setResizable(false);
			InciarSesion.setLocationRelativeTo(null);
			dispose();
			System.out.println("Sesion cerrada correctamente.... \nHasta proto👋");
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
			V_misdatos misDatos = new V_misdatos(cliente);
			misDatos.setResizable(false);
			misDatos.setLocationRelativeTo(null);
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
		lblcarretera.setIcon(new ImageIcon(V_inicio.class.getResource("/imagenes/carretera.png")));
		lblcarretera.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarretera.setBounds(135, 254, 135, 500);
		frameGeneral.add(lblcarretera);
		lblcarretera.setVisible(true);

		JLabel lblcarretera2 = new JLabel("");
		lblcarretera2.setIcon(new ImageIcon(V_inicio.class.getResource("/imagenes/carretera.png")));
		lblcarretera2.setHorizontalAlignment(SwingConstants.CENTER);
		lblcarretera2.setBounds(135, 44, 135, 442);
		frameGeneral.add(lblcarretera2);
		lblcarretera2.setVisible(true);

		JPanel panelsuperior = new JPanel();
		panelsuperior.setBackground(new Color(24, 2, 3));
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

		JTextArea txttextointroduccion = new JTextArea();
		txttextointroduccion.setEditable(false);
		txttextointroduccion.setText(
				"¡Bienvenido/a!\r\n\r\nNos alegra tenerte aquí en nuestro concesionario.\r\n\r\nAquí encontrarás una amplia selección de vehículos para satisfacer tus necesidades y gustos.\r\n\r\nNo dudes en explorar nuestro catálogo y descubrir las últimas novedades en automóviles.\r\n\r\nSi necesitas ayuda o tienes alguna pregunta, nuestro equipo estará encantado de asistirte.\r\n\r\n¡Que tengas una excelente experiencia en nuestro concesionario!\r\n\r\nEstamos aquí para hacer que tu búsqueda de vehículos sea emocionante y sin complicaciones. ");
		txttextointroduccion.setForeground(Color.WHITE);
		txttextointroduccion.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 16));
		txttextointroduccion.setBackground(new Color(128, 128, 128));
		txttextointroduccion.setBounds(418, 277, 880, 388);
		frameGeneral.add(txttextointroduccion);

		JPanel panelCentro = new JPanel();
		panelCentro.setBounds(358, 238, 976, 462);
		frameGeneral.add(panelCentro);
		panelCentro.setLayout(null);

		JPanel panelTextoInicio = new JPanel();
		panelTextoInicio.setBackground(new Color(128, 128, 128));
		panelTextoInicio.setBounds(10, 11, 956, 440);
		panelCentro.add(panelTextoInicio);
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
