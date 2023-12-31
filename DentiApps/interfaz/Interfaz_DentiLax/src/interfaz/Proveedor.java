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
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Proveedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_nombreProveedor;
	private JTextField text_emailProveedor;
	private JTextField text_disponibilidadProveedor;
	private JTextField text_telefonoProveedor;
	private JTable table_proveedor;

	public static void main(String[] args) {
		try {
			Proveedor dialog = new Proveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Proveedor() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);
		BBDD bbdd=new BBDD();
		setTitle("Proveedor");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(153, 215, 222));
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(24, 165, 174));
			buttonPane.setBounds(10, 516, 864, 133);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				
				JButton btn_filtrarTabla = new JButton("Filtrar tabla");
				btn_filtrarTabla.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String consulta=JOptionPane.showInputDialog("Ponga el ID por el cual quiere filtrar la tabla");
						bbdd.filtro(consulta, table_proveedor);
					}
				});
				btn_filtrarTabla.setBounds(769, 103, 85, 20);
				buttonPane.add(btn_filtrarTabla);
				
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Email:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 70, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Disponibilidad:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 100, 150, 20);
				lblNewLabel_1.setBounds(538, 70, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			
			text_nombreProveedor = new JTextField();
			text_nombreProveedor.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombreProveedor);
			text_nombreProveedor.setColumns(10);
			
			text_emailProveedor = new JTextField();
			text_emailProveedor.setColumns(10);
			text_emailProveedor.setBounds(180, 70, 285, 20);
			buttonPane.add(text_emailProveedor);
			
			text_disponibilidadProveedor = new JTextField();
			text_disponibilidadProveedor.setColumns(10);
			text_disponibilidadProveedor.setBounds(180, 100, 285, 20);
			text_disponibilidadProveedor.setBounds(684, 73, 170, 20);
			buttonPane.add(text_disponibilidadProveedor);
			
			JLabel lblNewLabel_1 = new JLabel("Nº Telefono:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(537, 10, 135, 20);
			buttonPane.add(lblNewLabel_1);
			
			text_telefonoProveedor = new JTextField();
			text_telefonoProveedor.setBounds(684, 10, 170, 20);
			buttonPane.add(text_telefonoProveedor);
			text_telefonoProveedor.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("Datos Proveedor\r\n");
		lblNewLabel.setBounds(10, 485, 130, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		{
			JButton btn_modificarProveedor = new JButton("Modificar");
			btn_modificarProveedor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String []valores=new String[4];
					valores[0]="'"+text_nombreProveedor.getText()+"'";
					valores[1]="'"+text_telefonoProveedor.getText()+"'";
					valores[2]="'"+text_emailProveedor.getText()+"'";
					if(text_disponibilidadProveedor.getText()=="Si"||text_disponibilidadProveedor.getText()=="si") {
						valores[3]="1";
					}else {
						valores[3]="0";
					}
					bbdd.modificar("Proveedor", valores, true,table_proveedor);
					table_proveedor=bbdd.MostrarTabla("Proveedor", table_proveedor);
				}
			});
			btn_modificarProveedor.setBounds(694, 485, 85, 20);
			contentPanel.add(btn_modificarProveedor);
			btn_modificarProveedor.setActionCommand("Cancel");
		}
		
		JButton btn_agregarProveedor = new JButton("Agregar");
		btn_agregarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []valores=new String[4];
				valores[0]="'"+text_nombreProveedor.getText()+"'";
				valores[1]="'"+text_telefonoProveedor.getText()+"'";
				valores[2]="'"+text_emailProveedor.getText()+"'";
				if(text_disponibilidadProveedor.getText()=="Si"||text_disponibilidadProveedor.getText()=="si") {
					valores[3]="1";
				}else {
					valores[3]="0";
				}
				bbdd.insertar("Proveedor", valores, true);
				table_proveedor=bbdd.MostrarTabla("Proveedor", table_proveedor);
			}
		});
		btn_agregarProveedor.setBounds(599, 485, 85, 20);
		contentPanel.add(btn_agregarProveedor);
		btn_agregarProveedor.setActionCommand("Cancel");
		
		JButton btnBajaProveedor = new JButton("Baja");
		btnBajaProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []valores=new String[4];
				valores[0]="'"+text_nombreProveedor.getText()+"'";
				valores[1]="'"+text_telefonoProveedor.getText()+"'";
				valores[2]="'"+text_emailProveedor.getText()+"'";
				if(text_disponibilidadProveedor.getText()=="Si"||text_disponibilidadProveedor.getText()=="si") {
					valores[3]="1";
				}else {
					valores[3]="0";
				}
				bbdd.borrar("Proveedor", valores, true);
				table_proveedor=bbdd.MostrarTabla("Proveedor", table_proveedor);
			}
		});
		btnBajaProveedor.setActionCommand("Cancel");
		btnBajaProveedor.setBounds(789, 485, 85, 20);
		contentPanel.add(btnBajaProveedor);
		
		table_proveedor = new JTable();
		table_proveedor.setBounds(10, 11, 864, 463);
		table_proveedor=bbdd.MostrarTabla("Proveedor", table_proveedor);
		table_proveedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String[]valores=bbdd.SacarValoresTabla(table_proveedor);
                    text_nombreProveedor.setText(valores[1].toString());
                    text_telefonoProveedor.setText(valores[2].toString());
                    text_emailProveedor.setText(valores[3].toString());
                    if(valores[4].equals("1")) {
                    	text_disponibilidadProveedor.setText("Si");
                    } else {
                    	text_disponibilidadProveedor.setText("No");
                    }
                }
            }
        });
		contentPanel.add(table_proveedor);
		
		JLabel Fondo_proveedor = new JLabel("");
		Fondo_proveedor.setIcon(new ImageIcon("C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_proveedor.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_proveedor);
		
	}
}
