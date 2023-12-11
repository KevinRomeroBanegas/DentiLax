package interfaz;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;

public class Odontograma extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_nombreDiente;
	private JTextField text_tratamientoDiente;
	private JTable table_stock;
	private JTextField text_descripcionDiente;

	public static void main(String[] args) {
		try {
			Odontograma dialog = new Odontograma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Odontograma() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);
		BBDD bbdd=new BBDD();
		setTitle("Stock");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JButton molarIzquierdoBajo = new JButton("");
		molarIzquierdoBajo.setBounds(80, 300, 80, 40);
		contentPanel.add(molarIzquierdoBajo);
		
		JButton colmilloDerechoBajo = new JButton("");
		colmilloDerechoBajo.setBounds(560, 265, 80, 40);
		contentPanel.add(colmilloDerechoBajo);
		
		JButton colmilloIzquierdoBajo = new JButton("");
		colmilloIzquierdoBajo.setBounds(240, 265, 80, 40);
		contentPanel.add(colmilloIzquierdoBajo);
		
		JButton molarDerechoBajo = new JButton("");
		molarDerechoBajo.setBounds(720, 300, 80, 40);
		contentPanel.add(molarDerechoBajo);
		
		JButton incisivoCentralBajo = new JButton("");
		incisivoCentralBajo.setBounds(400, 235, 80, 40);
		contentPanel.add(incisivoCentralBajo);
		
		JButton MolarDerecho = new JButton("");
		MolarDerecho.setBounds(720, 70, 80, 40);
		contentPanel.add(MolarDerecho);
		
		JButton ColmilloDerecho = new JButton("");
		ColmilloDerecho.setBounds(560, 100, 80, 40);
		contentPanel.add(ColmilloDerecho);
		
		JButton incisivoCentral = new JButton("");
		incisivoCentral.setBounds(400, 135, 80, 40);
		contentPanel.add(incisivoCentral);
		
		JButton molarIzquierdo = new JButton("");
		molarIzquierdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		molarIzquierdo.setBounds(80, 70, 80, 40);
		contentPanel.add(molarIzquierdo);
		
		JButton ColmilloIzquierdo = new JButton("");
		ColmilloIzquierdo.setBounds(240, 100, 80, 40);
		contentPanel.add(ColmilloIzquierdo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 531, 864, 118);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Diente :");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			
			text_nombreDiente = new JTextField();
			text_nombreDiente.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombreDiente);
			text_nombreDiente.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Descripción :");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(10, 65, 135, 20);
			buttonPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Tratamiento :");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(537, 10, 135, 20);
			buttonPane.add(lblNewLabel_1_1);
			
			text_tratamientoDiente = new JTextField();
			text_tratamientoDiente.setColumns(10);
			text_tratamientoDiente.setBounds(684, 10, 170, 20);
			buttonPane.add(text_tratamientoDiente);
			
			text_descripcionDiente = new JTextField();
			text_descripcionDiente.setBounds(180, 40, 285, 65);
			buttonPane.add(text_descripcionDiente);
			text_descripcionDiente.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("Datos Odontograma");
		lblNewLabel.setBounds(10, 500, 160, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		{
			JButton btn_modificarDiente = new JButton("Modificar");
			btn_modificarDiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(text_nombreDiente.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Rellena el campo Nombre");
					}else if(text_destribuidorProducto.getText().isBlank()){
						JOptionPane.showMessageDialog(null, "Rellena el campo id Proveedor");
					}else if(text_tratamientoDiente.getText().isBlank()){
						JOptionPane.showMessageDialog(null, "Rellena el campo Precio");
					}else {
					
					JOptionPane.showMessageDialog(null, "Producto Modificado");
					
					}
				}
			});
			btn_modificarDiente.setBounds(694, 500, 85, 20);
			contentPanel.add(btn_modificarDiente);
			btn_modificarDiente.setActionCommand("Cancel");
		}
		
		JButton btn_agregarDiente = new JButton("Agregar");
		btn_agregarDiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_nombreDiente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre");
				}else if(text_destribuidorProducto.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo id Proveedor");
				}else if(text_tratamientoDiente.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo Precio");
				}else {
				
				JOptionPane.showMessageDialog(null, "Producto Agregado");
				
				}
			}
		});
		btn_agregarDiente.setBounds(599, 500, 85, 20);
		contentPanel.add(btn_agregarDiente);
		btn_agregarDiente.setActionCommand("Cancel");
		
		JButton btn_bajaDiente = new JButton("Borrar");
		btn_bajaDiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_nombreDiente.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre");
				}else {
				
				JOptionPane.showMessageDialog(null, "Producto dado de Baja");
				
				}
			}
		});
		btn_bajaDiente.setActionCommand("Cancel");
		btn_bajaDiente.setBounds(789, 500, 85, 20);
		contentPanel.add(btn_bajaDiente);
		
		table_stock = new JTable();
		table_stock.setBounds(10, 11, 864, 463);
		
		table_stock=bbdd.MostrarTabla("Stock", table_stock);
		
		contentPanel.add(table_stock);
		
		JLabel Fondo_stock = new JLabel("");
		Fondo_stock.setIcon(new ImageIcon("C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_stock.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_stock);
		
	}
}
