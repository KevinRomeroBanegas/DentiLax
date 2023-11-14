package interfaz;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Cita extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	
	private JTextField text_nombrePaciente;
	private JTextField text_tratamientoCita;
	private JTable table_cita;
	private JTextField text_doctorCita;

	public static void main(String[] args) {
		
	}

	public Cita() {
		//Prueba
		setTitle("Cita");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 516, 864, 133);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre y Apellidos:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Tratamiento:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 40, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Observaciones");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 70, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			
			text_nombrePaciente = new JTextField();
			text_nombrePaciente.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombrePaciente);
			text_nombrePaciente.setColumns(10);
			
			text_tratamientoCita = new JTextField();
			text_tratamientoCita.setColumns(10);
			text_tratamientoCita.setBounds(180, 40, 285, 20);
			buttonPane.add(text_tratamientoCita);
			
			JLabel lblNewLabel_1 = new JLabel("Doctor:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(537, 10, 135, 20);
			buttonPane.add(lblNewLabel_1);
			
			JTextArea text_observacionesCita = new JTextArea();
			text_observacionesCita.setBounds(180, 70, 285, 52);
			buttonPane.add(text_observacionesCita);
			
			text_doctorCita = new JTextField();
			text_doctorCita.setBounds(655, 10, 200, 20);
			buttonPane.add(text_doctorCita);
			text_doctorCita.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("Datos Cita");
		lblNewLabel.setBounds(10, 485, 105, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		
		
		
		
		
		JButton btn_modificarCita = new JButton("Modificar");
		btn_modificarCita.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
					
			}
		});
		btn_modificarCita.setBounds(695, 485, 85, 20);
		contentPanel.add(btn_modificarCita);
		
		
		JButton btn_agregarCita = new JButton("Agregar");
		btn_agregarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_agregarCita.setBounds(600, 485, 85, 20);
		contentPanel.add(btn_agregarCita);
		
		JButton btn_bajaCita = new JButton("Baja");
		btn_bajaCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_bajaCita.setBounds(790, 485, 85, 20);
		contentPanel.add(btn_bajaCita);
		
		table_cita = new JTable();
		table_cita.setBounds(10, 11, 864, 463);
		contentPanel.add(table_cita);
		
	}
}
