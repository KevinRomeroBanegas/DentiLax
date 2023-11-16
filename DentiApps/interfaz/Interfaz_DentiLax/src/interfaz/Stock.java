package interfaz;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class Stock extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_nombreProducto;
	private JTextField text_pnProducto;
	private JTextField text_descripcionProducto;
	private JTextField text_cantidadProducto;
	private JTextField text_destribuidorProducto;
	private JTextField text_precioProducto;
	private JTable table_stock;

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
		BBDD bbdd=new BBDD();
		setTitle("Stock");
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
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("P/N:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 40, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Descripción:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 70, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Cantidad:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 100, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			
			text_nombreProducto = new JTextField();
			text_nombreProducto.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombreProducto);
			text_nombreProducto.setColumns(10);
			
			text_pnProducto = new JTextField();
			text_pnProducto.setColumns(10);
			text_pnProducto.setBounds(180, 40, 285, 20);
			buttonPane.add(text_pnProducto);
			
			text_descripcionProducto = new JTextField();
			text_descripcionProducto.setColumns(10);
			text_descripcionProducto.setBounds(180, 70, 285, 20);
			buttonPane.add(text_descripcionProducto);
			
			text_cantidadProducto = new JTextField();
			text_cantidadProducto.setColumns(10);
			text_cantidadProducto.setBounds(180, 100, 285, 20);
			buttonPane.add(text_cantidadProducto);
			
			JLabel lblNewLabel_1 = new JLabel("Distribuidor:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(537, 10, 135, 20);
			buttonPane.add(lblNewLabel_1);
			
			text_destribuidorProducto = new JTextField();
			text_destribuidorProducto.setBounds(684, 10, 170, 20);
			buttonPane.add(text_destribuidorProducto);
			text_destribuidorProducto.setColumns(10);
			
			JLabel lblNewLabel_1_1 = new JLabel("Precio:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(537, 40, 135, 20);
			buttonPane.add(lblNewLabel_1_1);
			
			text_precioProducto = new JTextField();
			text_precioProducto.setColumns(10);
			text_precioProducto.setBounds(684, 40, 170, 20);
			buttonPane.add(text_precioProducto);
		}
		
		JLabel lblNewLabel = new JLabel("Datos Producto");
		lblNewLabel.setBounds(10, 485, 120, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		{
			JButton btn_modificarProducto = new JButton("Modificar");
			btn_modificarProducto.setBounds(694, 485, 85, 20);
			contentPanel.add(btn_modificarProducto);
			btn_modificarProducto.setActionCommand("Cancel");
		}
		
		JButton btn_agregarProducto = new JButton("Agregar");
		btn_agregarProducto.setBounds(599, 485, 85, 20);
		contentPanel.add(btn_agregarProducto);
		btn_agregarProducto.setActionCommand("Cancel");
		
		JButton btn_bajaProducto = new JButton("Baja");
		btn_bajaProducto.setActionCommand("Cancel");
		btn_bajaProducto.setBounds(789, 485, 85, 20);
		contentPanel.add(btn_bajaProducto);
		
		table_stock = new JTable();
		table_stock.setBounds(10, 11, 864, 463);
		
		table_stock=bbdd.MostrarTabla("Stock", table_stock);
		
		contentPanel.add(table_stock);
		
	}
}
