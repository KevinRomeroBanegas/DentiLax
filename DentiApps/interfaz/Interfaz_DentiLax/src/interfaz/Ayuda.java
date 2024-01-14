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
	private JTextField txtProbadno;
	private JTextField txtAtaEspc;
	private JTextField txtAtaTra;
	private JTextField txtAtajoDoc;
	private JTextField txtAtajoDoc_1;
	private JTextField txtAtaPaciente;
	private JTextField txtAtaPaciente_1;
	private JTextField txtAtaFc;
	private JTextField txtAtaStock;

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
		txtrCtrlP.setBounds(72, 138, 709, 35);
		contentPanel.add(txtrCtrlP);
		
		
		JTextArea txtrGestionPacienteNos = new JTextArea("Gestion Paciente. Nos ayuda a gestionar todos los pacientes, tanto insertar, borra o actualizar.");
		txtrGestionPacienteNos.setEditable(false);
		txtrGestionPacienteNos.setForeground(Color.DARK_GRAY);
		txtrGestionPacienteNos.setBackground(new Color(153, 215, 222));
		txtrGestionPacienteNos.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtrGestionPacienteNos.setBounds(72, 46, 709, 35);
		contentPanel.add(txtrGestionPacienteNos);
		
		JTextArea txtrDocyotrdNosAyuda = new JTextArea("Doctores. Se gestiona la hora cada doctor individualmete ");
		txtrDocyotrdNosAyuda.setEditable(false);
		txtrDocyotrdNosAyuda.setForeground(Color.DARK_GRAY);
		txtrDocyotrdNosAyuda.setBackground(new Color(153, 215, 222));
		txtrDocyotrdNosAyuda.setBounds(72, 92, 709, 35);
		txtrDocyotrdNosAyuda.setFont(new Font("Segoe UI", Font.BOLD, 13));
		contentPanel.add(txtrDocyotrdNosAyuda);
		
		JTextArea txtrEspecialidadEnLa = new JTextArea("Especialidad. En la gestion de especialidad nos encontramos la administracion de cada doctor con su ");
		txtrEspecialidadEnLa.setEditable(false);
		txtrEspecialidadEnLa.setForeground(Color.DARK_GRAY);
		txtrEspecialidadEnLa.setBackground(new Color(153, 215, 222));
		txtrEspecialidadEnLa.setBounds(72, 184, 709, 35);
		txtrEspecialidadEnLa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		contentPanel.add(txtrEspecialidadEnLa);
		
		
		JTextArea txtrStock = new JTextArea("Stock. Desde aqui se controla la cantidad de material disponible para su uso.");
		txtrStock.setEditable(false);
		txtrStock.setForeground(Color.DARK_GRAY);
		txtrStock.setBackground(new Color(153, 215, 222));
		txtrStock.setBounds(72, 235, 709, 35);
		txtrStock.setFont(new Font("Segoe UI", Font.BOLD, 13));
		contentPanel.add(txtrStock);
		
		
		
		JTextArea txtrCita = new JTextArea("Cita. Vemos las citas que tienen programada cada paciente. Modificable por admi");
		txtrCita.setEditable(false);
		txtrCita.setForeground(Color.DARK_GRAY);
		txtrCita.setBackground(new Color(153, 215, 222));
		txtrCita.setBounds(72, 286, 709, 35);
		txtrCita.setFont(new Font("Segoe UI", Font.BOLD, 13));
		contentPanel.add(txtrCita);
		
		JTextArea txtAtaFac = new JTextArea("Facturación. Vemos lo que se ingresa cada mes y lo que queda por pagar por paciente");
		txtAtaFac.setEditable(false);
		txtAtaFac.setForeground(Color.DARK_GRAY);
		txtAtaFac.setBackground(new Color(153, 215, 222));
		txtAtaFac.setBounds(72, 332, 709, 35);
		txtAtaFac.setFont(new Font("Segoe UI", Font.BOLD, 13));
		contentPanel.add(txtAtaFac);
	
		
		JLabel lblNewLabel = new JLabel("AYUDA");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(367, 0, 60, 35);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ATAJOS");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(377, 401, 50, 18);
		contentPanel.add(lblNewLabel_1);
		
		
		txtAtaPaciente = new JTextField();
		txtAtaPaciente.setForeground(Color.DARK_GRAY);
		txtAtaPaciente.setFont(new Font("Segoe UI", Font.BOLD, 10));
		txtAtaPaciente.setBackground(new Color(153, 215, 222));
		txtAtaPaciente.setText("Ctrl + P. Alta,  baja y modificacion de pacientes");
		txtAtaPaciente.setBounds(48, 448, 303, 46);
		contentPanel.add(txtAtaPaciente);
		txtAtaPaciente.setColumns(10);
		
		txtAtaEspc = new JTextField();
		txtAtaEspc.setForeground(Color.DARK_GRAY);
		txtAtaEspc.setFont(new Font("Segoe UI", Font.BOLD, 10));
		txtAtaEspc.setBackground(new Color(153, 215, 222));
		txtAtaEspc.setText("Ctrl + E. Asigancion de especialidad a doctores");
		txtAtaEspc.setBounds(367, 449, 265, 44);
		contentPanel.add(txtAtaEspc);
		txtAtaEspc.setColumns(10);
		txtAtajoDoc = new JTextField();
		
		
		txtAtajoDoc_1 = new JTextField();
		txtAtajoDoc_1.setFont(new Font("Segoe UI", Font.BOLD, 10));
		txtAtajoDoc_1.setForeground(Color.DARK_GRAY);
		txtAtajoDoc_1.setBackground(new Color(153, 215, 222));
		txtAtajoDoc_1.setText("Ctrl + D. Alta, baja y modificacion de doctores");
		txtAtajoDoc_1.setBounds(48, 505, 303, 44);
		contentPanel.add(txtAtajoDoc_1);
		txtAtajoDoc_1.setColumns(10);
		
		txtAtaTra = new JTextField();
		txtAtaTra.setForeground(Color.DARK_GRAY);
		txtAtaTra.setFont(new Font("Segoe UI", Font.BOLD, 10));
		txtAtaTra.setBackground(new Color(153, 215, 222));
		txtAtaTra.setText("Crtl + T. Controlamos lo tratamiento de cada paciente");
		txtAtaTra.setBounds(48, 560, 303, 44);
		contentPanel.add(txtAtaTra);
		txtAtaTra.setColumns(10);
		
		txtAtaStock = new JTextField();
		txtAtaStock.setFont(new Font("Segoe UI", Font.BOLD, 11));
		txtAtaStock.setForeground(Color.DARK_GRAY);
		txtAtaStock.setBackground(new Color(153, 215, 222));
		txtAtaStock.setText("Ctrl + S. Visualizacion del Strok real.");
		txtAtaStock.setBounds(367, 504, 265, 46);
		contentPanel.add(txtAtaStock);
		txtAtaStock.setColumns(10);
		
		txtAtaFc = new JTextField();
		txtAtaFc.setFont(new Font("Segoe UI", Font.BOLD, 11));
		txtAtaFc.setBackground(new Color(153, 215, 222));
		txtAtaFc.setForeground(Color.DARK_GRAY);
		txtAtaFc.setText("Ctrl + F. Facturacion trimestral");
		txtAtaFc.setBounds(642, 448, 181, 46);
		contentPanel.add(txtAtaFc);
		txtAtaFc.setColumns(10);
		
		txtAtaPaciente_1 = new JTextField();
		txtAtaPaciente_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		txtAtaPaciente_1.setBackground(new Color(153, 215, 222));
		txtAtaPaciente_1.setForeground(Color.DARK_GRAY);
		txtAtaPaciente_1.setText("Ctrl + C. Asigancion de citas a pacientes.");
		txtAtaPaciente_1.setBounds(367, 559, 265, 46);
		contentPanel.add(txtAtaPaciente_1);
		txtAtaPaciente_1.setColumns(10);
		
		txtAtaFc = new JTextField();
		txtAtaFc.setFont(new Font("Segoe UI", Font.BOLD, 11));
		txtAtaFc.setBackground(new Color(153, 215, 222));
		txtAtaFc.setForeground(Color.DARK_GRAY);
		txtAtaFc.setText("Ctrl + N. Inicio Rapido");
		txtAtaFc.setBounds(642, 504, 181, 46);
		contentPanel.add(txtAtaFc);
		txtAtaFc.setColumns(10);
	
		
		JTextArea textAreaAtajo = new JTextArea();
		textAreaAtajo.setEditable(false);
		textAreaAtajo.setBackground(new Color(24, 165, 174));
		textAreaAtajo.setBounds(33, 440, 802, 195);
		contentPanel.add(textAreaAtajo);
		
		JTextArea textArea_Ayuda = new JTextArea();
		textArea_Ayuda.setEditable(false);
		textArea_Ayuda.setForeground(Color.DARK_GRAY);
		textArea_Ayuda.setFont(new Font("Segoe UI", Font.BOLD, 13));
		textArea_Ayuda.setBackground(new Color(24, 165, 174));
		textArea_Ayuda.setBounds(33, 34, 802, 356);
		contentPanel.add(textArea_Ayuda);
		
	
		
	}
}
