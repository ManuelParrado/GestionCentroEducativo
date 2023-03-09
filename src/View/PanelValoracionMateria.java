package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.ControllerMateria;
import Controllers.ControllerValoracionMateria;
import Model.Materia;
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
	private JComboBox comboProfesor;
	private JComboBox comboEstudiante;
	private JComboBox comboMateria;
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
		
		comboProfesor = new JComboBox();
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
		
		comboEstudiante = new JComboBox();
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
		
		comboMateria = new JComboBox();
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
				jvaloracion.setText("");
				
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
		cargarPrimerRegistro();
		
	}
	
	/**
	 * 
	 */
	private void cargarPrimerRegistro() {
		
		ValoracionMateria valmat = new ControllerValoracionMateria().cargarPrimerRegistro();
		
		if (valmat != null) {
		
			jtextid.setText(Integer.toString(valmat.getId()));
			//ComboProfesor
			//ComboEstudiante
			//ComboMateria
			jvaloracion.setText(Float.toString(valmat.getValoracion()));

			
		}
	}
	
	
	/**
	 * 
	 */
	private void ultimoRegistro() {
		
		ValoracionMateria valmat = new ControllerValoracionMateria().cargarUltimoRegistro();

		if (valmat != null) {

			jtextid.setText(Integer.toString(valmat.getId()));
			//ComboProfesor
			//ComboEstudiante
			//ComboMateria
			jvaloracion.setText(Float.toString(valmat.getValoracion()));

		}
		
	}
	
	/**
	 * 
	 */
	private void siguienteRegistro() {
		
		ValoracionMateria valmat = new ValoracionMateria(
				Integer.parseInt(this.jtextid.getText()), 
				0, 0, 0,Float.parseFloat(this.jvaloracion.getText()));

		ValoracionMateria valmat2 = ControllerValoracionMateria.siguienteRegistro(valmat);

		if (valmat2 != null) {
			jtextid.setText(Integer.toString(valmat.getId()));
			//ComboProfesor
			//ComboEstudiante
			//ComboMateria
			jvaloracion.setText(Float.toString(valmat.getValoracion()));
		}
		
	}
	
	
	/**
	 * 
	 */
	private void anteriorRegistro() {

		ValoracionMateria valmat = new ValoracionMateria(
				Integer.parseInt(this.jtextid.getText()), 
				0, 0, 0,Float.parseFloat(this.jvaloracion.getText()));

		ValoracionMateria valmat2 = ControllerValoracionMateria.anteriorRegistro(valmat);

		if (valmat2 != null) {
			jtextid.setText(Integer.toString(valmat.getId()));
			//ComboProfesor
			//ComboEstudiante
			//ComboMateria
			jvaloracion.setText(Float.toString(valmat.getValoracion()));
		}

	}
	
	
	/**
	 * 
	 */
	private void guardarRegistro() {

		ValoracionMateria valmat = new ValoracionMateria(
				Integer.parseInt(this.jtextid.getText()), 
				0, 0, 0,Float.parseFloat(this.jvaloracion.getText()));

		int affected = ControllerValoracionMateria.guardarRegistro(valmat);

		compruebaAffected(affected);
		cargarPrimerRegistro();
	}
	
	
	/**
	 * 
	 */
	private void eliminarRegistro() {
		
		
		if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar?") == JOptionPane.YES_OPTION) {
			
			ValoracionMateria valmat = new ValoracionMateria(
					Integer.parseInt(this.jtextid.getText()), 
					0, 0, 0,Float.parseFloat(this.jvaloracion.getText()));

			int affected = ControllerValoracionMateria.eliminarRegistro(valmat);
			
			compruebaAffected(affected);
			
			anteriorRegistro();
			
		}
		
		
	}
	
	
	/**
	 * 
	 * @param affected
	 */
	private void compruebaAffected(int affected) {
		
		if (affected == 1) {
			JOptionPane.showInternalMessageDialog(null, 
					"Han sido afectadas "+affected+" filas");
		} else {
			JOptionPane.showInternalMessageDialog(null, 
					"Error, no se ha modicado ningun registro");
		}
		
	}

}
