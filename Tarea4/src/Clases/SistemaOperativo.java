package Clases;

public class SistemaOperativo {
	private String nombreSO;
	private String version;
	private String anioLanzamiento;
	public SistemaOperativo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SistemaOperativo(String nombreSO, String version, String anioLanzamiento) {
		super();
		this.nombreSO = nombreSO;
		this.version = version;
		this.anioLanzamiento = anioLanzamiento;
	}
	public String getNombreSO() {
		return nombreSO;
	}
	public void setNombreSO(String nombreSO) {
		this.nombreSO = nombreSO;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAnioLanzamiento() {
		return anioLanzamiento;
	}
	public void setAnioLanzamiento(String anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}
	@Override
	public String toString() {
		return nombreSO ;
	}
	

}
