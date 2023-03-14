package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import tutorialJava.capitulo8_AWT_SWING.ejemplos.ejemploJTabbedPane.PanelGestionCurso;
import tutorialJava.capitulo8_AWT_SWING.ejemplos.ejemploJTabbedPane.VentanaPrincipal;

public class PrincipalWindow2 extends JFrame {

	/**
	 * 
	 */
	public PrincipalWindow2 () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTabbedPane tabedPane = new JTabbedPane();
		
		tabedPane.add("PanelPrueba", new PanelPrueba());
		
		tabedPane.add("Cursos", new PanelCurso());
		
		tabedPane.add("Materia", new PanelMateria());
		
		tabedPane.add("Estudiante", new PanelEstudiante());
		
		tabedPane.add("Profesor", new PanelProfesor());
		
		tabedPane.add("Valoracion Materia", new PanelValoracionMateria());
		
		
		this.setContentPane(tabedPane);
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		PrincipalWindow2 v = new PrincipalWindow2();
		v.setVisible(true);
	}

}
