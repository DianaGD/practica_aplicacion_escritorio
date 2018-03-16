package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelRegistroCliente extends JPanel implements ActionListener {

	// definimos los campos de texto
	JTextField campoNombre = new JTextField(15);
	JTextField campoDomicilio = new JTextField(15);
	JTextField campoPoblacion = new JTextField(15);
	JTextField campoCodigoPostal = new JTextField(15);
	JTextField campoTelefono = new JTextField(15);

	public PanelRegistroCliente() {
		// this.add(new JLabel("soy el panel de registro de cliente")); //this
		// es opcional: hace referencia al objeto que se cree de esta clase

		// así asigno un gestor de diseño que me permite colocar las cosas
		// en forma de filas y celdas
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// primera fila
		gbc.gridy = 0; // primera fila
		gbc.gridx = 0; // primer elemento/columna
		gbc.gridwidth = 2; // este componente va a ocupar el espacio de dos
							// elementos
		this.add(new JLabel("INTRODUCE LOS DATOS DEL CLIENTE"), gbc);
		// vuelvo a decir que cada componente solo ocupe un elemento
		gbc.gridwidth = 1;
		// segunda fila
		gbc.gridy = 1; // segunda fila
		gbc.gridx = 0; // primer elemento
		this.add(new JLabel("nombre: "), gbc);

		gbc.gridy = 1; // segunda fila
		gbc.gridx = 1; // segundo elemento-columna
		this.add(campoNombre, gbc);
		// tercera fila
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("domicilio: "), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDomicilio, gbc);
		// cuarta fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("poblacion: "), gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoPoblacion, gbc);
		// quinta fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("codigo postal: "), gbc);

		gbc.gridx = 1;
		this.add(campoCodigoPostal, gbc);
		// sexta fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("telefono: "), gbc);

		gbc.gridx = 1;
		this.add(campoTelefono, gbc);
		// septima fila botón
		JButton botonRegistroCliente = new JButton("REGISTRAR");
		botonRegistroCliente.addActionListener(this);

		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroCliente, gbc);

	}// end PanelRegistroCliente()-constructor
		// metodo que se ejecuta cuando se hace click en el elemento que le pasemos

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed del PanelRegistroCliente");
		String nombre = campoNombre.getText();
		String domicilio = campoDomicilio.getText();
		String poblacion = campoPoblacion.getText();
		String codigoPostal = campoCodigoPostal.getText();
		String telefono = campoTelefono.getText();

		// ahora habría que validar estos datos pero no lo vamos a hacer ahora
		// ...TODO (que queda por hacer, que queda pendiente)

		// una vez validados todos los datos registramos en base de datos:
		Cliente clienteARegistrar = new Cliente(nombre, domicilio, poblacion,
				codigoPostal, telefono);
		System.out.println("voy a registrar: " + clienteARegistrar.toString());
		//invoco a lo necesario de la capa de datos para registrar el cliente en base de datos
		ClientesDAOImpl clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(clienteARegistrar);
		
	}// end actionPerformed

}// end class
