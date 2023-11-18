package labeltitulo;

import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;


public class Labeltitulo extends JLabel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//metodo con características de botón
	public Labeltitulo() {
		super();
		setVerticalAlignment(SwingConstants.BOTTOM);
		setBounds(0,0, 230, 60);
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(new Color(255, 255, 255));
		setText("INICIO DE SESIÓN");
		setFont(new Font("Calibri", Font.BOLD, 28));
		initcomponents();
	}
	
	//metodo mouse moved
		private void initcomponents() {
			addMouseMotionListener(new MouseMotionAdapter() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					visualizargif(e);
				}
			});
			
		}
		
		//metodo cambio de texto a gif
		private void visualizargif(MouseEvent e) {
			setText("");
			setIcon(new ImageIcon(Labeltitulo.class.getResource("/icono/textoanimado.gif")));
		}
		

}