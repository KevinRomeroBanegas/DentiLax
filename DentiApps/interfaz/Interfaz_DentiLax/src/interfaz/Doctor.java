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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import javax.swing.JComboBox;

public class Doctor extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_nombreDoctor;
	private JComboBox cmb_Especialidad;
	private JTable table_doctor;

	public static void main(String[] args) {
		try {
			Doctor dialog = new Doctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Doctor() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);
		BBDD bbdd=new BBDD();
		bbdd.conectar();
		setTitle("Doctor");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 570, 864, 79);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre y Apellidos:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 172, 20);
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
			
			JButton btn_filtrarTabla = new JButton("Filtrar tabla");
			btn_filtrarTabla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String consulta=JOptionPane.showInputDialog("Ponga el ID por el cual quiere filtrar la tabla");
					bbdd.filtro(consulta, table_doctor);
				}
			});
			btn_filtrarTabla.setBounds(749, 49, 105, 20);
			buttonPane.add(btn_filtrarTabla);
			
			cmb_Especialidad = new JComboBox();
			cmb_Especialidad.setBounds(682, 11, 172, 22);
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
		
		JLabel lblNewLabel = new JLabel("Datos Doctor");
		lblNewLabel.setBounds(10, 536, 105, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		{
			JButton btn_modificarDoctor = new JButton("Modificar");
			btn_modificarDoctor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(text_nombreDoctor.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Rellena el campo nombre y Apellidos");
					}else if(cmb_Especialidad.getSelectedItem().equals(null)){
						JOptionPane.showMessageDialog(null, "Rellena el campo especialidad");
					}else {
					
					JOptionPane.showMessageDialog(null, "Doctor Modificado");
					String valores[]=new String [2]; 
					valores[0]="'"+text_nombreDoctor.getText()+"'";
	            	valores[1]="'"+cmb_Especialidad.getSelectedItem().toString()+"'";
	            	bbdd.modificar("doctor", valores, true,table_doctor);
					table_doctor=bbdd.MostrarTabla("doctor", table_doctor);
					
					}
				}
			});
			btn_modificarDoctor.setBounds(689, 536, 90, 20);
			contentPanel.add(btn_modificarDoctor);
		}
		
		JButton btn_agregarDoctor = new JButton("Agregar");
		btn_agregarDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(text_nombreDoctor.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo nombre y Apellidos");
				}else if(cmb_Especialidad.getSelectedItem().equals(null)){
					JOptionPane.showMessageDialog(null, "Rellena el campo especialidad");
				}else {
				
				JOptionPane.showMessageDialog(null, "Doctor Agregado");
				String valores[]=new String [2]; 
				valores[0]="'"+text_nombreDoctor.getText()+"'";
            	valores[1]="'"+cmb_Especialidad.getSelectedItem().toString()+"'";
            	bbdd.insertar("doctor", valores, true);
				table_doctor=bbdd.MostrarTabla("doctor", table_doctor);
				int result = JOptionPane.showConfirmDialog(null,"¿Quieres añadir este doctor como usuario?", "USUARIO",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	String valoresUsuario[]=new String [4];
			            	valoresUsuario[0]="'"+JOptionPane.showInputDialog("Añada el DNI")+"'";
			            	valoresUsuario[2]="'"+JOptionPane.showInputDialog("Añada la contraseña")+"'";
			            	valoresUsuario[1]="'"+text_nombreDoctor.getText()+"'";
			            	valoresUsuario[3]="0";
			            	bbdd.insertar("usuario", valoresUsuario, false);
			            	
			            }
				
				}
			}
		});
		btn_agregarDoctor.setBounds(594, 536, 85, 20);
		contentPanel.add(btn_agregarDoctor);

		
		JButton btn_bajaDoctor = new JButton("Baja");
		btn_bajaDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Doctor dado de baja");
				String valores[]=new String [2]; 
				valores[0]="'"+text_nombreDoctor.getText()+"'";
            	valores[1]="'"+cmb_Especialidad.getSelectedItem().toString()+"'";
            	bbdd.borrar("doctor", valores, true);
				table_doctor=bbdd.MostrarTabla("doctor", table_doctor);
			}
		});
		btn_bajaDoctor.setBounds(789, 536, 85, 20);
		contentPanel.add(btn_bajaDoctor);
		
		
		
		table_doctor = new JTable();
		table_doctor.setBounds(10, 11, 864, 515);
		table_doctor=bbdd.MostrarTabla("Doctor", table_doctor);
		table_doctor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String[]valores=bbdd.SacarValoresTabla(table_doctor);
                    text_nombreDoctor.setText(valores[1].toString());
                    selectItemInComboBox(cmb_Especialidad, valores[2]);
                }
            }
        });
		contentPanel.add(table_doctor);
		
		
		
		JLabel Fondo_doctor = new JLabel("");
		Fondo_doctor.setIcon(new ImageIcon("C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_doctor.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_doctor);
		
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
