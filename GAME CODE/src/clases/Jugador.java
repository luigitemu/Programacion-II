package clases;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import juego.Juego;

public class Jugador {
	private int x;
	private int y;
	private int anchoImagen;
	private int altoImagen;
	private String llaveImagen;
	private int velocidad=2;
	//private String llaveImagen2;

	private int contadorIteraciones;
	private boolean saltar;
	private boolean bajar;
	
	private boolean agachar;
	private boolean parar;
    private int puntuacion=0;
    
    
	public Jugador(int x, int y, int anchoImagen, int altoImagen, String llaveImagen) {
		super();
		this.x = x;
		this.y = y;
		this.anchoImagen = anchoImagen;
		this.altoImagen = altoImagen;
		this.llaveImagen = llaveImagen;
	}

	public Jugador(int x, int y, String llaveImagen) {
		this.x = x;
		this.y = y;
		//this.anchoImagen= Juego.imagenes.get("running").getWidth();
		//this.altoImagen= Juego.imagenes.get("running").getHeight();
		this.llaveImagen = llaveImagen;
		//this.llaveImagen = llaveImagen2;
	}

	public Jugador(){}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAnchoImagen() {
		return anchoImagen;
	}

	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}

	public int getAltoImagen() {
		return altoImagen;
	}

	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}

	public String getLlaveImagen() {
		return llaveImagen;
	}

	public void setLlaveImagen(String llaveImagen) {
		this.llaveImagen = llaveImagen;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getContadorIteraciones() {
		return contadorIteraciones;
	}

	public void setContadorIteraciones(int contadorIteraciones) {
		this.contadorIteraciones = contadorIteraciones;
	}
	
	

	public boolean isSaltar() {
		return saltar;
	}

	public void setSaltar(boolean saltar) {
		this.saltar = saltar;
	}

	public boolean isBajar() {
		return bajar;
	}

	public void setBajar(boolean bajar) {
		this.bajar = bajar;
	}
	
	public boolean isAgachar() {
		return agachar;
	}

	public void setAgachar(boolean agachar) {
		this.agachar = agachar;
	}

	
	public boolean isParar() {
		return parar;
	}

	public void setParar(boolean parar) {
		this.parar = parar;
	}


	@Override
	public String toString() {
		return "Jugador [x=" + x + ", y=" + y + ", anchoImagen=" + anchoImagen + ", altoImagen=" + altoImagen
				+ ", llaveImagen=" + llaveImagen + "]";
	}

	public void dibujar(Graphics2D g2D, ImageObserver imgObs){
		g2D.drawImage(Juego.imagenes.get(llaveImagen),x,y,imgObs);
	}
	
		public void mover(){
				contadorIteraciones++;
		if(contadorIteraciones<=3  ){
			llaveImagen = "running";
		}else if (contadorIteraciones<=6){
			llaveImagen = "running2";
		}else if(contadorIteraciones<=9){
			llaveImagen = "running3";
		}else if (contadorIteraciones<=12 ){
			llaveImagen = "running4";		
		}else if (contadorIteraciones<=15){
			llaveImagen = "running5";
		}else if(contadorIteraciones<=18  ){
			llaveImagen = "running6";
		}else if (contadorIteraciones<=21){
			llaveImagen = "running7";
		}else if (contadorIteraciones<=24 ){
			llaveImagen = "running8";
			contadorIteraciones=0;
		}
	}
		
		
	public void saltar(){
		llaveImagen = "salto1";
			
/*		contadorIteraciones ++;
		if (contadorIteraciones<=10){// <-- Para que es esto
			llaveImagen= "salto";
			this.y=200; 
		}
		
	else if(contadorIteraciones<=14){
			llaveImagen="salto1";
			this.y-=20;
		}
		
		else if(contadorIteraciones<=15){
			llaveImagen = "salto2";
			this.y-=20;
			
		}else if(contadorIteraciones<=19){
			llaveImagen = "salto3";
			this.y=280;
			
		}
		else if(contadorIteraciones<=20){
			llaveImagen = "salto4";
			this.y=200;	
		contadorIteraciones =0;
			
		}

		*/
	}
	public void  agacharse(){
		this.anchoImagen=Juego.imagenes.get("agacharse").getWidth();
		this.altoImagen= Juego.imagenes.get("agacharse").getHeight();
		this.y=460;
		llaveImagen= "agacharse";
		
		
	}

}