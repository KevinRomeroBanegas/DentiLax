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
import javax.swing.ImageIcon;

public class Especialidad extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	
	private JTextField text_nombreDoctor;
	private JTextField text_Especialidadl;
	private JTable table_material;

	public static void main(String[] args) {
		
	}

	public Especialidad() {
		setResizable(false);
		
		setTitle("Especialidad");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 605, 864, 44);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre Doctor:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			
			text_nombreDoctor = new JTextField();
			text_nombreDoctor.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombreDoctor);
			text_nombreDoctor.setColumns(10);
			
			JLabel lblNewLabel_1_1 = new JLabel("Especialidad:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(537, 10, 135, 20);
			buttonPane.add(lblNewLabel_1_1);
			
			text_Especialidadl = new JTextField();
			text_Especialidadl.setColumns(10);
			text_Especialidadl.setBounds(684, 10, 170, 20);
			buttonPane.add(text_Especialidadl);
		}
		
		JLabel lblNewLabel = new JLabel("Datos Especialidad");
		lblNewLabel.setBounds(10, 574, 150, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		
		
		
		
		
		JButton btn_modificarEspecialidad = new JButton("Modificar");
		btn_modificarEspecialidad.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(text_nombreDoctor.getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "Rellena el campo Nombre Doctor");
			}else if(text_Especialidadl.getText().isBlank()){
				JOptionPane.showMessageDialog(null, "Rellena el campo Especialidad");
			}else {
				JOptionPane.showMessageDialog(null, "Especialidad Modificada");
			}
			}
		});
		btn_modificarEspecialidad.setBounds(695, 574, 85, 20);
		contentPanel.add(btn_modificarEspecialidad);
		
		
		JButton btn_agregarEspecialidad = new JButton("Agregar");
		btn_agregarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_nombreDoctor.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre Doctor");
				}else if(text_Especialidadl.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo Especialidad");
				}else {
				
				JOptionPane.showMessageDialog(null, "Especialidad Agregada");
					
				}
				
			}
		});
		btn_agregarEspecialidad.setBounds(600, 574, 85, 20);
		contentPanel.add(btn_agregarEspecialidad);
		
		JButton btn_bajaEspecialidad = new JButton("Baja");
		btn_bajaEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_nombreDoctor.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre Doctor");
				}else if(text_Especialidadl.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo Especialidad");
				}else {
				
				JOptionPane.showMessageDialog(null, "Especialidad dada de Baja");
					
				}
			}
		});
		btn_bajaEspecialidad.setBounds(790, 574, 85, 20);
		contentPanel.add(btn_bajaEspecialidad);
		
		table_material = new JTable();
		table_material.setBounds(10, 11, 864, 552);
		contentPanel.add(table_material);
		
		JLabel Fondo_especialidad = new JLabel("");
		Fondo_especialidad.setIcon(new ImageIcon("C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_especialidad.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_especialidad);
		
	}
}
