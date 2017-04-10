package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Puntuacion {
	private int puntuacion=0;

	public Puntuacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Puntuacion(int puntuacion) {
		super();
		this.puntuacion = puntuacion;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Puntuacion [puntuacion=" + puntuacion + "]";
	}
	public void dibujar (Graphics g2d, ImageObserver imgobs){
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(puntuacion), 910, 40);
	}
	public void mover(){
		puntuacion++;
	}

}
