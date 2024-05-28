package GUI;
import Clases.*;
import BD.*;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class V_IniciarSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel framegeneral;
	private JFormattedTextField txtdni;
	private JPasswordField txtcontraseña;
	Cliente cliente = new Cliente();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_IniciarSesion frame = new V_IniciarSesion();
					frame.setUndecorated(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public V_IniciarSesion() {
		setTitle("Clicars");
		setIconImage(Toolkit.getDefaultToolkit().getImage(V_IniciarSesion.class.getResource("/imagenes/2.png")));
		System.out.println("Iniciando aplicacion....");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 522);
		framegeneral = new JPanel();
		framegeneral.setBackground(new Color(203, 41, 41));
		framegeneral.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(framegeneral);
		framegeneral.setLayout(null);

		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setBackground(new Color(178, 34, 34));
		btnIniciarSesion.setBounds(604, 392, 179, 41);
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setOpaque(true);
		btnIniciarSesion.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mandar();
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
		framegeneral.add(btnIniciarSesion);

		// Placeholder para DNI
		txtdni = new JFormattedTextField();
		addPlaceholder(txtdni, "DNI");
		txtdni.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		txtdni.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		txtdni.setColumns(10);
		txtdni.setBounds(569, 183, 241, 41);
		txtdni.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    mandar();
                }
            }
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
        });
		framegeneral.add(txtdni);

		// Placeholder para Contraseña
        txtcontraseña = new JPasswordField();
        addPlaceholder(txtcontraseña, "Contraseña");
        txtcontraseña.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
        txtcontraseña.setBorder(new LineBorder(Color.BLACK, 2));
        txtcontraseña.setColumns(10);
		txtcontraseña.setBounds(569, 282, 241, 41);
        txtcontraseña.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    mandar();
                }
            }
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
        });
		framegeneral.add(txtcontraseña);

		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblDni.setBounds(569, 146, 103, 23);
		framegeneral.add(lblDni);

		JLabel lblcontraseña = new JLabel("Contraseña: ");
		lblcontraseña.setForeground(new Color(255, 255, 255));
		lblcontraseña.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblcontraseña.setBounds(569, 245, 167, 23);
		framegeneral.add(lblcontraseña);

		JPanel framelateral = new JPanel();
		framelateral.setBackground(new Color(24, 2, 3));
		framelateral.setBounds(0, 0, 395, 596);
		framegeneral.add(framelateral);
		framelateral.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(V_IniciarSesion.class.getResource("/imagenes/logo3.png")));
		lblLogo.setBounds(66, 75, 266, 225);
		framelateral.add(lblLogo);

		JButton btnRegistrarte = new JButton("Registrarte");
		btnRegistrarte.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnRegistrarte.setForeground(Color.WHITE);
		btnRegistrarte.setBackground(new Color(178, 34, 34));
		btnRegistrarte.setBounds(102, 294, 179, 41); // Ajusta la posición y el tamaño según sea necesario
		btnRegistrarte.setBorder(new LineBorder(Color.BLACK, 3)); // Añade un borde negro
		btnRegistrarte.setFocusPainted(false);
		btnRegistrarte.setBorderPainted(false);
		btnRegistrarte.setContentAreaFilled(false);
		btnRegistrarte.setOpaque(true);
		btnRegistrarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				V_Registro ventanaRegistro = new V_Registro();
				ventanaRegistro.setVisible(true);
				ventanaRegistro.setLocationRelativeTo(null);
				ventanaRegistro.setResizable(false);
			}
		});

		btnRegistrarte.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnRegistrarte.setBackground(new Color(255, 4, 2)); // Cambia el color cuando el mouse entra
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnRegistrarte.setBackground(new Color(178, 34, 34)); // Vuelve al color original cuando el mouse sale
			}
		});
		framelateral.add(btnRegistrarte);

		JLabel lblTituloIniciarSesion = new JLabel("Inicio Sesión");
		lblTituloIniciarSesion.setForeground(new Color(255, 255, 255));
		lblTituloIniciarSesion.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 27));
		lblTituloIniciarSesion.setBounds(445, 22, 269, 52);
		framegeneral.add(lblTituloIniciarSesion);
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

	private void mandar() {

		boolean camposValidos = validarCampos();
		if (camposValidos) {
			Connection c = new ConexionBD().conectar();
			try {
				String sql = "SELECT * FROM usuarios WHERE dni = ? AND contraseña = ?";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, txtdni.getText());
				ps.setString(2, new String(txtcontraseña.getText()));

				ResultSet rs = ps.executeQuery();


				if (rs.next()) {
					String DNI = rs.getString(1);
					String nombre = rs.getString(2);
					String contraseña = rs.getString(3);
					String apellido = rs.getString(4);
					String telefono = rs.getString(5);
					int año_del_carnet = rs.getInt(6);
					String rol = rs.getString(7);
					if (!(contraseña.equals(txtcontraseña.getText()))) {
						JOptionPane.showMessageDialog(null, "DNI o contraseña incorrectos.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					cliente = new Cliente(DNI, nombre, apellido, contraseña, telefono, año_del_carnet);

					if (rol.equalsIgnoreCase("admin")) {
						dispose();
						V_inicioAdmin v = new V_inicioAdmin(cliente);
						JOptionPane.showMessageDialog(V_IniciarSesion.this, "Inicio de sesión exitoso.", "OK",
								JOptionPane.INFORMATION_MESSAGE);
						System.out.println("Accediendo al sistema de administrador....");
					} else {
						dispose();
						V_inicio v = new V_inicio(cliente);
						JOptionPane.showMessageDialog(V_IniciarSesion.this, "Inicio de sesión exitoso.", "OK",
								JOptionPane.INFORMATION_MESSAGE);
						System.out.println("Accediendo al sistema de cliente....");
					}

				} else {
					JOptionPane.showMessageDialog(null, "DNI o contraseña incorrectos.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error al iniciar sesión.", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.out.println("Error al iniciar sesión");
			}
		} else {
			JOptionPane.showMessageDialog(V_IniciarSesion.this, "Todos los campos deben estar llenos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("Error al iniciar sesión, hay campos vacíos");

		}
	}

	private boolean validarCampos() {
		System.out.println("Validando campos.... ");
		if (txtdni.getText().equals("DNI") || txtcontraseña.getText().equals("Contraseña")) {
			System.out.println("Error al validar campos");
			return false;
		}
		System.out.println("Campos validados correctamente");
		return true; // Todos los campos tienen datos válidos
	}
}
