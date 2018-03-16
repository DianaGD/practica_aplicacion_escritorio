package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClientesDAOImpl implements ClientesDAO {
	// primero hay que hacer la conexion
	private Connection miConexion = null;

	public ClientesDAOImpl() {
		// preparo driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/practica_escritorio", "root",
					"jeveris");

		} catch (ClassNotFoundException e) {
			System.out.println("no encuentro el driver-libreria de mysql");
		} catch (SQLException e) {
			System.out.println("error de conexion o la sql esta mal");
		}
	}// end ClientesDAOImpl

	@Override
	public void registrarCliente(Cliente c) {
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionCliente);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPoblacion());
			ps.setString(4, c.getCodigoPostal());
			ps.setString(5, c.getTelefono());

			ps.execute();
			ps.close();
			System.out.println("cliente insertado correctamente");
		} catch (SQLException e) {
			System.out.println("fallo en la sql");
		}
	}

	@Override
	public void borrarCliente(int id) {
		try {
			//System.out.println("en try borrarCliente() ClientesDAOImpl");
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoCliente);
			ps.setInt(1, id);
			ps.execute();
			System.out.println("en try borrarCliente() ClientesDAOImpl despues de execute()");
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de borrado esta mal");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Cliente[] obtenerClientes() {
		Cliente[] clientes = null;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlSeleccionClientes);
			// para sql tipo select debo usar el metodo executeQuery
			ResultSet resultado = ps.executeQuery();
			List<Cliente> listClientes = new ArrayList<Cliente>();
			//next() pasa al siguiente resultado de la base de datos que aun no hemos procesado
			//si no hay ningun resultado mas devuelve false
			while(resultado.next()){
				Cliente c = new Cliente();
				c.setNombre(resultado.getString("nombre"));
				c.setDomicilio(resultado.getString("domicilio"));
				c.setCodigoPostal(resultado.getString("codigo_postal"));
				c.setPoblacion(resultado.getString("poblacion"));
				c.setTelefono(resultado.getString("telefono"));
				c.setId(resultado.getInt("id"));
				listClientes.add(c);				
			}//end while
			//transformar de list a array - metodo toArray q hay que pasarle el tamaño del array
			clientes = listClientes.toArray(new Cliente[listClientes.size()]);
			
		} catch (SQLException e) {
			System.out.println("fallo en la sql de seleccion clientes");
		}
		return clientes;
	}// end obtenerClientes
	
}// end class
