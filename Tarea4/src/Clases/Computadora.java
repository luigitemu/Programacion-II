package Clases;

public class Computadora extends DispositivoElectronico {
	private String tipoComputadora;

	

	public Computadora() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Computadora(String resolucion, String tamanioPantalla, SistemaOperativo sistema, double memoria,
			double capacidadMemoria, Marca marca, String modelo) {
		super(resolucion, tamanioPantalla, sistema, memoria, capacidadMemoria, marca, modelo);
		// TODO Auto-generated constructor stub
	}

	public Computadora(String tipoComputadora) {
		super();
		this.tipoComputadora = tipoComputadora;
	}

	public String getTipoComputadora() {
		return tipoComputadora;
	}

	public void setTipoComputadora(String tipoComputadora) {
		this.tipoComputadora = tipoComputadora;
	}

	@Override
	public String toString() {
		return "Computadora [tipoComputadora=" + tipoComputadora + ", resolucion=" + resolucion + ", tamanioPantalla="
				+ tamanioPantalla + ", sistema=" + sistema + ", memoria=" + memoria + ", capacidadMemoria="
				+ capacidadMemoria + ", marca=" + marca + ", modelo=" + modelo + "]";
	}


	

}
