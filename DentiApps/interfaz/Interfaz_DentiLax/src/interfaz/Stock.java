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
import java.awt.Color;

public class Stock extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	
	private JTextField text_nombreMaterial;
	private JTextField text_proveedorMaterial;
	private JTextField text_precioMaterial;
	private JTable table_material;

	public static void main(String[] args) {
		
	}

	public Stock(java.awt.Frame parent, String rol) {
		super(parent, rol);
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(24, 165, 174));
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
				JLabel lblNewLabel_1 = new JLabel("Proveedor:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 70, 150, 20);
				buttonPane.add(lblNewLabel_1);
				
				
			}
			{
				
			}
			
			text_nombreMaterial = new JTextField();
			text_nombreMaterial.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombreMaterial);
			text_nombreMaterial.setColumns(10);
			
			text_proveedorMaterial = new JTextField();
			text_proveedorMaterial.setColumns(10);
			text_proveedorMaterial.setBounds(180, 70, 285, 20);
			buttonPane.add(text_proveedorMaterial);
			
			JLabel lblNewLabel_1_1 = new JLabel("Precio:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(533, 10, 135, 20);
			buttonPane.add(lblNewLabel_1_1);
			
			text_precioMaterial = new JTextField();
			text_precioMaterial.setColumns(10);
			text_precioMaterial.setBounds(684, 13, 170, 20);
			buttonPane.add(text_precioMaterial);
			
			JButton btn_filtrarTabla = new JButton("Filtrar tabla");
			btn_filtrarTabla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String consulta=JOptionPane.showInputDialog("Ponga el ID por el cual quiere filtrar la tabla");
					bbdd.filtro(consulta, table_material);
				}
			});
			btn_filtrarTabla.setBounds(756, 72, 98, 20);
			buttonPane.add(btn_filtrarTabla);
			
			
		}
		
		JLabel lblNewLabel = new JLabel("Datos Stock");
		lblNewLabel.setBounds(10, 515, 153, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		
		
		
		
		
		JButton btn_modificarMaterial = new JButton("Modificar");
		btn_modificarMaterial.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String valores[]=new String [3]; 
			valores[0]="'"+text_nombreMaterial.getText()+"'";
        	valores[1]="'"+text_proveedorMaterial.getText()+"'";
        	valores[2]=""+text_precioMaterial.getText()+"";
        	bbdd.modificar("Stock", valores, true,table_material);
			table_material=bbdd.MostrarTabla("Stock", table_material);
			}
		});
		btn_modificarMaterial.setBounds(685, 515, 95, 20);
		contentPanel.add(btn_modificarMaterial);
		
		
		JButton btn_agregarMaterial = new JButton("Agregar");
		btn_agregarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valores[]=new String [3]; 
				valores[0]="'"+text_nombreMaterial.getText()+"'";
            	valores[1]="'"+text_proveedorMaterial.getText()+"'";
            	valores[2]=""+text_precioMaterial.getText()+"";
            	bbdd.insertar("Stock", valores, true);
				table_material=bbdd.MostrarTabla("Stock", table_material);
				
			}
		});
		btn_agregarMaterial.setBounds(590, 515, 85, 20);
		contentPanel.add(btn_agregarMaterial);
		
		JButton btn_bajaMaterial = new JButton("Baja");
		btn_bajaMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valores[]=new String [3]; 
				valores[0]="'"+text_nombreMaterial.getText()+"'";
            	valores[1]="'"+text_proveedorMaterial.getText()+"'";
            	valores[2]=""+text_precioMaterial.getText()+"";
            	bbdd.borrar("Stock", valores, true);
				table_material=bbdd.MostrarTabla("Stock", table_material);
			}
		});
		btn_bajaMaterial.setBounds(790, 515, 85, 20);
		contentPanel.add(btn_bajaMaterial);
		
		table_material = new JTable();
		table_material.setBounds(10, 11, 864, 493);
		table_material=bbdd.MostrarTabla("Stock", table_material);
		table_material.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String[]valores=bbdd.SacarValoresTabla(table_material);
                    text_nombreMaterial.setText(valores[1].toString());
                    text_proveedorMaterial.setText(valores[2].toString());
                    text_precioMaterial.setText(valores[3].toString());
                }
            }
        });
		contentPanel.add(table_material);
		
		JLabel Fondo_material = new JLabel("");
		Fondo_material.setIcon(new ImageIcon("C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_material.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_material);
		
		//codigo restricciones de acceso de usuario doctor
		if (rol.equals("Doctor")) {
			btn_bajaMaterial.setEnabled(false);
			btn_agregarMaterial.setEnabled(false);
			btn_modificarMaterial.setEnabled(false);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
