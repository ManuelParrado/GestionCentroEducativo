package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Controllers.ControllerEstudiante;
import Controllers.ControllerMateria;
import Controllers.ControllerProfesor;
import Controllers.ControllerValoracionMateria;
import Model.Estudiante;
import Model.Materia;
import Model.Profesor;
import Model.ValoracionMateria;

import javax.swing.JComboBox;

public class PanelValoracionMateria extends JPanel {

	private JTextField jtextid;
	private JTextField jvaloracion;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox<Profesor> comboProfesor;
	private JComboBox<Estudiante> comboEstudiante;
	private JComboBox<Materia> comboMateria;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	public PanelValoracionMateria() {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);
		
		lblNewLabel_1 = new JLabel(" Gestión de Valoracion Materia");
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
		jtextid.setEnabled(false);
		
		lblNewLabel_2 = new JLabel("IdProfesor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_comboProfesor = new GridBagConstraints();
		gbc_comboProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_comboProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboProfesor.gridx = 1;
		gbc_comboProfesor.gridy = 2;
		add(comboProfesor, gbc_comboProfesor);
		
		lblNewLabel_3 = new JLabel("IdEstudiante");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		comboEstudiante = new JComboBox<Estudiante>();
		GridBagConstraints gbc_comboEstudiante = new GridBagConstraints();
		gbc_comboEstudiante.insets = new Insets(0, 0, 5, 0);
		gbc_comboEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboEstudiante.gridx = 1;
		gbc_comboEstudiante.gridy = 3;
		add(comboEstudiante, gbc_comboEstudiante);
		
		lblNewLabel_4 = new JLabel("IdMateria");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		comboMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_comboMateria = new GridBagConstraints();
		gbc_comboMateria.insets = new Insets(0, 0, 5, 0);
		gbc_comboMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboMateria.gridx = 1;
		gbc_comboMateria.gridy = 4;
		add(comboMateria, gbc_comboMateria);
		
		JLabel lblNewLabel = new JLabel("Valoración");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		jvaloracion = new JTextField();
		GridBagConstraints gbc_jvaloracion = new GridBagConstraints();
		gbc_jvaloracion.insets = new Insets(0, 0, 5, 0);
		gbc_jvaloracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jvaloracion.gridx = 1;
		gbc_jvaloracion.gridy = 5;
		this.add(jvaloracion, gbc_jvaloracion);
		jvaloracion.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
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
				cargarEnPantalla(ControllerValoracionMateria.anteriorRegistro(
						Integer.parseInt(jtextid.getText())));
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Boton Siguiente
				cargarEnPantalla(ControllerValoracionMateria.siguienteRegistro(
						Integer.parseInt(jtextid.getText())));
				
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Boton Ultimo Registro
				cargarEnPantalla(ControllerValoracionMateria.cargarUltimoRegistro());
				
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
				
				limpiarDatos();
				
			}
		});
		panel.add(btnModificar);
		panel.add(btnGuardar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eliminarRegistro();
				
			}
		});
		panel.add(btnEliminar);
		
		cargarProfesorEnJCombo();
		cargarEstudianteEnJCombo();
		cargarMateriaEnJCombo();	
		cargarPrimerRegistro();
		
	}
	
	
	
	/**
	 * 
	 */
	private void cargarMateriaEnJCombo() {
		
		List<Materia> materias = ControllerMateria.findAll();
		for (Materia materia : materias) {
			this.comboMateria.addItem(materia);
		}
	}
	
	/**
	 * 
	 */
	private void cargarProfesorEnJCombo() {
		
		List<Profesor> profesores = ControllerProfesor.findAll();
		for (Profesor profesor : profesores) {
			this.comboProfesor.addItem(profesor);
		}
		
	}
	
	/**
	 * 
	 */
	private void cargarEstudianteEnJCombo() {
		List<Estudiante> estudiantes = ControllerEstudiante.findAll();
		for (Estudiante estudiante : estudiantes) {
			this.comboEstudiante.addItem(estudiante);
		}
	}
	
	
	/**
	 * 
	 */
	private void cargarPrimerRegistro() {
		cargarEnPantalla(ControllerValoracionMateria.cargarPrimerRegistro());
		
	}
	
	
	/**
	 * 
	 */
	private void guardarRegistro() {

		ValoracionMateria var = new ValoracionMateria();
		var.setId(Integer.parseInt(this.jtextid.getText()));
		
		Profesor profesor = (Profesor) this.comboProfesor.getSelectedItem();
		var.setIdProfesor(profesor.getId());
		
		Estudiante estudiante = (Estudiante) this.comboEstudiante.getSelectedItem();
		var.setIdEstudiante(estudiante.getId());
		
		Materia materia = (Materia) this.comboMateria.getSelectedItem();
		var.setIdMateria(materia.getId());
		
		var.setValoracion(Float.parseFloat(this.jvaloracion.getText()));
		
		String strError = "No se ha podido guardar";
		if (var.getId() == 0) {
			int nuevoIdInsertado = ControllerValoracionMateria.insertar(var);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
			else {
				this.jtextid.setText("" + nuevoIdInsertado);
			}
		}
		else {
			if (ControllerValoracionMateria.modificar(var) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}
		
	}
	
	
	/**
	 * 
	 */
	private void eliminarRegistro() {
		
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", 
				"Eliminación", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
				null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	int actualId = Integer.parseInt(this.jtextid.getText());
		    if (ControllerValoracionMateria.eliminarRegistro(actualId) != 1) {
		    	JOptionPane.showMessageDialog(null, "Algo ha salido mal");
		    }
		    else {
		    	// Cargo otro registro en pantalla
		    	ValoracionMateria mAnterior = ControllerValoracionMateria.anteriorRegistro(actualId);
		    	if (mAnterior != null) {
		    		cargarEnPantalla(mAnterior);
		    	}
		    	else {
		    		ValoracionMateria mSiguiente = ControllerValoracionMateria.siguienteRegistro(actualId);
		    		if (mSiguiente != null) {
		    			cargarEnPantalla(mSiguiente);
		    		}
		    		else { // No quedan registros, has eliminado el único
		    			limpiarDatos();
		    		}
		    	}
		    }
	    }
			
	}
	
	/**
	 * 
	 */
	private void limpiarDatos() {
		this.jtextid.setText("0");
		this.jvaloracion.setText("");
		
		if (this.comboProfesor.getItemCount() > 0) {
			this.comboProfesor.setSelectedIndex(0);
		}
		
		if (this.comboEstudiante.getItemCount() > 0) {
			this.comboEstudiante.setSelectedIndex(0);
		}
		
		if (this.comboMateria.getItemCount() > 0) {
			this.comboMateria.setSelectedIndex(0);
		}
		
	}
	
	/**
	 * 
	 * @param m
	 */
	private void cargarEnPantalla (ValoracionMateria vm) {
		
	if (vm != null) {
		this.jtextid.setText("" + vm.getId());
		this.jvaloracion.setText("" + vm.getValoracion());
		for (int i = 0; i < this.comboProfesor.getItemCount(); i++) {
			Profesor p = this.comboProfesor.getItemAt(i);
			if (vm.getIdProfesor() == p.getId()) {
				this.comboProfesor.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < this.comboEstudiante.getItemCount(); i++) {
			Estudiante e = this.comboEstudiante.getItemAt(i);
			if (vm.getId() == e.getId()) {
				this.comboEstudiante.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < this.comboMateria.getItemCount(); i++) {
			Materia m = this.comboMateria.getItemAt(i);
			if (vm.getIdMateria() == m.getId()) {
				this.comboMateria.setSelectedIndex(i);
			}
		}

	}

	// Habilito y deshabilito botones de navegación
	if (ControllerValoracionMateria.anteriorRegistro(Integer.parseInt(jtextid.getText())) == null) {
		this.btnPrimero.setEnabled(false);
		this.btnAnterior.setEnabled(false);
	} else {
		this.btnPrimero.setEnabled(true);
		this.btnAnterior.setEnabled(true);
	}

	if (ControllerValoracionMateria.siguienteRegistro(Integer.parseInt(jtextid.getText())) == null) {
		this.btnUltimo.setEnabled(false);
		this.btnSiguiente.setEnabled(false);
	} else {
		this.btnUltimo.setEnabled(true);
		this.btnSiguiente.setEnabled(true);
	}
	
	}
	
	

}
