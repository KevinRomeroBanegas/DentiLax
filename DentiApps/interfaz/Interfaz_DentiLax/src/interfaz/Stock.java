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
import java.awt.Color;

public class Stock extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_nombreProducto;
	private JTextField text_destribuidorProducto;
	private JTextField text_precioProducto;
	private JTable table_stock;
	private JTable table;

	public static void main(String[] args) {
		try {
			Stock dialog = new Stock();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Stock() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);
		BBDD bbdd=new BBDD();
		setTitle("Stock");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(153, 215, 222));
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 864, 527);
		contentPanel.add(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(24, 165, 174));
			buttonPane.setBounds(10, 580, 864, 69);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			
			text_nombreProducto = new JTextField();
			text_nombreProducto.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombreProducto);
			text_nombreProducto.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Id Proveedor");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(10, 41, 135, 20);
			buttonPane.add(lblNewLabel_1);
			
			text_destribuidorProducto = new JTextField();
			text_destribuidorProducto.setBounds(180, 43, 285, 20);
			buttonPane.add(text_destribuidorProducto);
			text_destribuidorProducto.setColumns(10);
			
			JLabel lblNewLabel_1_1 = new JLabel("Precio:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(537, 10, 135, 20);
			buttonPane.add(lblNewLabel_1_1);
			
			text_precioProducto = new JTextField();
			text_precioProducto.setColumns(10);
			text_precioProducto.setBounds(684, 10, 170, 20);
			buttonPane.add(text_precioProducto);
		}
		
		JLabel lblNewLabel = new JLabel("Datos Producto");
		lblNewLabel.setBounds(10, 549, 120, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		{
			JButton btn_modificarProducto = new JButton("Modificar");
			btn_modificarProducto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(text_nombreProducto.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Rellena el campo Nombre");
					}else if(text_destribuidorProducto.getText().isBlank()){
						JOptionPane.showMessageDialog(null, "Rellena el campo id Proveedor");
					}else if(text_precioProducto.getText().isBlank()){
						JOptionPane.showMessageDialog(null, "Rellena el campo Precio");
					}else {
					
					JOptionPane.showMessageDialog(null, "Producto Modificado");
					
					}
				}
			});
			btn_modificarProducto.setBounds(694, 549, 85, 20);
			contentPanel.add(btn_modificarProducto);
			btn_modificarProducto.setActionCommand("Cancel");
		}
		
		JButton btn_agregarProducto = new JButton("Agregar");
		btn_agregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_nombreProducto.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre");
				}else if(text_destribuidorProducto.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo id Proveedor");
				}else if(text_precioProducto.getText().isBlank()){
					JOptionPane.showMessageDialog(null, "Rellena el campo Precio");
				}else {
				
				JOptionPane.showMessageDialog(null, "Producto Agregado");
				
				}
			}
		});
		btn_agregarProducto.setBounds(599, 549, 85, 20);
		contentPanel.add(btn_agregarProducto);
		btn_agregarProducto.setActionCommand("Cancel");
		
		JButton btn_bajaProducto = new JButton("Baja");
		btn_bajaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_nombreProducto.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre");
				}else {
				
				JOptionPane.showMessageDialog(null, "Producto dado de Baja");
				
				}
			}
		});
		btn_bajaProducto.setActionCommand("Cancel");
		btn_bajaProducto.setBounds(789, 549, 85, 20);
		contentPanel.add(btn_bajaProducto);
		
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
