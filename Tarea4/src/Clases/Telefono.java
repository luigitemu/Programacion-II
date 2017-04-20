package Clases;

import java.util.ArrayList;
import java.util.Arrays;

public class Telefono extends DispositivoElectronico {
	private String numeroTelefono;
	private double megapixeles;
	private String marcaProcesador;
	private Compania compania;
	private ArrayList<String> otrosComponentes;
	public Telefono() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Telefono(String resolucion, String tamanioPantalla, SistemaOperativo sistema, double memoria,
			double capacidadMemoria, Marca marca, String modelo, String numeroTelefono, double megapixeles,  Compania compania,
			ArrayList<String> otrosComponentes) {
		super(resolucion, tamanioPantalla, sistema, memoria, capacidadMemoria, marca, modelo);
		// TODO Auto-generated constructor stub
		this.numeroTelefono = numeroTelefono;
		this.megapixeles = megapixeles;
		this.marcaProcesador = marcaProcesador;
		this.compania = compania;
		this.otrosComponentes = otrosComponentes;
	}
	public Telefono(String numeroTelefono, double megapixeles, String marcaProcesador, Compania compania,
			ArrayList<String> otrosComponentes) {
		super();
		this.numeroTelefono = numeroTelefono;
		this.megapixeles = megapixeles;
		this.marcaProcesador = marcaProcesador;
		this.compania = compania;
		this.otrosComponentes = otrosComponentes;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public double getMegapixeles() {
		return megapixeles;
	}
	public void setMegapixeles(double megapixeles) {
		this.megapixeles = megapixeles;
	}
	public String getMarcaProcesador() {
		return marcaProcesador;
	}
	public void setMarcaProcesador(String marcaProcesador) {
		this.marcaProcesador = marcaProcesador;
	}
	public Compania getCompania() {
		return compania;
	}
	public void setCompania(Compania compania) {
		this.compania = compania;
	}
	public ArrayList<String> getOtrosComponentes() {
		return otrosComponentes;
	}
	public void setOtrosComponentes(ArrayList<String> otrosComponentes) {
		this.otrosComponentes = otrosComponentes;
	}
	@Override
	public String toString() {
		return "Telefono [numeroTelefono=" + numeroTelefono + ", megapixeles=" + megapixeles + ", marcaProcesador="
				+ marcaProcesador + ", compania=" + compania + ", otrosComponentes=" + otrosComponentes + "]";
	}
	
}