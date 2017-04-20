package Clases;

public class Marca {
	private String codigoMarca;
	private String nombre;
	@Override
	public String toString() {
		return nombre ;
	}
	public String getCodigoMarca() {
		return codigoMarca;
	}
	public void setCodigoMarca(String codigoMarca) {
		this.codigoMarca = codigoMarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Marca(String codigoMarca, String nombre) {
		super();
		this.codigoMarca = codigoMarca;
		this.nombre = nombre;
	}
	public Marca() {
		super();
		// TODO Auto-generated constructor stub
	}

}
