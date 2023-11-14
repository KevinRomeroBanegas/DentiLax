package interfaz;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.text.DateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

public class Cita extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JTextField text_nombrePaciente;
	private JTextArea text_observacionesCita;
	private JTable table_cita;
	private JComboBox cmb_Tratamientos;
	private JComboBox cmb_Doctores;
	private JDateChooser fechaCalendario;

	public static void main(String[] args) {

	}

	public Cita(){
		setTitle("Cita");
		BBDD bbdd = new BBDD();
		bbdd.conectar();
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
				JLabel lbl_DNI = new JLabel("DNI Clientes:");
				lbl_DNI.setFont(new Font("Tahoma", Font.BOLD, 15));
				lbl_DNI.setBounds(10, 10, 150, 20);
				buttonPane.add(lbl_DNI);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Tratamiento:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 40, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Observaciones");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 70, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}

			text_nombrePaciente = new JTextField();
			text_nombrePaciente.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombrePaciente);
			text_nombrePaciente.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Doctor:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(537, 10, 135, 20);
			buttonPane.add(lblNewLabel_1);

			text_observacionesCita = new JTextArea();
			text_observacionesCita.setBounds(180, 70, 285, 52);
			buttonPane.add(text_observacionesCita);

			JLabel lbl_Fecha = new JLabel("Fecha:");
			lbl_Fecha.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbl_Fecha.setBounds(537, 40, 135, 20);
			buttonPane.add(lbl_Fecha);

			fechaCalendario = new JDateChooser();
			fechaCalendario.setBounds(655, 40, 200, 20);
			buttonPane.add(fechaCalendario);

			cmb_Doctores = new JComboBox();
			cmb_Doctores.setBounds(655, 11, 150, 22);
			buttonPane.add(cmb_Doctores);
			cmb_Doctores.setEnabled(false);

			cmb_Tratamientos = new JComboBox();
			cmb_Tratamientos.setBounds(180, 41, 285, 22);
			buttonPane.add(cmb_Tratamientos);

			JButton btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cmb_Doctores.setEnabled(true);
					String trat = cmb_Tratamientos.getSelectedItem().toString();
					ArrayList DatosFiltrados;
					try {
						DatosFiltrados = new ArrayList(bbdd.consultaDoctoresFiltrado(trat));
						for (int i = 0; i < DatosFiltrados.size(); i++) {
							String valor = (String) DatosFiltrados.get(i);
							cmb_Doctores.addItem(valor);
							DatosFiltrados.clear();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(823, 11, 32, 23);
			buttonPane.add(btnNewButton);

			ArrayList Datos2;
			try {
				Datos2 = new ArrayList(bbdd.consultaTratamientos());
				for (int i = 0; i < Datos2.size(); i++) {
					String valor2 = (String) Datos2.get(i);
					cmb_Tratamientos.addItem(valor2);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		JLabel lblNewLabel = new JLabel("Datos Cita");
		lblNewLabel.setBounds(10, 485, 105, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);

		JButton btn_modificarCita = new JButton("Modificar");
		btn_modificarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn_modificarCita.setBounds(695, 485, 85, 20);
		contentPanel.add(btn_modificarCita);

		JButton btn_agregarCita = new JButton("Agregar");
		btn_agregarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] valores= new String[5];
				valores[0]="'"+text_nombrePaciente.getText()+"'";
				valores[1]="'"+cmb_Doctores.getSelectedItem().toString()+"'";
				valores[2]="'"+cmb_Tratamientos.getSelectedItem().toString()+"'";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				valores[3]= "'"+sdf.format(fechaCalendario.getDate())+"'";
				valores[4]="'"+text_observacionesCita.getText()+"'";
				bbdd.insertar("cita", valores, true);
			}
		});
		btn_agregarCita.setBounds(600, 485, 85, 20);
		contentPanel.add(btn_agregarCita);

		JButton btn_bajaCita = new JButton("Baja");
		btn_bajaCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_bajaCita.setBounds(790, 485, 85, 20);
		contentPanel.add(btn_bajaCita);

		table_cita = new JTable();
		table_cita.setBounds(10, 11, 864, 463);
		contentPanel.add(table_cita);

	}
}
