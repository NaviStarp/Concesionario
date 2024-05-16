package Concesionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class V_inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_inicio frame = new V_inicio();
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
	public V_inicio() {
		

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1413, 793);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 1397, 754);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(203, 41, 41));
		panel_1.setBounds(0, 0, 317, 993);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(203, 41, 41));
		panel_2.setBounds(317, 0, 1201, 44);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bienvenido/a " + Cliente.getNombre());
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(418, 65, 381, 61);
		panel.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(203, 41, 41));
		panel_4.setBounds(398, 127, 999, 78);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Acceso concedido como:        Cliente");
		lblNewLabel_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(22, 0, 335, 75);
		panel_4.add(lblNewLabel_1);

		LocalDateTime fecha = LocalDateTime.now();

		JLabel lblFecha = new JLabel("" + fecha.toLocalDate());
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblFecha.setBounds(812, 21, 154, 41);
		panel_4.add(lblFecha);

		JTextArea txttextointroduccion = new JTextArea();
		txttextointroduccion.setEditable(false);
		txttextointroduccion.setText(
				"¡Bienvenido/a!\r\n\r\nNos alegra tenerte aquí en nuestro concesionario.\r\n\r\nAquí encontrarás una amplia selección de vehículos para satisfacer tus necesidades y gustos.\r\n\r\nNo dudes en explorar nuestro catálogo y descubrir las últimas novedades en automóviles.\r\n\r\nSi necesitas ayuda o tienes alguna pregunta, nuestro equipo estará encantado de asistirte.\r\n\r\n¡Que tengas una excelente experiencia en nuestro concesionario!\r\n\r\nEstamos aquí para hacer que tu búsqueda de vehículos sea emocionante y sin complicaciones. ");
		txttextointroduccion.setForeground(Color.WHITE);
		txttextointroduccion.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 16));
		txttextointroduccion.setBackground(new Color(128, 128, 128));
		txttextointroduccion.setBounds(430, 277, 868, 388);
		panel.add(txttextointroduccion);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(388, 238, 946, 462);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(128, 128, 128));
		panel_6.setBounds(10, 11, 926, 440);
		panel_5.add(panel_6);

	}
}
