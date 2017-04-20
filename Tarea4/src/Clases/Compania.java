package Clases;

public class Compania {
	private String nombreCompania;
	private String codigoCompania;
	private String direccion;
	private String telefono;
	public Compania() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compania(String nombreCompania, String codigoCompania, String direccion, String telefono) {
		super();
		this.nombreCompania = nombreCompania;
		this.codigoCompania = codigoCompania;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Compania [nombreCompania=" + nombreCompania + ", codigoCompania=" + codigoCompania + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}
	
}
