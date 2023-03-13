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

import Controllers.ControllerEstudiante;
import Model.Estudiante;

public class PanelProfesor extends JPanel {

	private JTextField jtextid;
	private JTextField jnombre;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblApellido;
	private JLabel lblApellido_2;
	private JLabel lblDni;
	private JLabel lblDireccin;
	private JLabel lblEmail;
	private JLabel lblTelfono;
	private JTextField japellido1;
	private JTextField japellido2;
	private JTextField jdni;
	private JTextField jdireccion;
	private JTextField jemail;
	private JTextField jtelefono;

	
	public PanelProfesor() {
		
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);
		
		lblNewLabel_1 = new JLabel(" Gestión de Estudiantes");
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
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		jnombre = new JTextField();
		GridBagConstraints gbc_jnombre = new GridBagConstraints();
		gbc_jnombre.insets = new Insets(0, 0, 5, 0);
		gbc_jnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jnombre.gridx = 1;
		gbc_jnombre.gridy = 2;
		this.add(jnombre, gbc_jnombre);
		jnombre.setColumns(10);
		
		lblApellido = new JLabel("Primer Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 3;
		add(lblApellido, gbc_lblApellido);
		
		japellido1 = new JTextField();
		japellido1.setColumns(10);
		GridBagConstraints gbc_japellido1 = new GridBagConstraints();
		gbc_japellido1.insets = new Insets(0, 0, 5, 0);
		gbc_japellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_japellido1.gridx = 1;
		gbc_japellido1.gridy = 3;
		add(japellido1, gbc_japellido1);
		
		lblApellido_2 = new JLabel("Segundo Apellido");
		lblApellido_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblApellido_2 = new GridBagConstraints();
		gbc_lblApellido_2.anchor = GridBagConstraints.EAST;
		gbc_lblApellido_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido_2.gridx = 0;
		gbc_lblApellido_2.gridy = 4;
		add(lblApellido_2, gbc_lblApellido_2);
		
		japellido2 = new JTextField();
		japellido2.setColumns(10);
		GridBagConstraints gbc_japellido2 = new GridBagConstraints();
		gbc_japellido2.insets = new Insets(0, 0, 5, 0);
		gbc_japellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_japellido2.gridx = 1;
		gbc_japellido2.gridy = 4;
		add(japellido2, gbc_japellido2);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 5;
		add(lblDni, gbc_lblDni);
		
		jdni = new JTextField();
		jdni.setColumns(10);
		GridBagConstraints gbc_jdni = new GridBagConstraints();
		gbc_jdni.insets = new Insets(0, 0, 5, 0);
		gbc_jdni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jdni.gridx = 1;
		gbc_jdni.gridy = 5;
		add(jdni, gbc_jdni);
		
		lblDireccin = new JLabel("Dirección");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.EAST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 0;
		gbc_lblDireccin.gridy = 6;
		add(lblDireccin, gbc_lblDireccin);
		
		jdireccion = new JTextField();
		jdireccion.setColumns(10);
		GridBagConstraints gbc_jdireccion = new GridBagConstraints();
		gbc_jdireccion.insets = new Insets(0, 0, 5, 0);
		gbc_jdireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jdireccion.gridx = 1;
		gbc_jdireccion.gridy = 6;
		add(jdireccion, gbc_jdireccion);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		add(lblEmail, gbc_lblEmail);
		
		jemail = new JTextField();
		jemail.setColumns(10);
		GridBagConstraints gbc_jemail = new GridBagConstraints();
		gbc_jemail.insets = new Insets(0, 0, 5, 0);
		gbc_jemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jemail.gridx = 1;
		gbc_jemail.gridy = 7;
		add(jemail, gbc_jemail);
		
		lblTelfono = new JLabel("Teléfono");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTelfono = new GridBagConstraints();
		gbc_lblTelfono.anchor = GridBagConstraints.EAST;
		gbc_lblTelfono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfono.gridx = 0;
		gbc_lblTelfono.gridy = 8;
		add(lblTelfono, gbc_lblTelfono);
		
		jtelefono = new JTextField();
		jtelefono.setColumns(10);
		GridBagConstraints gbc_jtelefono = new GridBagConstraints();
		gbc_jtelefono.insets = new Insets(0, 0, 5, 0);
		gbc_jtelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtelefono.gridx = 1;
		gbc_jtelefono.gridy = 8;
		add(jtelefono, gbc_jtelefono);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
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
				jnombre.setText("");
				japellido1.setText("");
				japellido2.setText("");
				jdni.setText("");
				jdireccion.setText("");
				jemail.setText("");
				jtelefono.setText("");
				
				
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
	
	private void cargarPrimerRegistro() {
		
		Estudiante est = new ControllerEstudiante().cargarPrimerRegistro();
		
		if (est != null) {
		
			jtextid.setText(Integer.toString(est.getId()));
			jnombre.setText(est.getNombre());
			japellido1.setText(est.getApellido1());
			japellido2.setText(est.getApellido2());
			jdni.setText(est.getDni());
			jdireccion.setText(est.getDireccion());
			jemail.setText(est.getEmail());
			jtelefono.setText(est.getTelefono());
			
		}
	}
	
	
	/**
	 * 
	 */
	private void ultimoRegistro() {
		
		Estudiante est = new ControllerEstudiante().cargarUltimoRegistro();

		if (est != null) {

			jtextid.setText(Integer.toString(est.getId()));
			jnombre.setText(est.getNombre());
			japellido1.setText(est.getApellido1());
			japellido2.setText(est.getApellido2());
			jdni.setText(est.getDni());
			jdireccion.setText(est.getDireccion());
			jemail.setText(est.getEmail());
			jtelefono.setText(est.getTelefono());

		}
		
	}
	
	
	/**
	 * 
	 */
	private void siguienteRegistro() {
		
		Estudiante est = new Estudiante(Integer.parseInt(this.jtextid.getText()), 
				this.jnombre.getText(), this.japellido1.getText(),this.japellido2.getText(),
				this.jdni.getText(), this.jdireccion.getText(),this.jemail.getText(), 
				this.jtelefono.getText());

		Estudiante est2 = ControllerEstudiante.siguienteRegistro(est);

		if (est2 != null) {
			
			jtextid.setText(Integer.toString(est.getId()));
			jnombre.setText(est.getNombre());
			japellido1.setText(est.getApellido1());
			japellido2.setText(est.getApellido2());
			jdni.setText(est.getDni());
			jdireccion.setText(est.getDireccion());
			jemail.setText(est.getEmail());
			jtelefono.setText(est.getTelefono());
			
		}
		
	}
	
	/**
	 * 
	 */
	private void anteriorRegistro() {
		
		Estudiante est = new Estudiante(Integer.parseInt(this.jtextid.getText()), 
				this.jnombre.getText(), this.japellido1.getText(),this.japellido2.getText(),
				this.jdni.getText(), this.jdireccion.getText(),this.jemail.getText(), 
				this.jtelefono.getText());

		Estudiante est2 = ControllerEstudiante.anteriorRegistro(est);

		if (est2 != null) {
			
			jtextid.setText(Integer.toString(est.getId()));
			jnombre.setText(est.getNombre());
			japellido1.setText(est.getApellido1());
			japellido2.setText(est.getApellido2());
			jdni.setText(est.getDni());
			jdireccion.setText(est.getDireccion());
			jemail.setText(est.getEmail());
			jtelefono.setText(est.getTelefono());
			
		}
		
	}
	
	
	/**
	 * 
	 */
	private void guardarRegistro() {

		Estudiante est = new Estudiante(Integer.parseInt(this.jtextid.getText()), 
				this.jnombre.getText(), this.japellido1.getText(),this.japellido2.getText(),
				this.jdni.getText(), this.jdireccion.getText(),this.jemail.getText(), 
				this.jtelefono.getText());
		
		
		int affected = ControllerEstudiante.guardarRegistro(est);

		compruebaAffected(affected);
		cargarPrimerRegistro();
	}
	
	
	/**
	 * 
	 */
	private void eliminarRegistro() {
		
		
		if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar?") == JOptionPane.YES_OPTION) {
			
			Estudiante est = new Estudiante(Integer.parseInt(this.jtextid.getText()), 
					this.jnombre.getText(), this.japellido1.getText(),this.japellido2.getText(),
					this.jdni.getText(), this.jdireccion.getText(),this.jemail.getText(), 
					this.jtelefono.getText());
			
			
			int affected = ControllerEstudiante.eliminarRegistro(est);
			
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
