package daos;

public class ConstantesSQL {

	final static String sqlInsercionCliente = "INSERT INTO tabla_clientes (nombre, domicilio, poblacion, codigo_postal, telefono) VALUES"
			+ "(?,?,?,?,?)";
	final static String sqlSeleccionClientes = "select * from tabla_clientes";
	
	final static String sqlInsercionJuguete = "INSERT INTO tabla_juguetes (marca, nombre, descripcion, precio, categoria, edad, contenido) VALUES"
				+ "(?,?,?,?,?,?,?)";
	final static String sqlSeleccionJuguetes = "select * from tabla_juguetes";
	public static String sqlBorradoCliente = "delete from tabla_clientes where id=? ";
}
