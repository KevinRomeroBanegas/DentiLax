package interfaz;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDialog;
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
import java.awt.Dialog.ModalityType;

public class Ayuda extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtHolaQueTal;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda ayuda = new Ayuda();
					ayuda.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					ayuda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Ayuda() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);
		setTitle("DENTIAPP");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(153, 215, 222));
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		/*
		getContentPane().setFont(new Font("Segoe UI", Font.BOLD, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/imagenes/diente.png")));
		*/	
		
		
		JTextArea txtrCtrlP = new JTextArea("Tratamiento. Obtenemos los tratamiento de cada paciente individualizado ");
		txtrCtrlP.setEditable(false);
		txtrCtrlP.setForeground(Color.DARK_GRAY);
		txtrCtrlP.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtrCtrlP.setBackground(new Color(153, 215, 222));
		txtrCtrlP.setBounds(72, 193, 709, 44);
		contentPanel.add(txtrCtrlP);
		
		table = new JTable();
		table.setBounds(166, 526, 152, 28);
		contentPanel.add(table);
		
		txtHolaQueTal = new JTextField();
		txtHolaQueTal.setEditable(false);
		txtHolaQueTal.setText("Hola que tal");
		txtHolaQueTal.setBackground(new Color(153, 215, 222));
		txtHolaQueTal.setBounds(72, 456, 742, 60);
		txtHolaQueTal.setColumns(10);
		contentPanel.add(txtHolaQueTal);
		
		
		JTextArea txtrGestionPacienteNos = new JTextArea("Gestion Paciente. Nos ayuda a gestionar todos los pacientes, tanto insertar, borra o actualizar. "
				+ "\nDetalles del paciente. ");
		txtrGestionPacienteNos.setEditable(false);
		txtrGestionPacienteNos.setForeground(Color.DARK_GRAY);
		txtrGestionPacienteNos.setBackground(new Color(153, 215, 222));
		txtrGestionPacienteNos.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtrGestionPacienteNos.setBounds(72, 82, 709, 44);
		contentPanel.add(txtrGestionPacienteNos);
		
		JTextArea txtrDocyotrdNosAyuda = new JTextArea("Doctores. Se gestiona la hora cada doctor individualmete ");
		txtrDocyotrdNosAyuda.setEditable(false);
		txtrDocyotrdNosAyuda.setForeground(Color.DARK_GRAY);
		txtrDocyotrdNosAyuda.setBackground(new Color(153, 215, 222));
		txtrDocyotrdNosAyuda.setBounds(72, 137, 709, 44);
		txtrDocyotrdNosAyuda.setFont(new Font("Segoe UI", Font.BOLD, 13));
		contentPanel.add(txtrDocyotrdNosAyuda);
		
		JTextArea txtrEspecialidadEnLa = new JTextArea("Especialidad. En la gestion de especialidad nos encontramos la administracion de cada doctor con su "
				+ "\nespecialidad asiganda, se puede modificar");
		txtrEspecialidadEnLa.setEditable(false);
		txtrEspecialidadEnLa.setForeground(Color.DARK_GRAY);
		txtrEspecialidadEnLa.setBackground(new Color(153, 215, 222));
		txtrEspecialidadEnLa.setBounds(72, 247, 709, 44);
		txtrEspecialidadEnLa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		contentPanel.add(txtrEspecialidadEnLa);
	
		
		JLabel lblNewLabel = new JLabel("AYUDA");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(367, 16, 80, 44);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ATAJOS");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(361, 370, 86, 18);
		contentPanel.add(lblNewLabel_1);
		
		JTextArea textAreaAtajo = new JTextArea();
		textAreaAtajo.setEditable(false);
		textAreaAtajo.setBackground(new Color(24, 165, 174));
		textAreaAtajo.setBounds(45, 410, 790, 211);
		contentPanel.add(textAreaAtajo);
		
		JTextArea textArea_Ayuda = new JTextArea();
		textArea_Ayuda.setEditable(false);
		textArea_Ayuda.setForeground(Color.DARK_GRAY);
		textArea_Ayuda.setFont(new Font("Segoe UI", Font.BOLD, 13));
		textArea_Ayuda.setBackground(new Color(24, 165, 174));
		textArea_Ayuda.setBounds(45, 55, 790, 300);
		contentPanel.add(textArea_Ayuda);
		
	}
}
