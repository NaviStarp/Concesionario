package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Clases.*;
import BD.*;

public class V_Registro extends JFrame {

	private JPanel frameGeneral;
	private JFormattedTextField txtdni;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtañocarnet;
	private JTextField txttlf;
	private JFormattedTextField txtcontraseña;
	private Cliente cliente;

	public static void main(String[] args) {

		try {
			V_Registro frame = new V_Registro();
			frame.setUndecorated(false);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public V_Registro() {
		setTitle("Clicars");
		setIconImage(Toolkit.getDefaultToolkit().getImage(V_Registro.class.getResource("/imagenes/2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 522);
		frameGeneral = new JPanel();
		frameGeneral.setBackground(new Color(203, 41, 41));
		frameGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(frameGeneral);
		frameGeneral.setLayout(null);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBackground(new Color(178, 34, 34));
		btnRegistrarse.setBounds(527, 393, 179, 41);
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setOpaque(true);
		btnRegistrarse.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mandar();
			}
		});
		frameGeneral.add(btnRegistrarse);

		// Placeholder para DNI
		txtdni = new JFormattedTextField();
		addPlaceholder(txtdni, "DNI");
		txtdni.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		txtdni.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		txtdni.setColumns(10);
		txtdni.setBounds(341, 138, 241, 41);
		txtdni.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					mandar();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		frameGeneral.add(txtdni);

		// Placeholder para Nombre
		txtnombre = new JTextField();
		addPlaceholder(txtnombre, "Nombre");
		txtnombre.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		txtnombre.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		txtnombre.setColumns(10);
		txtnombre.setBounds(341, 224, 241, 41);
		txtnombre.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					mandar();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		frameGeneral.add(txtnombre);

		// Placeholder para Apellido
		txtapellido = new JTextField();
		addPlaceholder(txtapellido, "Apellido");
		txtapellido.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		txtapellido.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		txtapellido.setColumns(10);
		txtapellido.setBounds(341, 312, 241, 41);
		txtapellido.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					mandar();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		frameGeneral.add(txtapellido);

		// Placeholder para Telefono
		txttlf = new JTextField();
		addPlaceholder(txttlf, "Telefono");
		txttlf.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		txttlf.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		txttlf.setColumns(10);
		txttlf.setBounds(649, 224, 241, 41);
		txttlf.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					mandar();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		frameGeneral.add(txttlf);

		// Placeholder para Año del Carnet
		txtañocarnet = new JTextField();
		addPlaceholder(txtañocarnet, "Año del Carnet");
		txtañocarnet.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		txtañocarnet.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		txtañocarnet.setColumns(10);
		txtañocarnet.setBounds(649, 312, 241, 41);
		txtañocarnet.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					mandar();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		frameGeneral.add(txtañocarnet);

		// Placeholder para Contraseña
		txtcontraseña = new JFormattedTextField();
		addPlaceholder(txtcontraseña, "Contraseña");
		txtcontraseña.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		txtcontraseña.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		txtcontraseña.setColumns(10);
		txtcontraseña.setBounds(649, 138, 241, 41);
		txtcontraseña.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					mandar();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		frameGeneral.add(txtcontraseña);

		JLabel lblañocarnet = new JLabel("Año del Carnet: ");
		lblañocarnet.setForeground(new Color(255, 255, 255));
		lblañocarnet.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblañocarnet.setBounds(649, 278, 269, 23);
		frameGeneral.add(lblañocarnet);

		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblTelefono.setBounds(649, 190, 211, 23);
		frameGeneral.add(lblTelefono);

		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblDni.setBounds(341, 101, 103, 23);
		frameGeneral.add(lblDni);

		JLabel lblcontraseña = new JLabel("Contraseña: ");
		lblcontraseña.setForeground(new Color(255, 255, 255));
		lblcontraseña.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblcontraseña.setBounds(649, 101, 167, 23);
		frameGeneral.add(lblcontraseña);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblApellido.setBounds(341, 278, 202, 23);
		frameGeneral.add(lblApellido);

		JLabel lblnombre = new JLabel("Nombre: ");
		lblnombre.setForeground(new Color(255, 255, 255));
		lblnombre.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblnombre.setBounds(341, 190, 103, 23);
		frameGeneral.add(lblnombre);

		JPanel frameLateral = new JPanel();
		frameLateral.setBackground(new Color(24, 2, 3));
		frameLateral.setBounds(0, 0, 292, 596);
		frameGeneral.add(frameLateral);
		frameLateral.setLayout(null);

		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(V_Registro.class.getResource("/imagenes/logo3.png")));
		lbllogo.setBounds(26, 74, 266, 225);
		frameLateral.add(lbllogo);

		JButton btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setBackground(new Color(178, 34, 34));
		btnIniciarSesion.setBounds(62, 293, 179, 41); // Ajusta la posición y el tamaño según sea necesario
		btnIniciarSesion.setBorder(new LineBorder(Color.BLACK, 3)); // Añade un borde negro
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setOpaque(true);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Oculta la ventana actual
				setVisible(false);
				setLocationRelativeTo(null);
				setResizable(false);
				System.out.println("Saliendo del registro....");

				// Crea una instancia de la ventana de inicio de sesión
				V_IniciarSesion ventanaInicioSesion = new V_IniciarSesion();
				ventanaInicioSesion.setVisible(true);
				ventanaInicioSesion.setLocationRelativeTo(null);
				ventanaInicioSesion.setResizable(false);
				System.out.println("Entrando en Iniar Sesion....");
			}
		});

		btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnIniciarSesion.setBackground(new Color(255, 4, 2)); // Cambia el color cuando el mouse entra
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnIniciarSesion.setBackground(new Color(178, 34, 34)); // Vuelve al color original cuando el mouse sale
			}
		});
		frameLateral.add(btnIniciarSesion);

		JLabel lbltituloRegistro = new JLabel("Registro");
		lbltituloRegistro.setForeground(new Color(255, 255, 255));
		lbltituloRegistro.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 27));
		lbltituloRegistro.setBounds(341, 22, 269, 52);
		frameGeneral.add(lbltituloRegistro);
	}

	private void addPlaceholder(JTextField textField, String placeholderText) {
		textField.setText(placeholderText);
		textField.setForeground(Color.GRAY);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(placeholderText)) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().isEmpty()) {
					textField.setText(placeholderText);
					textField.setForeground(Color.GRAY);
				}
			}
		});
	}

	private boolean validarCampos() {
		System.out.println("Validando campos.... ");
		if (txtdni.getText().equals("DNI") || txtnombre.getText().equals("Nombre")
				|| txtapellido.getText().equals("Apellido") || txttlf.getText().equals("Telefono")
				|| txtañocarnet.getText().equals("Año del Carnet") || txtcontraseña.getText().equals("Contraseña")) {
			System.out.println("Error al validar campos");
			return false;
		}
		System.out.println("Campos validados correctamente");
		return true; // Todos los campos tienen datos válidos
	}

	private boolean guardarDatos() {
		try {
			int añoDelCarnet = Integer.parseInt(txtañocarnet.getText());

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(V_Registro.this, "Año debe ser solo un numero.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		Cliente cliente = new Cliente(txtdni.getText(), txtnombre.getText(), txtapellido.getText(),
				txtcontraseña.getText(), txttlf.getText(), Integer.parseInt(txtañocarnet.getText()));
		this.cliente = cliente;
		if (!(new ConexionBD().crearUsuario(cliente, false))) {
			main(null);
			dispose();
			return false;
		}
		return true;
	}

	public void mandar() {
		boolean camposValidos = validarCampos();
		if (camposValidos && guardarDatos()) {

			dispose();
			JOptionPane.showMessageDialog(V_Registro.this, "Registro exitoso.", "OK", JOptionPane.INFORMATION_MESSAGE);
			new V_inicio(cliente);
		} else {
			JOptionPane.showMessageDialog(V_Registro.this,
					"Fallo al registrar,todos los campos tienen que estar rellenados y validos.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
