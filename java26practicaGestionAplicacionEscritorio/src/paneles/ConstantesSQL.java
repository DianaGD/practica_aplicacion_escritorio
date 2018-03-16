package paneles;

public class ConstantesSQL {

	final static String sqlInsercionCliente = "INSERT INTO tabla_clientes (nombre, domicilio, poblacion, codigo_postal, telefono) VALUES"
			+ "(?,?,?,?,?)";
	final static String sqlSeleccionClientes = "select * from tabla_clientes";
	public static String sqlBorradoCliente = "delete from tabla_clientes where id=? ";
}
