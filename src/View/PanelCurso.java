package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controllers.ControllerCurso;
import Model.Curso;

import java.awt.GridLayout;

public class PanelCurso extends JPanel {

	private JTextField jtextid;
	private JTextField jdescripcion;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnInsertar;
	
	
	public PanelCurso() {

		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);
		
		lblNewLabel_1 = new JLabel(" Gestión de cursos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblId = new JLabel(" id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		this.add(lblId, gbc_lblId);
		
		jtextid = new JTextField();
		GridBagConstraints gbc_jtextid = new GridBagConstraints();
		gbc_jtextid.weightx = 1.0;
		gbc_jtextid.insets = new Insets(0, 0, 5, 0);
		gbc_jtextid.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextid.gridx = 1;
		gbc_jtextid.gridy = 1;
		this.add(jtextid, gbc_jtextid);
		jtextid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" Descripcion:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		jdescripcion = new JTextField();
		GridBagConstraints gbc_jdescripcion = new GridBagConstraints();
		gbc_jdescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jdescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jdescripcion.gridx = 1;
		gbc_jdescripcion.gridy = 2;
		this.add(jdescripcion, gbc_jdescripcion);
		jdescripcion.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		this.add(panel, gbc_panel);
		
		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Boton Primer Registro
				cargarPrimerRegistro();
			}
		});
		panel.add(btnPrimero);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Boton Anterior Registro
				anteriorRegistro();
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Boton Siguiente
				siguienteRegistro();
				
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Boton Ultimo Registro
				ultimoRegistro();
				
			}
		});
		panel.add(btnUltimo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guardarRegistro();
				
			}
		});
		
		btnModificar = new JButton("Nuevo");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtextid.setText("0");
				jdescripcion.setText("");
				
			}
		});
		panel.add(btnModificar);
		panel.add(btnGuardar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insertarRegistro();
				
			}
		});
		panel.add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminarRegistro();
				
			}
		});
		panel.add(btnEliminar);
		cargarPrimerRegistro();
		
	}
	
	/**
	 * 
	 */
	private void insertarRegistro() {
		
		Curso curso = new Curso(Integer.parseInt(this.jtextid.getText()), this.jdescripcion.getText());

		Curso curso2 = ControllerCurso.insertarRegistro(curso, this.jtextid.getText());

		if (curso2 != null) {
			jtextid.setText(Integer.toString(curso.getId()));
			jdescripcion.setText(curso.getDescripcion());
		}
		
	}
	
	
	/**
	 * 
	 */
	private void guardarRegistro() {
		
		Curso curso = new Curso(Integer.parseInt(this.jtextid.getText()), this.jdescripcion.getText());
		
		Curso curso2 = ControllerCurso.guardarRegistro(curso);
		
		if (curso2 != null) {
			jtextid.setText(Integer.toString(curso.getId()));
			jdescripcion.setText(curso.getDescripcion());
		}
		
	}
	
	
	/**
	 * 
	 */
	private void eliminarRegistro() {
		
		Curso curso = new Curso(Integer.parseInt(this.jtextid.getText()), this.jdescripcion.getText());

		ControllerCurso.eliminarRegistro(curso);

		anteriorRegistro();
		
	}
	
	
	
	/**
	 * 
	 */
	private void cargarPrimerRegistro() {
		
		Curso curso = new ControllerCurso().cargarPrimerRegistro();
		
		if (curso != null) {
			jtextid.setText(Integer.toString(curso.getId()));
			jdescripcion.setText(curso.getDescripcion());
		}
			
	}
	
	
	/**
	 * 
	 */
	private void siguienteRegistro() {
		
		Curso curso = new Curso(Integer.parseInt(this.jtextid.getText()), this.jdescripcion.getText());
		
		Curso curso2 = ControllerCurso.siguienteRegistro(curso);
		
		if (curso2 != null) {
			jtextid.setText(Integer.toString(curso.getId()));
			jdescripcion.setText(curso.getDescripcion());
		}
		
	}
	
	
	/**
	 * 
	 */
	private void anteriorRegistro() {

		Curso curso = new Curso(Integer.parseInt(this.jtextid.getText()), this.jdescripcion.getText());

		Curso curso2 = ControllerCurso.anteriorRegistro(curso);

		if (curso2 != null) {
			jtextid.setText(Integer.toString(curso.getId()));
			jdescripcion.setText(curso.getDescripcion());
		}

	}

	
	/**
	 * 
	 */
	private void ultimoRegistro() {
		
		Curso curso = new ControllerCurso().cargarUltimoRegistro();
		
		if (curso != null) {
			jtextid.setText(Integer.toString(curso.getId()));
			jdescripcion.setText(curso.getDescripcion());
		}
		
	}
	

}
