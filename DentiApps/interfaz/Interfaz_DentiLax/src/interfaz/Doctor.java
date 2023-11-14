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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

public class Doctor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_nombreDoctor;
	private JTextField text_especialidadDoctor;
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
			buttonPane.setBounds(10, 516, 864, 133);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre y Apellidos:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
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
			
			text_especialidadDoctor = new JTextField();
			text_especialidadDoctor.setColumns(10);
			text_especialidadDoctor.setBounds(684, 13, 170, 20);
			buttonPane.add(text_especialidadDoctor);
		}
		
		JLabel lblNewLabel = new JLabel("Datos Doctor");
		lblNewLabel.setBounds(10, 485, 105, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		{
			JButton btn_modificarDoctor = new JButton("Modificar");
			btn_modificarDoctor.setBounds(694, 485, 85, 20);
			contentPanel.add(btn_modificarDoctor);
			btn_modificarDoctor.setActionCommand("Cancel");
		}
		
		JButton btn_agregarDoctor = new JButton("Agregar");
		btn_agregarDoctor.setBounds(599, 485, 85, 20);
		contentPanel.add(btn_agregarDoctor);
		btn_agregarDoctor.setActionCommand("Cancel");
		
		JButton btn_bajaDoctor = new JButton("Baja");
		btn_bajaDoctor.setActionCommand("Cancel");
		btn_bajaDoctor.setBounds(789, 485, 85, 20);
		contentPanel.add(btn_bajaDoctor);
		
		table_doctor = new JTable();
		table_doctor.setBounds(10, 11, 864, 463);
		table_doctor=bbdd.MostrarTabla("Doctor", table_doctor);
		table_doctor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String[]valores=bbdd.SacarValoresTabla(table_doctor);
                    text_nombreDoctor.setText(valores[1].toString());
                    text_especialidadDoctor.setText(valores[2].toString());
                }
            }
        });
		contentPanel.add(table_doctor);
		
	}
}
