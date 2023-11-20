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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;

public class Especialidad extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JTextField text_nombreDoctor;
	private JTable table_especialidad;

	public static void main(String[] args) {

	}

	public Especialidad() {
		BBDD bbdd = new BBDD();
		bbdd.conectar();
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);

		setTitle("Especialidad");
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 884, 660);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 605, 864, 44);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}

			text_nombreDoctor = new JTextField();
			text_nombreDoctor.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombreDoctor);
			text_nombreDoctor.setColumns(10);
			
			JButton btn_filtrarTabla = new JButton("Filtrar tabla");
			btn_filtrarTabla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String consulta=JOptionPane.showInputDialog("Ponga el nombre por el cual quiere filtrar la tabla");
					bbdd.filtro(consulta, table_especialidad);
				}
			});
			btn_filtrarTabla.setBounds(749, 12, 105, 20);
			buttonPane.add(btn_filtrarTabla);
		}

		JLabel lblNewLabel = new JLabel("Datos Especialidad");
		lblNewLabel.setBounds(10, 574, 150, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);

		JButton btn_modificarEspecialidad = new JButton("Modificar");
		btn_modificarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_nombreDoctor.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre Doctor");
				} else {
					JOptionPane.showMessageDialog(null, "Especialidad Modificada");
					String []valores=new String [1];
					valores[0]=text_nombreDoctor.getText();
					bbdd.modificar("especialidad", valores, false, table_especialidad);
					table_especialidad=bbdd.MostrarTabla("especialidad", table_especialidad);
				}
			}
		});
		btn_modificarEspecialidad.setBounds(695, 574, 85, 20);
		contentPanel.add(btn_modificarEspecialidad);

		JButton btn_agregarEspecialidad = new JButton("Agregar");
		btn_agregarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_nombreDoctor.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre Doctor");
				} else {
					String []valores=new String [1];
					valores[0]=text_nombreDoctor.getText();
					bbdd.insertar("especialidad", valores, false);
					JOptionPane.showMessageDialog(null, "Especialidad Agregada");
					table_especialidad=bbdd.MostrarTabla("especialidad", table_especialidad);

				}

			}
		});
		btn_agregarEspecialidad.setBounds(600, 574, 85, 20);
		contentPanel.add(btn_agregarEspecialidad);

		JButton btn_bajaEspecialidad = new JButton("Baja");
		btn_bajaEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_nombreDoctor.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre Doctor");

				} else {
					String []valores=new String [1];
					valores[0]=text_nombreDoctor.getText();
					bbdd.borrar("especialidad", valores, false);
					JOptionPane.showMessageDialog(null, "Especialidad dada de Baja");
					table_especialidad=bbdd.MostrarTabla("especialidad", table_especialidad);

				}
			}
		});
		btn_bajaEspecialidad.setBounds(790, 574, 85, 20);
		contentPanel.add(btn_bajaEspecialidad);

		table_especialidad = new JTable();
		table_especialidad.setBounds(10, 11, 864, 552);
		table_especialidad = bbdd.MostrarTabla("especialidad", table_especialidad);
		contentPanel.add(table_especialidad);

		JLabel Fondo_especialidad = new JLabel("");
		Fondo_especialidad.setIcon(new ImageIcon(
				"C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_especialidad.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_especialidad);

	}
}
