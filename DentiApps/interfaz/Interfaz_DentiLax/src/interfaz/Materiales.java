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

public class Materiales extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	
	private JTextField text_nombreMaterial;
	private JTextField text_codigoMaterial;
	private JTextField text_proveedorMaterial;
	private JTextField text_precioMaterial;
	private JTable table_material;

	public static void main(String[] args) {
		
	}

	public Materiales() {
		BBDD bbdd=new BBDD();
		setTitle("Materiales");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 546, 864, 103);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Codigo:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 40, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Proveedor:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 70, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			
			text_nombreMaterial = new JTextField();
			text_nombreMaterial.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombreMaterial);
			text_nombreMaterial.setColumns(10);
			
			text_codigoMaterial = new JTextField();
			text_codigoMaterial.setColumns(10);
			text_codigoMaterial.setBounds(180, 40, 285, 20);
			buttonPane.add(text_codigoMaterial);
			
			text_proveedorMaterial = new JTextField();
			text_proveedorMaterial.setColumns(10);
			text_proveedorMaterial.setBounds(180, 70, 285, 20);
			buttonPane.add(text_proveedorMaterial);
			
			JLabel lblNewLabel_1_1 = new JLabel("Precio:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(537, 70, 135, 20);
			buttonPane.add(lblNewLabel_1_1);
			
			text_precioMaterial = new JTextField();
			text_precioMaterial.setColumns(10);
			text_precioMaterial.setBounds(684, 70, 170, 20);
			buttonPane.add(text_precioMaterial);
		}
		
		JLabel lblNewLabel = new JLabel("Datos Material");
		lblNewLabel.setBounds(10, 515, 105, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		
		
		
		
		
		JButton btn_modificarMaterial = new JButton("Modificar");
		btn_modificarMaterial.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
					
			}
		});
		btn_modificarMaterial.setBounds(695, 515, 85, 20);
		contentPanel.add(btn_modificarMaterial);
		
		
		JButton btn_agregarMaterial = new JButton("Agregar");
		btn_agregarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_agregarMaterial.setBounds(600, 515, 85, 20);
		contentPanel.add(btn_agregarMaterial);
		
		JButton btn_bajaMaterial = new JButton("Baja");
		btn_bajaMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_bajaMaterial.setBounds(790, 515, 85, 20);
		contentPanel.add(btn_bajaMaterial);
		
		table_material = new JTable();
		table_material.setBounds(10, 11, 864, 493);
		table_material=bbdd.MostrarTabla("Stock", table_material);
		contentPanel.add(table_material);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
