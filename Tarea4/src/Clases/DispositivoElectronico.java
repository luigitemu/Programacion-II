package Clases;

public class DispositivoElectronico {
	protected String resolucion;
	protected String tamanioPantalla;
	protected SistemaOperativo sistema;
	protected double memoria;
	protected double capacidadMemoria;
	protected Marca marca;
	protected String modelo;
	public DispositivoElectronico() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DispositivoElectronico(String resolucion, String tamanioPantalla, SistemaOperativo sistema, double memoria,
			double capacidadMemoria, Marca marca, String modelo) {
		super();
		this.resolucion = resolucion;
		this.tamanioPantalla = tamanioPantalla;
		this.sistema = sistema;
		this.memoria = memoria;
		this.capacidadMemoria = capacidadMemoria;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public String getTamanioPantalla() {
		return tamanioPantalla;
	}
	public void setTamanioPantalla(String tamanioPantalla) {
		this.tamanioPantalla = tamanioPantalla;
	}
	public SistemaOperativo getSistema() {
		return sistema;
	}
	public void setSistema(SistemaOperativo sistema) {
		this.sistema = sistema;
	}
	public double getMemoria() {
		return memoria;
	}
	public void setMemoria(double memoria) {
		this.memoria = memoria;
	}
	public double getCapacidadMemoria() {
		return capacidadMemoria;
	}
	public void setCapacidadMemoria(double capacidadMemoria) {
		this.capacidadMemoria = capacidadMemoria;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "DispositivoElectronico [resolucion=" + resolucion + ", tamanioPantalla=" + tamanioPantalla
				+ ", sistema=" + sistema + ", memoria=" + memoria + ", capacidadMemoria=" + capacidadMemoria
				+ ", marca=" + marca + ", modelo=" + modelo + "]";
	} 
	
	
}
