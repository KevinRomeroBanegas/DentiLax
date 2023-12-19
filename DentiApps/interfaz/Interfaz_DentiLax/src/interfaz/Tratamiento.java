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
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class Tratamiento extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_NombreTrat;
	private JTextField text_Precio;
	private JTable table_tratamiento;
	private JComboBox cmb_Especialidad;
	private JTextField textField;

	public static void main(String[] args) {
		try {
			Tratamiento dialog = new Tratamiento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Tratamiento() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);
		BBDD bbdd=new BBDD();
		setTitle("Tratamiento");
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
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JButton btn_filtrarTabla = new JButton("Filtrar tabla");
				btn_filtrarTabla.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String consulta=JOptionPane.showInputDialog("Ponga el ID por el cual quiere filtrar la tabla");
						bbdd.filtro(consulta, table_tratamiento);
					}
				});
				btn_filtrarTabla.setBounds(749, 103, 105, 20);
				buttonPane.add(btn_filtrarTabla);
			}
			
			text_NombreTrat = new JTextField();
			text_NombreTrat.setBounds(180, 10, 285, 20);
			buttonPane.add(text_NombreTrat);
			text_NombreTrat.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Especialidad:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(10, 77, 150, 20);
			buttonPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Precio:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1.setBounds(506, 10, 150, 20);
			buttonPane.add(lblNewLabel_1_1);
			
			text_Precio = new JTextField();
			text_Precio.setColumns(10);
			text_Precio.setBounds(594, 10, 260, 20);
			buttonPane.add(text_Precio);
			
			cmb_Especialidad = new JComboBox();
			cmb_Especialidad.setBounds(180, 78, 285, 22);
			ArrayList Datos2;
			try {
				Datos2 = new ArrayList(bbdd.consultaEspecialidades());
				for (int i = 0; i < Datos2.size(); i++) {
					String valor2 = (String) Datos2.get(i);
					cmb_Especialidad.addItem(valor2);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			buttonPane.add(cmb_Especialidad);
		}
		
		JLabel lblNewLabel = new JLabel("Datos tratamiento");
		lblNewLabel.setBounds(10, 485, 145, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		{
			JButton btn_modificarTratamiento = new JButton("Modificar");
			btn_modificarTratamiento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String []valores=new String[3];
					valores[0]="'"+text_NombreTrat.getText()+"'";
					valores[1]="'"+cmb_Especialidad.getSelectedItem().toString()+"'";
					valores[2]=""+text_Precio+"";
					bbdd.modificar("tratamiento", valores, true,table_tratamiento);
					table_tratamiento=bbdd.MostrarTabla("tratamiento", table_tratamiento);
				}
			});
			btn_modificarTratamiento.setBounds(694, 485, 85, 20);
			contentPanel.add(btn_modificarTratamiento);
			btn_modificarTratamiento.setActionCommand("Cancel");
		}
		
		JButton btn_agregarTratamiento = new JButton("Agregar");
		btn_agregarTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []valores=new String[3];
				valores[0]="'"+text_NombreTrat.getText()+"'";
				valores[1]="'"+cmb_Especialidad.getSelectedItem().toString()+"'";
				valores[2]=""+text_Precio+"";
				bbdd.insertar("tratamiento", valores, true);
				table_tratamiento=bbdd.MostrarTabla("tratamiento", table_tratamiento);
			}
		});
		btn_agregarTratamiento.setBounds(599, 485, 85, 20);
		contentPanel.add(btn_agregarTratamiento);
		btn_agregarTratamiento.setActionCommand("Cancel");
		
		JButton btn_bajaTratamiento = new JButton("Baja");
		btn_bajaTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []valores=new String[3];
				valores[0]="'"+text_NombreTrat.getText()+"'";
				valores[1]="'"+cmb_Especialidad.getSelectedItem().toString()+"'";
				valores[2]=""+text_Precio+"";
				bbdd.borrar("tratamiento", valores, true);
				table_tratamiento=bbdd.MostrarTabla("tratamiento", table_tratamiento);
			}
		});
		btn_bajaTratamiento.setActionCommand("Cancel");
		btn_bajaTratamiento.setBounds(789, 485, 85, 20);
		contentPanel.add(btn_bajaTratamiento);
		
		table_tratamiento = new JTable();
		table_tratamiento.setBounds(10, 11, 864, 463);
		table_tratamiento=bbdd.MostrarTabla("tratamiento", table_tratamiento);
		table_tratamiento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String[]valores=bbdd.SacarValoresTabla(table_tratamiento);
                    text_NombreTrat.setText(valores[1].toString());
                    selectItemInComboBox(cmb_Especialidad, valores[2]);
                    text_Precio.setText(valores[3].toString());
                }
            }
        });
		contentPanel.add(table_tratamiento);
		
		JLabel Fondo_Tratamiento = new JLabel("");
		Fondo_Tratamiento.setIcon(new ImageIcon("C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_Tratamiento.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_Tratamiento);
		
	}
	
	private void selectItemInComboBox(JComboBox<String> comboBox, String value) {
	    for (int i = 0; i < comboBox.getItemCount(); i++) {
	        if (comboBox.getItemAt(i).equals(value)) {
	            comboBox.setSelectedIndex(i);
	            return; // Sal del bucle si se encuentra el elemento
	        }
	    }
	}
}
