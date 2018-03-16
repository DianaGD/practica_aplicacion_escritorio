package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Cliente;
import modelo.Juguete;
import daos.ClientesDAOImpl;
import daos.JuguetesDAOImpl;

public class PanelRegistroJuguete extends JPanel implements ActionListener {

	// defino los campos de texto
	JTextField campoMarca = new JTextField(15);
	JTextField campoNombre = new JTextField(15);
	JTextField campoDescripcion = new JTextField(15);
	JTextField campoPrecio = new JTextField(15);
//	JTextField campoCategoria = new JTextField(15);
	JTextField campoEdad = new JTextField(15);
	JTextField campoContenido = new JTextField(15);
	
	String[] categoriaStrings = { "Educativo", "Peques", "Adultos", "Estrategia", "Electronico" };
	JComboBox campoCategoria = new JComboBox(categoriaStrings);

	public PanelRegistroJuguete() {
		// this.add(new JLabel("soy el panel de registro de juguetes"));

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// primera fila
		gbc.gridy = 0; // primera fila
		gbc.gridx = 0; // primer elemento/columna
		gbc.gridwidth = 2; // este componente va a ocupar el espacio de dos
							// elementos
		this.add(new JLabel("INTRODUCE LOS DATOS DEL JUGUETE"), gbc);

		gbc.gridwidth = 1;
		// segunda fila - marca del juguete
		gbc.gridy = 1; // segunda fila
		gbc.gridx = 0; // primer elemento
		this.add(new JLabel("marca: "), gbc);

		gbc.gridy = 1; // segunda fila
		gbc.gridx = 1; // segundo elemento-columna
		this.add(campoMarca, gbc);

		// tercera fila - nombre del juguete
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("nombre: "), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoNombre, gbc);

		// cuarta fila - descripcion del juguete
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("descripcion: "), gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoDescripcion, gbc);

		// quinta fila - precio
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("precio: "), gbc);

		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoPrecio, gbc);

		// sexta fila - categoria
//	    
	    //campoCategoria.setSelectedIndex(4);
	    //categoriaList.addActionListener(this);

		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("categoria: "), gbc);
		//this.add(new JComboBox<String>(),gbc);

		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoCategoria, gbc);

		// septima fila - edad
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("edad: "), gbc);

		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoEdad, gbc);

		// octava fila - contenido
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("contenido: "), gbc);

		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoContenido, gbc);

		// novena fila botón
		JButton botonRegistroJuguete = new JButton("REGISTRAR JUGUETE");
		botonRegistroJuguete.addActionListener(this);

		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroJuguete, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BOTON REGISTRAR JUGUETE PULSADO");
		String marca = campoMarca.getText();
		String nombre = campoNombre.getText();
		String descripcion = campoDescripcion.getText();
		String precio = campoPrecio.getText();
		//String categoria = campoCategoria.getText();
		JComboBox cb = (JComboBox)e.getSource();
        String categoria = (String)cb.getSelectedItem();
		
		String edad = campoEdad.getText();
		String contenido = campoContenido.getText();

		Juguete jugueteAregistrar = new Juguete(marca, nombre, descripcion, precio, categoria, edad, contenido);
		System.out.println("voy a registrar: " + jugueteAregistrar.toString());
		//invoco a lo necesario de la capa de datos para registrar el cliente en base de datos
		JuguetesDAOImpl juguetesDAO = new JuguetesDAOImpl();
		juguetesDAO.registrarJuguete(jugueteAregistrar);
		
	}
}
