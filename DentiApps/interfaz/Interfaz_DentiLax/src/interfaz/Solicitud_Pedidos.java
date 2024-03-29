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

public class Solicitud_Pedidos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_nombreProducto;
	private JTextField text_destribuidorProducto;
	private JTextField text_precioProducto;
	private JTable table_mat;
	private JTextField text_cantidadProducto;
	private JTextField text_IDStock;
	

	public static void main(String[] args) {
		try {
			Solicitud_Pedidos dialog = new Solicitud_Pedidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Solicitud_Pedidos() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);
		BBDD bbdd = new BBDD();
		setTitle("Solicitud Pedido");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(153, 215, 222));
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		table_mat = new JTable();
		table_mat.setBounds(10, 11, 864, 527);
		table_mat = bbdd.MostrarTabla("Stock", table_mat);
		table_mat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String[] valores = bbdd.SacarValoresTabla(table_mat);
					text_IDStock.setText(valores[0].toString());
					text_nombreProducto.setText(valores[1].toString());
					text_destribuidorProducto.setText(valores[2].toString());
					text_precioProducto.setText(valores[3].toString());

				}
			}
		});
		contentPanel.add(table_mat);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(24, 165, 174));
			buttonPane.setBounds(10, 580, 864, 69);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(233, 10, 131, 20);
				buttonPane.add(lblNewLabel_1);
			}

			text_nombreProducto = new JTextField();
			text_nombreProducto.setEnabled(false);
			text_nombreProducto.setBounds(374, 8, 243, 20);
			buttonPane.add(text_nombreProducto);
			text_nombreProducto.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("ID Proveedor:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(233, 41, 131, 20);
			buttonPane.add(lblNewLabel_1);

			text_destribuidorProducto = new JTextField();
			text_destribuidorProducto.setEnabled(false);
			text_destribuidorProducto.setBounds(374, 41, 243, 20);
			buttonPane.add(text_destribuidorProducto);
			text_destribuidorProducto.setColumns(10);

			JLabel lblNewLabel_1_1 = new JLabel("Precio:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(652, 10, 96, 20);
			buttonPane.add(lblNewLabel_1_1);

			text_precioProducto = new JTextField();
			text_precioProducto.setEnabled(false);
			text_precioProducto.setColumns(10);
			text_precioProducto.setBounds(758, 10, 96, 20);
			buttonPane.add(text_precioProducto);

			JLabel lblNewLabel_1_1_1 = new JLabel("Cantidad:");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1_1.setBounds(652, 41, 96, 20);
			buttonPane.add(lblNewLabel_1_1_1);

			text_cantidadProducto = new JTextField();
			text_cantidadProducto.setColumns(10);
			text_cantidadProducto.setBounds(758, 41, 96, 20);
			buttonPane.add(text_cantidadProducto);
			

			text_IDStock = new JTextField();
			text_IDStock.setEnabled(false);
			text_IDStock.setColumns(10);
			text_IDStock.setBounds(116, 28, 73, 20);
			buttonPane.add(text_IDStock);

			JLabel lblNewLabel_1_1_2 = new JLabel("ID Stock:");
			lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1_2.setBounds(10, 25, 96, 20);
			buttonPane.add(lblNewLabel_1_1_2);

		}

		JLabel lblNewLabel = new JLabel("Datos Pedido");
		lblNewLabel.setBounds(10, 549, 193, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);

		JButton btn_agregarProducto = new JButton("Enviar Solicitud");
		btn_agregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String NumeroCantidadProducto = text_cantidadProducto.getText();
				
				int cantidadProducto = Integer.parseInt(NumeroCantidadProducto);
				
				if(cantidadProducto<1) {
					JOptionPane.showMessageDialog(null,"Por favor inserte un valor valido");
					
					}else {
						if (text_cantidadProducto.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Rellena el campo Cantidad");
						} else {
							String[] valores = new String[6];
							valores[0] = "null";
							valores[1] = text_IDStock.getText();
							valores[2] = "'" + text_nombreProducto.getText() + "'";
							valores[3] = text_destribuidorProducto.getText();
							valores[4] = text_precioProducto.getText();
							valores[5] = text_cantidadProducto.getText();
						
							int result = JOptionPane.showConfirmDialog(null,
								"¿Quieres añadir este producto a la lista de pedidos?", "AGREGAR PRODUCTO",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

							if (result == JOptionPane.YES_OPTION) {
								JOptionPane.showMessageDialog(null, "Producto agregado a la lista");
								bbdd.insertar("solicitud_material", valores, false);	
					}
				}			
			}			
				
		}	
		
			
		});
		btn_agregarProducto.setBounds(714, 548, 160, 20);
		contentPanel.add(btn_agregarProducto);
		btn_agregarProducto.setActionCommand("Cancel");

		JLabel Fondo_stock = new JLabel("");
		Fondo_stock.setIcon(new ImageIcon(
				"C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_stock.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_stock);

	}
	public void validarPedidos() {
		int validadarCantidad=Integer.parseInt(text_cantidadProducto.getText());
		if(validadarCantidad<1) {
			JOptionPane.showMessageDialog(null,"Inserte un valor valido");
		}
	
	}
}
