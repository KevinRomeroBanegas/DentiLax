package interfaz;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Toolkit;

public class Ayuda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtHolaQueTal;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda frame = new Ayuda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Ayuda() {
		getContentPane().setFont(new Font("Segoe UI", Font.BOLD, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/imagenes/diente.png")));
		setTitle("DENTIAPP");
		getContentPane().setBackground(new Color(153, 215, 222));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		
		JTextArea txtrCtrlP = new JTextArea("Tratamiento. Obtenemos los tratamiento de cada paciente individualizado ");
		txtrCtrlP.setForeground(Color.DARK_GRAY);
		txtrCtrlP.setBackground(new Color(153, 215, 222));
		txtrCtrlP.setBounds(72, 192, 709, 44);

		txtrCtrlP.setFont(new Font("Segoe UI", Font.BOLD, 13));
		getContentPane().add(txtrCtrlP);
		
		JTextArea txtrGestionPacienteNos = new JTextArea("Gestion Paciente. Nos ayuda a gestionar todos los pacientes, tanto insertar, borra o actualizar. Detalles del paciente ");
		txtrGestionPacienteNos.setForeground(Color.DARK_GRAY);
		txtrGestionPacienteNos.setBackground(new Color(153, 215, 222));
		txtrGestionPacienteNos.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtrGestionPacienteNos.setBounds(72, 82, 709, 44);
		txtrCtrlP.setFont(new Font("Segoe UI", Font.BOLD, 10));
		getContentPane().add(txtrGestionPacienteNos);
		
		JTextArea txtrDocyotrdNosAyuda = new JTextArea("Doctores. Se gestiona la hora cada doctor individualmete ");
		txtrDocyotrdNosAyuda.setForeground(Color.DARK_GRAY);
		txtrDocyotrdNosAyuda.setBackground(new Color(153, 215, 222));
		txtrDocyotrdNosAyuda.setBounds(72, 137, 709, 44);
		txtrDocyotrdNosAyuda.setFont(new Font("Segoe UI", Font.BOLD, 13));
		getContentPane().add(txtrDocyotrdNosAyuda);
		
		JTextArea txtrEspecialidadEnLa = new JTextArea("Especialidad. En la gestion de especialidad nos encontramos la administracion de cada doctor con su especialidad asiganda, se puede modificar");
		txtrEspecialidadEnLa.setForeground(Color.DARK_GRAY);
		txtrEspecialidadEnLa.setBackground(new Color(153, 215, 222));
		txtrEspecialidadEnLa.setBounds(72, 247, 709, 44);
		txtrEspecialidadEnLa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		getContentPane().add(txtrEspecialidadEnLa);
	
		
		JLabel lblNewLabel = new JLabel("AYUDA");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(367, 16, 80, 44);
		txtrCtrlP.setFont(new Font("Segoe UI", Font.BOLD, 10));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ATAJOS");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(361, 370, 86, 18);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea textAreaAtajo = new JTextArea();
		textAreaAtajo.setBackground(new Color(24, 165, 174));
		textAreaAtajo.setBounds(45, 410, 790, 211);
		getContentPane().add(textAreaAtajo);
		
		txtHolaQueTal = new JTextField();
		txtHolaQueTal.setText("Hola que tal");
		txtHolaQueTal.setBackground(new Color(153, 215, 222));
		txtHolaQueTal.setBounds(72, 456, 742, 60);
		getContentPane().add(txtHolaQueTal);
		txtHolaQueTal.setColumns(10);
		
		JTextArea textArea_Ayuda = new JTextArea();
		textArea_Ayuda.setForeground(Color.DARK_GRAY);
		textArea_Ayuda.setFont(new Font("Segoe UI", Font.BOLD, 13));
		textArea_Ayuda.setBackground(new Color(24, 165, 174));
		textArea_Ayuda.setBounds(45, 55, 790, 300);
		getContentPane().add(textArea_Ayuda);
		
		table = new JTable();
		table.setBounds(166, 526, 152, 28);
		getContentPane().add(table);
		
		
		
		
	
	}
}
