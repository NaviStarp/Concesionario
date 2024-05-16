package Concesionario;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;

public class V_IniciarSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField txtHola;
	private JFormattedTextField textField_3;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_IniciarSesion frame = new V_IniciarSesion();
					frame.setUndecorated(false); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V_IniciarSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(203, 41, 41));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnRegistrarse1 = new JButton("Iniciar Sesión");
		btnRegistrarse1.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnRegistrarse1.setForeground(Color.WHITE);
		btnRegistrarse1.setBackground(new Color(178, 34, 34)); 
		btnRegistrarse1.setBounds(604, 392, 179, 41);
		btnRegistrarse1.setFocusPainted(false);
		btnRegistrarse1.setContentAreaFilled(false);
		btnRegistrarse1.setOpaque(true);
		btnRegistrarse1.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		btnRegistrarse1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Acción al hacer clic en el botón "Registrarse"
		    }
		});
		btnRegistrarse1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnRegistrarse1.setBackground(new Color(255, 4, 2)); // Cambia el color cuando el mouse entra
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnRegistrarse1.setBackground(new Color(178, 34, 34)); // Vuelve al color original cuando el mouse sale
		    }
		});
		contentPane.add(btnRegistrarse1);

		// Placeholder para DNI
		txtHola = new JFormattedTextField();
		addPlaceholder(txtHola, "DNI");
		txtHola.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		txtHola.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		txtHola.setColumns(10);
		txtHola.setBounds(569, 183, 241, 41);
		contentPane.add(txtHola);

		// Placeholder para Contraseña
		textField_3 = new JFormattedTextField();
		addPlaceholder(textField_3, "Contraseña");
		textField_3.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		textField_3.setBorder(new LineBorder(Color.BLACK, 2)); // Añade un borde negro
		textField_3.setColumns(10);
		textField_3.setBounds(569, 282, 241, 41);
		contentPane.add(textField_3);

		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblDni.setBounds(569, 146, 103, 23);
		contentPane.add(lblDni);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña: ");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(569, 245, 167, 23);
		contentPane.add(lblNewLabel_1_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 2, 3));
		panel.setBounds(0, 0, 395, 596);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\dam\\Desktop\\PROG\\proyectos\\Concesionario1\\imagenes\\logo3.png"));
		lblNewLabel_2.setBounds(66, 75, 266, 225);
		panel.add(lblNewLabel_2);

		JButton btnIniciarSesion = new JButton("Registrarte");
		btnIniciarSesion.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 18));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setBackground(new Color(178, 34, 34)); 
		btnIniciarSesion.setBounds(102, 294, 179, 41); // Ajusta la posición y el tamaño según sea necesario
		btnIniciarSesion.setBorder(new LineBorder(Color.BLACK, 3)); // Añade un borde negro
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setOpaque(true);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Oculta la ventana actual
				setVisible(false);

				// Crea una instancia de la ventana de Registro
				V_Registro ventanaRegistro = new V_Registro();
				ventanaRegistro.setVisible(true);
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
		panel.add(btnIniciarSesion);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio Sesión");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Cascadia Mono", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_1.setBounds(445, 22, 269, 52);
		contentPane.add(lblNewLabel_1);

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
}
