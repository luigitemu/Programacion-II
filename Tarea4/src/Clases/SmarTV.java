package Clases;

public class SmarTV extends DispositivoElectronico  {
	private String peso;

	public SmarTV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmarTV(String resolucion, String tamanioPantalla, SistemaOperativo sistema, double memoria,
			double capacidadMemoria, Marca marca, String modelo) {
		super(resolucion, tamanioPantalla, sistema, memoria, capacidadMemoria, marca, modelo);
		// TODO Auto-generated constructor stub
	}

	public SmarTV(String peso) {
		super();
		this.peso = peso;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "SmarTV [peso=" + peso + ", resolucion=" + resolucion + ", tamanioPantalla=" + tamanioPantalla
				+ ", sistema=" + sistema + ", memoria=" + memoria + ", capacidadMemoria=" + capacidadMemoria
				+ ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}
