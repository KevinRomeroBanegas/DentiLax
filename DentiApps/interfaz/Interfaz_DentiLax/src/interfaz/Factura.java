package interfaz;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.apache.commons.collections4.map.HashedMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;
import java.awt.Color;
import java.awt.Dialog;

public class Factura extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JTextField text_idCita;
	private JTable table_especialidad;
	private JasperReport reporte;

	public static void main(String[] args) {

	}

	public Factura() {
		BBDD bbdd = new BBDD();
		bbdd.conectar();
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setResizable(false);

		setTitle("Facturación");
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
			buttonPane.setBounds(10, 605, 864, 44);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("ID Cita:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}

			text_idCita = new JTextField();
			text_idCita.setBounds(180, 10, 285, 20);
			buttonPane.add(text_idCita);
			text_idCita.setColumns(10);

			JButton btn_filtrarTabla = new JButton("Filtrar tabla");
			btn_filtrarTabla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String consulta = JOptionPane.showInputDialog("Ponga el ID por el cual quiere filtrar la tabla");
					bbdd.filtro(consulta, table_especialidad);
				}
			});
			btn_filtrarTabla.setBounds(749, 12, 105, 20);
			buttonPane.add(btn_filtrarTabla);

			JButton btnNewButton = new JButton("Sacar factura");
			btnNewButton.setBounds(634, 12, 105, 20);
			buttonPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Map<String, Object> parametros = new HashedMap<String, Object>();
						parametros.put("DNICliente", bbdd.sacarDNI(text_idCita.getText()));
						reporte = JasperCompileManager
								.compileReport("interfaz/Interfaz_DentiLax/src/Informes/factura.jrxml");
						JasperPrint p = JasperFillManager.fillReport(reporte, parametros, bbdd.conectar());
						JasperViewer viewer = new JasperViewer(p, false);
			            viewer.setVisible(true);
			            dispose();
			            viewer.toFront();
						
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		}

		JLabel lblNewLabel = new JLabel("Datos Facturas");
		lblNewLabel.setBounds(10, 574, 150, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);

		JButton btn_modificarEspecialidad = new JButton("Modificar");
		btn_modificarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_idCita.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo ID Cita");
				} else {
					JOptionPane.showMessageDialog(null, "Factura Modificada");
					String[] valores = new String[1];
					valores[0] = text_idCita.getText();
					bbdd.modificar("factura", valores, false, table_especialidad);
					table_especialidad = bbdd.MostrarTabla("factura", table_especialidad);
				}
			}
		});
		btn_modificarEspecialidad.setBounds(695, 574, 85, 20);
		contentPanel.add(btn_modificarEspecialidad);

		JButton btn_agregarEspecialidad = new JButton("Agregar");
		btn_agregarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_idCita.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo ID Cita");
				} else {
					String[] valores = new String[1];
					valores[0] = text_idCita.getText();
					bbdd.insertar("factura", valores, false);
					JOptionPane.showMessageDialog(null, "Factura Agregada");
					table_especialidad = bbdd.MostrarTabla("factura", table_especialidad);

				}

			}
		});
		btn_agregarEspecialidad.setBounds(600, 574, 85, 20);
		contentPanel.add(btn_agregarEspecialidad);

		JButton btn_bajaEspecialidad = new JButton("Baja");
		btn_bajaEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_idCita.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Rellena el campo ID Cita");

				} else {
					String[] valores = new String[1];
					valores[0] = text_idCita.getText();
					bbdd.borrar("factura", valores, false);
					JOptionPane.showMessageDialog(null, "Factura Borrada");
					table_especialidad = bbdd.MostrarTabla("factura", table_especialidad);

				}
			}
		});
		btn_bajaEspecialidad.setBounds(790, 574, 85, 20);
		contentPanel.add(btn_bajaEspecialidad);

		table_especialidad = new JTable();
		table_especialidad.setBounds(10, 11, 864, 552);
		table_especialidad = bbdd.MostrarTabla("factura", table_especialidad);
		table_especialidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String[] valores = bbdd.SacarValoresTabla(table_especialidad);
					text_idCita.setText(valores[0].toString());
				}
			}
		});
		contentPanel.add(table_especialidad);

		JLabel Fondo_especialidad = new JLabel("");
		Fondo_especialidad.setIcon(new ImageIcon(
				"C:\\Users\\kevin\\Documents\\GitHub\\DentiLax\\DentiApps\\interfaz\\Interfaz_DentiLax\\Fondo 1200x800.png"));
		Fondo_especialidad.setBounds(0, 0, 884, 660);
		contentPanel.add(Fondo_especialidad);

	}
}
