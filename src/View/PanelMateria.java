package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.ControllerCurso;
import Controllers.ControllerMateria;
import Model.Curso;
import Model.Materia;
import javax.swing.JComboBox;

public class PanelMateria extends JPanel {
	
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
	private JButton btnInsertar;
	private JLabel lblAcrnimo;
	private JTextField jacronimo;
	private JLabel lblIdcurso;
	private JComboBox comboCurso;
	
	public PanelMateria() {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);
		
		lblNewLabel_1 = new JLabel(" Gestión de Materias");
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
		
		lblAcrnimo = new JLabel("Acrónimo");
		lblAcrnimo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblAcrnimo = new GridBagConstraints();
		gbc_lblAcrnimo.anchor = GridBagConstraints.EAST;
		gbc_lblAcrnimo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcrnimo.gridx = 0;
		gbc_lblAcrnimo.gridy = 3;
		add(lblAcrnimo, gbc_lblAcrnimo);
		
		jacronimo = new JTextField();
		jacronimo.setColumns(10);
		GridBagConstraints gbc_jacronimo = new GridBagConstraints();
		gbc_jacronimo.insets = new Insets(0, 0, 5, 0);
		gbc_jacronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jacronimo.gridx = 1;
		gbc_jacronimo.gridy = 3;
		add(jacronimo, gbc_jacronimo);
		
		lblIdcurso = new JLabel("Id_Curso");
		lblIdcurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblIdcurso = new GridBagConstraints();
		gbc_lblIdcurso.anchor = GridBagConstraints.EAST;
		gbc_lblIdcurso.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdcurso.gridx = 0;
		gbc_lblIdcurso.gridy = 4;
		add(lblIdcurso, gbc_lblIdcurso);
		
		comboCurso = new JComboBox();
		GridBagConstraints gbc_comboCurso = new GridBagConstraints();
		gbc_comboCurso.insets = new Insets(0, 0, 5, 0);
		gbc_comboCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCurso.gridx = 1;
		gbc_comboCurso.gridy = 4;
		add(comboCurso, gbc_comboCurso);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
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
				//anteriorRegistro();
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Boton Siguiente
				//siguienteRegistro();
				
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Boton Ultimo Registro
				//ultimoRegistro();
				
			}
		});
		panel.add(btnUltimo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//guardarRegistro();
				
			}
		});
		
		btnModificar = new JButton("Nuevo");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtextid.setText("0");
				jnombre.setText("");
				
			}
		});
		panel.add(btnModificar);
		panel.add(btnGuardar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//insertarRegistro();
				
			}
		});
		panel.add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//eliminarRegistro();
				
			}
		});
		panel.add(btnEliminar);
		cargarPrimerRegistro();
	

	}
	
	
	private void cargarPrimerRegistro() {
		
		Materia mat = new ControllerMateria().cargarPrimerRegistro();
		
		if (mat != null) {
		
			jtextid.setText(Integer.toString(mat.getId()));
			jnombre.setText(mat.getNombre());
			jacronimo.setText(mat.getAcronimo());
			//Jcombo
			
		}
	}

}
