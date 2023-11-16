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

public class PaginaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPrincipal frame = new PaginaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public PaginaPrincipal() {
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gestón Paciente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paciente vPrincipalPaciente = new Paciente();
				vPrincipalPaciente.setVisible(true);
				vPrincipalPaciente.setModal(true);
				vPrincipalPaciente.setLocationRelativeTo(null);
				vPrincipalPaciente.setLocation(370, 212);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Doctores");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmGestionDoctores = new JMenuItem("Gestión Doctores");
		mntmGestionDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor vPrincipalDoctor = new Doctor();
				vPrincipalDoctor.setVisible(true);
				vPrincipalDoctor.setModal(true);
				vPrincipalDoctor.setLocationRelativeTo(null);
				vPrincipalDoctor.setLocation(370, 212);
			}
		});
		mnNewMenu_1.add(mntmGestionDoctores);
		
		JMenu mnNewMenu_2 = new JMenu("Tratamientos");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gestión Tratamientos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tratamiento vPrincipalTratamiento = new Tratamiento();
				vPrincipalTratamiento.setVisible(true);
				vPrincipalTratamiento.setModal(true);
				vPrincipalTratamiento.setLocationRelativeTo(null);
				vPrincipalTratamiento.setLocation(370, 212);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Especialidad");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gestión Facturación");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialidad vPrincipalEspecialidad = new Especialidad();
				vPrincipalEspecialidad.setVisible(true);
				vPrincipalEspecialidad.setModal(true);
				vPrincipalEspecialidad.setLocationRelativeTo(null);
				vPrincipalEspecialidad.setLocation(370, 212);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_4 = new JMenu("Materiales");
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Gestión Material");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Materiales vPrincipalMateriales = new Materiales();
				vPrincipalMateriales.setVisible(true);
				vPrincipalMateriales.setModal(true);
				vPrincipalMateriales.setLocationRelativeTo(null);
				vPrincipalMateriales.setLocation(370, 212);
			}
			
			
		});
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_5 = new JMenu("Cita");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Gestión Cita");
		
		
		
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cita vPrincipalCita = new Cita();
				vPrincipalCita.setVisible(true);
				vPrincipalCita.setModal(true);
				vPrincipalCita.setLocationRelativeTo(null);
				vPrincipalCita.setLocation(370, 212);
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
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(920, 10, 250, 250);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(920, 396, 90, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Rol:            Administrador");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(920, 439, 250, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lbl_DNI = new JLabel("DNIUSUARIO");
		lbl_DNI.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_DNI.setBounds(1020, 396, 150, 20);
		contentPane.add(lbl_DNI);

	}
	public PaginaPrincipal(String DNI) {
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gestón Paciente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paciente vPrincipalPaciente = new Paciente();
				vPrincipalPaciente.setVisible(true);
				vPrincipalPaciente.setModal(true);
				vPrincipalPaciente.setLocationRelativeTo(null);
				vPrincipalPaciente.setLocation(370, 212);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Doctores");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmGestionDoctores = new JMenuItem("Gestión Doctores");
		mntmGestionDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor vPrincipalDoctor = new Doctor();
				vPrincipalDoctor.setVisible(true);
				vPrincipalDoctor.setModal(true);
				vPrincipalDoctor.setLocationRelativeTo(null);
				vPrincipalDoctor.setLocation(370, 212);
			}
		});
		mnNewMenu_1.add(mntmGestionDoctores);
		
		JMenu mnNewMenu_2 = new JMenu("Tratamientos");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gestión Tratamientos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tratamiento vPrincipalTratamiento = new Tratamiento();
				vPrincipalTratamiento.setVisible(true);
				vPrincipalTratamiento.setModal(true);
				vPrincipalTratamiento.setLocationRelativeTo(null);
				vPrincipalTratamiento.setLocation(370, 212);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Rol:");
		JMenu mnNewMenu_3 = new JMenu("Especialidad");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gestión Facturación");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialidad vPrincipalEspecialidad = new Especialidad();
				vPrincipalEspecialidad.setVisible(true);
				vPrincipalEspecialidad.setModal(true);
				vPrincipalEspecialidad.setLocationRelativeTo(null);
				vPrincipalEspecialidad.setLocation(370, 212);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_4 = new JMenu("Materiales");
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Gestión Material");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Materiales vPrincipalMateriales = new Materiales();
				vPrincipalMateriales.setVisible(true);
				vPrincipalMateriales.setModal(true);
				vPrincipalMateriales.setLocationRelativeTo(null);
				vPrincipalMateriales.setLocation(370, 212);
			}
			
			
		});
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_5 = new JMenu("Cita");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Gestión Cita");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cita vPrincipalCita = new Cita();
				vPrincipalCita.setVisible(true);
				vPrincipalCita.setModal(true);
				vPrincipalCita.setLocationRelativeTo(null);
				vPrincipalCita.setLocation(370, 212);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_6 = new JMenu("Facturación");
		mnNewMenu_6.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnNewMenu_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(920, 10, 250, 250);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(920, 396, 90, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_11 = new JLabel("Rol:           Admin");
		lblNewLabel_1_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_11.setBounds(920, 439, 190, 20);
		contentPane.add(lblNewLabel_1_11);
		
		JLabel lbl_DNI = new JLabel(DNI);
		lbl_DNI.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_DNI.setBounds(1020, 396, 90, 20);
		contentPane.add(lbl_DNI);

			}
	public class KeyListenerExample implements KeyListener {
		
		
		@Override
		public void keyPressed(KeyEvent e) {
		       if (e.getKeyCode() == KeyEvent.VK_CONTROL && e.getKeyCode() == KeyEvent.VK_P) {
		    	   Paciente paciente=new Paciente();
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
	
	
	}

