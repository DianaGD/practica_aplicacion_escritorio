package modelo;

public class Juguete {
	private String marca;
	private String nombre;
	private String descripcion;
	private String precio;
	private String categoria;
	private String edad;
	private String contenido;
	private int id;
	
	
	
	public Juguete() {		
	}//end Juguete()

	public Juguete(String marca, String nombre, String descripcion,
			String precio, String categoria, String edad, String contenido) {
		super();
		this.marca = marca;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.edad = edad;
		this.contenido = contenido;
	}//end Juguete(campos)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Juguete [marca=" + marca + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", precio=" + precio
				+ ", categoria=" + categoria + ", edad=" + edad
				+ ", contenido=" + contenido + "]";
	}

}//end class
