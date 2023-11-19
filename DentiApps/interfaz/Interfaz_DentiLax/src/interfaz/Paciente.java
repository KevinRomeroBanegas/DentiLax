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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;

public class Paciente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	
	private JTextField text_nombrePaciente;
	private JTextField text_dniPaciente;
	private JTextField text_direccionPaciente;
	private JTextField text_emailPaciente;
	private JTextField text_telefonoPaciente;
	private JTextField text_edadPaciente;
	private JTable table_paciente;

	public static void main(String[] args) {
		
	}

	public Paciente() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);
		BBDD bbdd= new BBDD();
		bbdd.conectar();
		setTitle("Paciente");
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
				JLabel lblNewLabel_1 = new JLabel("Dni:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 40, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Dirección:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 70, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Email:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 100, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			
			text_nombrePaciente = new JTextField();
			text_nombrePaciente.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombrePaciente);
			text_nombrePaciente.setColumns(10);
			
			text_dniPaciente = new JTextField();
			text_dniPaciente.setColumns(10);
			text_dniPaciente.setBounds(180, 40, 285, 20);
			buttonPane.add(text_dniPaciente);
			
			text_direccionPaciente = new JTextField();
			text_direccionPaciente.setColumns(10);
			text_direccionPaciente.setBounds(180, 70, 285, 20);
			buttonPane.add(text_direccionPaciente);
			
			text_emailPaciente = new JTextField();
			text_emailPaciente.setColumns(10);
			text_emailPaciente.setBounds(180, 100, 285, 20);
			buttonPane.add(text_emailPaciente);
			
			JLabel lblNewLabel_1 = new JLabel("Nº Telefono:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(537, 10, 135, 20);
			buttonPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Edad:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(537, 40, 135, 20);
			buttonPane.add(lblNewLabel_1_1);
			
			text_telefonoPaciente = new JTextField();
			text_telefonoPaciente.setBounds(684, 10, 170, 20);
			buttonPane.add(text_telefonoPaciente);
			text_telefonoPaciente.setColumns(10);
			
			text_edadPaciente = new JTextField();
			text_edadPaciente.setColumns(10);
			text_edadPaciente.setBounds(684, 40, 170, 20);
			buttonPane.add(text_edadPaciente);
			
			JButton btn_odontograma = new JButton("Odontograma");
			btn_odontograma.setFont(new Font("Tahoma", Font.BOLD, 15));
			btn_odontograma.setBounds(535, 87, 320, 35);
			buttonPane.add(btn_odontograma);
		}
		
		JLabel lblNewLabel = new JLabel("Datos Cliente");
		lblNewLabel.setBounds(10, 485, 105, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		
		
		
		
		
		JButton btn_modificarCliente = new JButton("Modificar");
		btn_modificarCliente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				if(text_nombrePaciente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo nombre");
				}else if(text_dniPaciente.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo dni");
				}else if(text_direccionPaciente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo direccion");
				}else if(text_emailPaciente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo email");
				}else if(text_telefonoPaciente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo telefono");
				}else if(text_edadPaciente.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo edad");
				}else {
				
				JOptionPane.showMessageDialog(null, "Paciente Modificado");
				table_paciente=bbdd.MostrarTabla("Cita", table_paciente);
				}
					
			}
		});
		btn_modificarCliente.setBounds(685, 485, 95, 20);
		contentPanel.add(btn_modificarCliente);
		
		
		JButton btn_agregarCliente = new JButton("Agregar");
		btn_agregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(text_nombrePaciente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo nombre");
				}else if(text_dniPaciente.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo dni");
				}else if(text_direccionPaciente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo direccion");
				}else if(text_emailPaciente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo email");
				}else if(text_telefonoPaciente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo telefono");
				}else if(text_edadPaciente.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo edad");
				}else {
					JOptionPane.showMessageDialog(null, "Paciente Agregado");
					table_paciente=bbdd.MostrarTabla("Cita", table_paciente);
				}
				
			}
		});
		btn_agregarCliente.setBounds(590, 485, 85, 20);
		contentPanel.add(btn_agregarCliente);
		
		JButton btn_bajaCliente = new JButton("Baja");
		btn_bajaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_paciente=bbdd.MostrarTabla("Cita", table_paciente);
			}
		});
		btn_bajaCliente.setBounds(790, 485, 85, 20);
		contentPanel.add(btn_bajaCliente);
		
		table_paciente = new JTable();
		table_paciente.setBounds(10, 11, 864, 463);
		table_paciente=bbdd.MostrarTabla("Cliente", table_paciente);
		table_paciente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String[]valores=bbdd.SacarValoresTabla(table_paciente);
                    text_dniPaciente.setText(valores[0].toString());
                    text_nombrePaciente.setText(valores[1].toString());
                    text_direccionPaciente.setText(valores[2].toString());
                    text_telefonoPaciente.setText(valores[3].toString());
                    text_edadPaciente.setText(valores[4].toString());
                    text_emailPaciente.setText(valores[5].toString());
                }
            }
        });
		contentPanel.add(table_paciente);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 884, 660);
		contentPanel.add(lblNewLabel_2);
		
		JLabel Fondo_paciente = new JLabel("");
		Fondo_paciente.setIcon(new ImageIcon("C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_paciente.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_paciente);
		
	}
}
