package interfaz;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaz.BBDD;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class PaginaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lbl_ROL;
	private static String usuario;
	private static String rol;
	private static PaginaPrincipal frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*frame = new PaginaPrincipal(usuario, rol);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);*/
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public PaginaPrincipal(String usuario, String rol) {
		
		setTitle("DENTIAPP");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaginaPrincipal.class.getResource("/imagenes/diente.png")));
		setResizable(false);
		BBDD bbdd = new BBDD();
		bbdd.conectar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		
		JMenu mnNewMenu = new JMenu("Pacientes");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gestión Paciente");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paciente vPrincipalPaciente = new Paciente(frame, lbl_ROL.getText());
				vPrincipalPaciente.setLocationRelativeTo(null);
				vPrincipalPaciente.setLocation(370, 212);
				vPrincipalPaciente.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Doctores");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmGestionDoctores = new JMenuItem("Gestión Doctores");
		mntmGestionDoctores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		mntmGestionDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor vPrincipalDoctor = new Doctor();
				vPrincipalDoctor.setLocationRelativeTo(null);
				vPrincipalDoctor.setLocation(370, 212);
				vPrincipalDoctor.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmGestionDoctores);
		
		JMenu mnNewMenu_2 = new JMenu("Tratamientos");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gestión Tratamientos");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tratamiento vPrincipalTratamiento = new Tratamiento(frame, lbl_ROL.getText());
				vPrincipalTratamiento.setLocationRelativeTo(null);
				vPrincipalTratamiento.setLocation(370, 212);
				vPrincipalTratamiento.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Especialidad");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gestión Especialidad");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialidad vPrincipalEspecialidad = new Especialidad(frame, lbl_ROL.getText());
				vPrincipalEspecialidad.setLocationRelativeTo(null);
				vPrincipalEspecialidad.setLocation(370, 212);
				vPrincipalEspecialidad.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_4 = new JMenu("Stock");
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 30));
		boolean infoSol=bbdd.existeSolicitud();
		if(infoSol==true) {
			mnNewMenu_4.setOpaque(true);
			mnNewMenu_4.setBackground(new Color(153, 215, 222));
			mnNewMenu_4.setForeground(new Color(255, 255, 255));
		}
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Gestión Stock");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock vPrincipalMateriales = new Stock(frame, lbl_ROL.getText());
				vPrincipalMateriales.setLocationRelativeTo(null);
				vPrincipalMateriales.setLocation(370, 212);
				vPrincipalMateriales.setVisible(true);
			}
			
		});
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_4_1 = new JMenuItem("Solicitud Pedidos");
		mntmNewMenuItem_4_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Solicitud_Pedidos vMateriales = new Solicitud_Pedidos();
				vMateriales.setLocationRelativeTo(null);
				vMateriales.setLocation(370, 212);
				vMateriales.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_4_1);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Gestión Pedidos");
		mntmNewMenuItem_10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion_Pedidos gPedidos = new Gestion_Pedidos();
				gPedidos.setLocationRelativeTo(null);
				gPedidos.setLocation(370, 212);
				gPedidos.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_5 = new JMenu("Cita");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Gestión Cita");
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		
		
		
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cita vPrincipalCita = new Cita();
				vPrincipalCita.setLocationRelativeTo(null);
				vPrincipalCita.setLocation(370, 212);
				vPrincipalCita.setVisible(true);
				
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_6 = new JMenu("Facturación");
		mnNewMenu_6.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_6);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JMenuItem mntmNewMenuItem5 = new JMenuItem("Gestión Facturacion");
		mntmNewMenuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
		
		
		
		
		mntmNewMenuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Factura vPrincipalCita = new Factura();
				vPrincipalCita.setLocationRelativeTo(null);
				vPrincipalCita.setLocation(370, 212);
				vPrincipalCita.setVisible(true);
				
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem5);
		
		JMenu mnNewMenu_7 = new JMenu("Ayuda");
		mnNewMenu_7.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_7);
		mnNewMenu_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Manual de Ayuda");
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_7.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Ayuda ayuda=new Ayuda();
				ayuda.setLocationRelativeTo(null);
				ayuda.setLocation(370,212);				
				ayuda.setVisible(true);								
				
			}
						
			
		});
		
		
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Ayuda Cita");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Ayuda ayuda=new Ayuda();
				ayuda.setLocationRelativeTo(null);
				ayuda.setLocation(370,212);				
				ayuda.setVisible(true);								
				
			}
						
			
		});
		
		
		
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Ayuda Tratamiento");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Ayuda ayuda=new Ayuda();
				ayuda.setLocationRelativeTo(null);
				ayuda.setLocation(370,212);				
				ayuda.setVisible(true);								
				
			}
						
			
		});
		
		
		
		
		contentPane_1= new JPanel();
		
		

		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane_1, popupMenu);
		
		JMenuItem paciente = new JMenuItem("Gestion Paciente");
		paciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paciente paciente= new Paciente(frame, lbl_ROL.getText());
				paciente.setLocationRelativeTo(null);
				paciente.setLocation(370, 212);
				paciente.setVisible(true);
			}
		});
		popupMenu.add(paciente);
	
		;
		paciente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
	
		
		
		JMenuItem Doctores = new JMenuItem("Gestion de doctores");
		popupMenu.add(Doctores);
		Doctores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Doctor doctor= new Doctor();
				doctor.setLocationRelativeTo(null);
				doctor.setLocation(370, 212);
				doctor.setVisible(true);
			}
		});

		
		JMenuItem Tratamiento = new JMenuItem("Tratamientos");
		Tratamiento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Tratamiento tratamiento= new Tratamiento(frame, lbl_ROL.getText());
				tratamiento.setLocationRelativeTo(null);
				tratamiento.setLocation(370, 212);
				tratamiento.setVisible(true);
				
			}
		});
		popupMenu.add(Tratamiento);
		
		JMenuItem especialidad = new JMenuItem("Especialidad");
		especialidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Especialidad especialidad= new Especialidad(frame, lbl_ROL.getText());
				especialidad.setVisible(true);
				especialidad.setLocation(370,212);
			
			}
		});
		popupMenu.add(especialidad);
		
		JMenuItem material = new JMenuItem("Material");
		material.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Stock material= new Stock(frame, lbl_ROL.getText());
				material.setLocationRelativeTo(null);
				material.setLocation(370,212);
				material.setVisible(true);
				
			}
		});
		popupMenu.add(material);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Cita");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cita cita= new Cita();
				cita.setLocationRelativeTo(null);
				cita.setLocation(370,212);
				cita.setVisible(true);
				
			}
		});
		popupMenu.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Facturacion");
		mntmNewMenuItem_8.addMouseListener(new MouseAdapter() {
			
		});
		popupMenu.add(mntmNewMenuItem_8);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(926, 11, 250, 250);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(920, 554, 90, 20);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Rol:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(920, 597, 72, 20);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lbl_DNI = new JLabel(usuario);
		lbl_DNI.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_DNI.setBounds(1005, 554, 181, 20);
		contentPane_1.add(lbl_DNI);
		
		lbl_ROL = new JLabel(rol);
		lbl_ROL.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_ROL.setBounds(1005, 597, 181, 20);
		contentPane_1.add(lbl_ROL);
		
		JLabel imagen_fondo = new JLabel("");
		imagen_fondo.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/Fondo 1200x800.png")));
		imagen_fondo.setBounds(0, 0, 1200, 800);
		contentPane_1.add(imagen_fondo);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("New menu item");
		mntmNewMenuItem_6.setBounds(1065, 31, 135, 27);
		contentPane_1.add(mntmNewMenuItem_6);
		
		//condición para deshabilitar partes de menu a doctores
		if(lbl_ROL.getText().equals("Doctor")) {
			mnNewMenu_1.setEnabled(false);
			//mnNewMenu_3.setEnabled(false);
			mnNewMenu_5.setEnabled(false);
			mnNewMenu_6.setEnabled(false);
			mntmNewMenuItem_4.setEnabled(false);
			mntmNewMenuItem_10.setEnabled(false);
		}
		
		//condición para deshabilitar partes de menu a admin
		if(lbl_ROL.getText().equals("Admin")) {
			mntmNewMenuItem_4_1.setEnabled(false);
		}
		

	}
	
	public class KeyListenerExample implements KeyListener {
		
		
		@Override
		public void keyPressed(KeyEvent e) {
		       if (e.getKeyCode() == KeyEvent.VK_CONTROL && e.getKeyCode() == KeyEvent.VK_P) {
		    	   Paciente paciente=new Paciente(frame, lbl_ROL.getText());
		    	   paciente.setVisible(true);
		       }
		       
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	}

