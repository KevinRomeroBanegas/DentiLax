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
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class Tratamiento extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_nombreProveedor;
	private JTextField text_dniProveedor;
	private JTextField text_direccionProveedor;
	private JTextField text_emailProveedor;
	private JTextField text_telefonoProveedor;
	private JTable table_tratamiento;

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
		BBDD bbdd=new BBDD();
		setTitle("Tratamiento");
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
				lblNewLabel_1.setBounds(510, 10, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Cantidad:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 100, 150, 20);
				lblNewLabel_1.setBounds(510, 61, 150, 20);
				buttonPane.add(lblNewLabel_1);
			}
			
			text_nombreProveedor = new JTextField();
			text_nombreProveedor.setBounds(180, 10, 285, 20);
			buttonPane.add(text_nombreProveedor);
			text_nombreProveedor.setColumns(10);
			
			text_dniProveedor = new JTextField();
			text_dniProveedor.setColumns(10);
			text_dniProveedor.setBounds(180, 40, 285, 20);
			text_dniProveedor.setBounds(10, 40, 285, 20);
			buttonPane.add(text_dniProveedor);
			
			text_direccionProveedor = new JTextField();
			text_direccionProveedor.setColumns(10);
			text_direccionProveedor.setBounds(180, 70, 285, 20);
			text_direccionProveedor.setBounds(510, 43, 285, 20);
			buttonPane.add(text_direccionProveedor);
			
			text_emailProveedor = new JTextField();
			text_emailProveedor.setColumns(10);
			text_emailProveedor.setBounds(180, 100, 285, 20);
			text_emailProveedor.setBounds(510, 91, 285, 20);
			buttonPane.add(text_emailProveedor);
			
			JLabel lblNewLabel_1 = new JLabel("Distribuidor:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(537, 10, 135, 20);
			buttonPane.add(lblNewLabel_1);
			
			text_telefonoProveedor = new JTextField();
			text_telefonoProveedor.setBounds(684, 10, 170, 20);
			buttonPane.add(text_telefonoProveedor);
			text_telefonoProveedor.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("Datos tratamiento");
		lblNewLabel.setBounds(10, 485, 145, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);
		{
			JButton btn_modificarTratamiento = new JButton("Modificar");
			btn_modificarTratamiento.setBounds(694, 485, 85, 20);
			contentPanel.add(btn_modificarTratamiento);
			btn_modificarTratamiento.setActionCommand("Cancel");
		}
		
		JButton btn_agregarTratamiento = new JButton("Agregar");
		btn_agregarTratamiento.setBounds(599, 485, 85, 20);
		contentPanel.add(btn_agregarTratamiento);
		btn_agregarTratamiento.setActionCommand("Cancel");
		
		JButton btn_bajaTratamiento = new JButton("Baja");
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
                    text_dniProveedor.setText(valores[1].toString());
                    text_direccionProveedor.setText(valores[2].toString());
                    text_emailProveedor.setText(valores[3].toString());
                }
            }
        });
		contentPanel.add(table_tratamiento);
		
	}
}
