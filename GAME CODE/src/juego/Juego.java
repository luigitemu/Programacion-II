package juego;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import clases.Fondo;
import clases.Item;
import clases.Jugador;
import clases.Puntuacion;
import clases.Tiles;
//import java.lang.NullPointerException;

public class Juego extends Canvas implements KeyListener{
	private JFrame ventana;
	private BufferStrategy dobleBuffer;
	private Graphics2D g2D;

	private boolean jugando  = false;

	public static final int ANCHO_VENTANA = 1000/*DEFINA SUS PROPIAS DIMENSIONES*/;
	public static final int ALTO_VENTANA = 750/*DEFINA SUS PROPIAS DIMENSIONES*/;

	int lastFpsTime; //Variable auxiliar para calculo de la pausa del ciclo principal
	int fps; //Fotogramas por segundo
	
	//TILE MAP ARREGLO--------------------------------------------------------------------------------------------------------------
	private int[][] tileMap={
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0, 5 ,0, 2, 9},
			{0 , 0 , 0 ,13 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 7 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 13 ,13, 8, 9},
			{0 , 0 , 0 ,13, 0,0, 0, 0},
			{0 , 0 , 0 ,13, 0, 0, 0, 0},
			{0 , 0 , 0 ,0 ,13 ,13, 11, 9},
			{0 , 0 , 0 ,0 , 0 , 0, 2, 9},
			{0 , 0 , 0 ,0 , 0,14, 2, 9},
			{0 , 0 , 0 ,0 , 5,14, 2, 9},
			{0 , 0 , 0 ,0, 7,14, 2, 9},
			{0 , 0 , 0 ,0 , 0,14, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 13 ,0, 2, 9},
			{0 , 0 , 0 ,13, 0 ,0, 2, 9},
			{0 , 0 , 0 ,13, 5 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,10, 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 7 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 14},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 14},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9},
			
			{0,  0 , 0 ,0 , 0 ,0, 0, 0},
			{0,  0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0, 5 ,0, 2, 9},
			{0 , 0 , 0 ,13 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 7 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 13,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0,14, 2, 9},
			{0 , 0 , 0 ,0 , 5,14, 2, 9},
			{0 , 0 , 0 ,0 , 7,14, 2, 9},
			{0 , 0 , 0 ,0 , 0,14, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 5 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,10, 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 7 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,13, 0,0, 8, 9},
			{0 , 0 , 0 ,0 , 13,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,13, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0, 5 ,0, 2, 9},
			{0 , 0 , 0 ,13 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 7 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0,14, 2, 9},
			{0 , 0 , 0 ,0 , 5,14, 2, 9},
			{0 , 0 , 0 ,0 , 7,14, 2, 9},
			{0 , 0 , 0 ,0 , 0,14, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 5 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,10, 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 7 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9},
			
			{0,  0 , 0 ,0 , 0 ,0, 0, 0},
			{0,  0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0, 5 ,0, 2, 9},
			{0 , 0 , 0 ,13 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,13, 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 7 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 13, 0, 2, 9},
			{0 , 0 , 0 , 13, 0 ,14, 2, 9},
			{0 , 0 , 0 , 13, 5 ,14, 2, 9},
			{0 , 0 , 0 , 13, 7 ,14, 2, 9},
			{0 , 0 , 0 , 13, 0,14, 2, 9},
			{0 , 0 , 0 ,0 , 13,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 5 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,10, 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 6 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 7 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 0, 0},
			{0 , 0 , 0 ,0 , 0 ,0, 11, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,13, 2, 9},
			{0 , 0 , 0 ,0 , 0 ,0, 8, 9}

	};
	
	//TILES ARRAYLIST---------------------------------------------------------------------------------------------------------------
	private ArrayList<Tiles> tiles;

	
	
	public static HashMap<String,BufferedImage> imagenes = new HashMap<String,BufferedImage>();
	private Jugador jugador;
	private Fondo fondo;
	private Item item;
	private Puntuacion puntuacion;
	//private Tiles tile;
	
	
	public Juego(){
		cargarImagenes();
		inicializarObjetosJuego();
		incializarVentana();
		
		cargarTiles(); //cargar TILES----------------------------------------------------------------------------------------------
		
		createBufferStrategy(2); //Crear una estrategia de doble buffer (metodo optimo para videojuegos)
		dobleBuffer = getBufferStrategy(); //Obtener una instancia de BufferStrategy (para luego dibujar los componentes)

		jugando = true; //Definir la variable logica de juego en true

		this.requestFocus(); //Solicitar el foco para que los eventos del teclado puedan ser capturados por el Canvas.
		this.addKeyListener(this); //Agregar interfaz de escucha para poder interceptar las teclas pulsadas por el usuario.

		cicloPrincipal(); //Ejecutar el ciclo principal del juego (Este no necesariamente debe llamarse desde aqui)
		//if(jugando == true)
		//cargarTiles();
	}

	public void incializarVentana(){
		//Crear la ventana y establecer sus propiedades
		ventana = new JFrame(); //Crear instancia de la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminar aplicacion cuando se de click en la X
		ventana.setSize(ANCHO_VENTANA, ALTO_VENTANA); //Establecer las dimensiones de la ventana
		ventana.setLocationRelativeTo(null); //Centrar ventana en el escritorio
		//ventana.setResizable(false);
		//Ventana en fullscreen
		//ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//ventana.setUndecorated(true);
		ventana.setTitle("WOLFTOWN"); //Definir el titulo de la ventana
		ventana.getContentPane().add(this); //Agregar el Canvas (lienzo) a la ventana
		ventana.setVisible(true); //Mostrar ventana
	}
	
	
	
	
/*	public void repetirTiles(){
		while(tileMap[0][7]!=0){
			
		}
	}
	*/
	

	public void inicializarObjetosJuego(){
		jugador =new Jugador(100,430, "running");
		fondo = new Fondo(0,0,"fondo");
		item = new Item(300,390,"heart");
		puntuacion = new Puntuacion();	
		tiles = new ArrayList<Tiles>(); //TILE HERE---------------------------------------------------------------------------
		
	}

	public void verificarColisiones(){
		//System.out.println("Verificando colisiones");
	}

	public void limpiarMemoria(){
		//System.out.println("Limpiando memoria");
	}

	//Cargar Imagenes
	public void cargarImagenes(){
		try {
			imagenes.put("running", ImageIO.read(getClass().getResource("/recursos/running transparent 1.png")));
			imagenes.put("running2", ImageIO.read(getClass().getResource("/recursos/running transparent 2.png")));
			imagenes.put("running3", ImageIO.read(getClass().getResource("/recursos/running transparent 3.png")));
			imagenes.put("running4", ImageIO.read(getClass().getResource("/recursos/running transparent 4.png")));
			imagenes.put("running5", ImageIO.read(getClass().getResource("/recursos/running transparent 5.png")));
			imagenes.put("running6", ImageIO.read(getClass().getResource("/recursos/running transparent 6.png")));
			imagenes.put("running7", ImageIO.read(getClass().getResource("/recursos/running transparent 7.png")));
			imagenes.put("running8", ImageIO.read(getClass().getResource("/recursos/running transparent.png")));
			imagenes.put("salto", ImageIO.read(getClass().getResource("/recursos/salto 0.png")));
			imagenes.put("salto1", ImageIO.read(getClass().getResource("/recursos/salto 1.png")));
			imagenes.put("salto2", ImageIO.read(getClass().getResource("/recursos/salto 2.png")));
			imagenes.put("salto3", ImageIO.read(getClass().getResource("/recursos/salto 3.png")));
			imagenes.put("salto4", ImageIO.read(getClass().getResource("/recursos/salto 4.png")));
			imagenes.put("salto5", ImageIO.read(getClass().getResource("/recursos/salto 5.png")));
			
			imagenes.put("fondo", ImageIO.read(getClass().getResource("/recursos/fondo.png")));
			imagenes.put("fondo2", ImageIO.read(getClass().getResource("/recursos/fondo2.png")));
			imagenes.put("agacharse", ImageIO.read(getClass().getResource("/recursos/agacharse.png")));
			//imagenes.put("fondo2", ImageIO.read(getClass().getResource("/recursos/background2.png")));
			//imagenes.put("heart", ImageIO.read(getClass().getResource("/recursos/heart.png")));
			
			imagenes.put("tile1", ImageIO.read(getClass().getResource("/recursos/tile1.png")));
			imagenes.put("tile2", ImageIO.read(getClass().getResource("/recursos/tile2.png")));
			imagenes.put("tile3", ImageIO.read(getClass().getResource("/recursos/tile3.png")));
			imagenes.put("tile4", ImageIO.read(getClass().getResource("/recursos/tile4.png")));
			imagenes.put("tile5", ImageIO.read(getClass().getResource("/recursos/tile5.png")));
			imagenes.put("tile6", ImageIO.read(getClass().getResource("/recursos/tile6.png")));
			imagenes.put("tile7", ImageIO.read(getClass().getResource("/recursos/tile7.png")));
			imagenes.put("tile8", ImageIO.read(getClass().getResource("/recursos/tile8.png")));
			imagenes.put("tile9", ImageIO.read(getClass().getResource("/recursos/tile9.png")));
			imagenes.put("tile10", ImageIO.read(getClass().getResource("/recursos/tile10.png")));
			imagenes.put("tile11", ImageIO.read(getClass().getResource("/recursos/tile11.png")));
			imagenes.put("tile12", ImageIO.read(getClass().getResource("/recursos/tile12.png")));
			imagenes.put("tile13", ImageIO.read(getClass().getResource("/recursos/tile13.png")));
			imagenes.put("tile14", ImageIO.read(getClass().getResource("/recursos/tile14.png")));
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//MOVER TILES----------------------------------------------------------------------------------------------------------------------
	public void cargarTiles(){
	//for(int prb=0; prb<tileMap.length;prb++){	
		for(int i=0;i<tileMap.length;i++)
        	for(int j=0;j<tileMap[0].length;j++)
        		if (tileMap[i][j]!=0)
        			tiles.add(new Tiles(i*89,j*88, 4, "tile"+tileMap[i][j]));
		//}
	}
	


	//Metodo para pintar los componentes del juego
	private void pintar(){
        //System.out.println("Pintando");
        g2D = (Graphics2D)dobleBuffer.getDrawGraphics(); //Obtener la instancia de Graphics para pintar los elementos

        //Puede borrar las siguientes 4 lineas
        g2D.setColor(new Color(10,0,0)); //Definir el color negro en el contexto
        g2D.fillRect(0, 0, ANCHO_VENTANA, ALTO_VENTANA); //Dibujar un rectangulo
        g2D.setColor(Color.WHITE); //Definir el color blanco en el contexto

        //g2D.drawImage(imagenes.get("fondo"),0,0,this);
        fondo.dibujar(g2D, this);
        jugador.dibujar(g2D, this);
        puntuacion.dibujar(g2D, this);
        //draw TILES-----------------------------------------------------------------------------------------------------------------
        for(int i=0;i<tiles.size();i++)
        	tiles.get(i).pintar(g2D, this);

        
        //item.dibujar(g2D, this);
        dobleBuffer.show(); //Mostrar lo que se ha dibujado
	}

	public void actualizar(){
		//System.out.println("Actualizando");
		puntuacion.mover();
		if((jugador.isSaltar()==false||jugador.isBajar())==false||jugador.isAgachar()==false){
			jugador.mover();
			}
			if(jugador.isSaltar()==true){
				jugador.setY(jugador.getY()-16);
				jugador.saltar();
				
				if(jugador.getY()<120){
					jugador.setSaltar(false);
					jugador.setBajar(true);
				}
			}
			if(jugador.isBajar()==true){
				jugador.setY(jugador.getY()+16 ); //+15
				
				if(jugador.getY()>422)//<--------------------------se modifico
					jugador.setBajar(false);
				
			}
			if(jugador.isAgachar()==true){
				jugador.agacharse();
				
			} 
			//if(jugador.isParar()==true)
				//jugador.setAgachar(false);
				//jugador.mover();
			fondo.mover();
			item.mover();

		//TILES-----------------------------------------------------------------------------------------------------------------------
		//for(int i=0;i<tiles.size();i++)
        	//tiles.get(i).pintar(g2D, this);
		for(int i=0;i<tiles.size();i++)
        	tiles.get(i).mover();

	}

	public void cicloPrincipal(){
       //variables para el calculo del tiempo para la pausa, este codigo es opcional, si lo desea puede definir un valor para la pausa en duro.
	   long lastLoopTime = System.nanoTime();
       final int TARGET_FPS = 60;
       final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

       while (jugando){
    	   //Calculo del tiempo optimo y uniforme para la pausa.
    	   long now = System.nanoTime();
    	   long updateLength = now - lastLoopTime;
    	   lastLoopTime = now;
    	   double delta = updateLength / ((double)OPTIMAL_TIME);
    	   lastFpsTime += updateLength;
    	   fps++;
    	   if (lastFpsTime >= 1000000000){
    		   System.out.println("(FPS: "+fps+")");
    		   lastFpsTime = 0;
    		   fps = 0;
    	   }
    	   //Fin del calculo del tiempo optimo y uniforme para la pausa.

    	   //Metodos para pintar el lienzo y actualizar los componentes de juego
    	   pintar();
    	   actualizar();
    	   verificarColisiones();
    	   limpiarMemoria();
    	   //Aplicar la pausa.
    	   try{Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );} //Puede sustituir el valor de la pausa por un valor fijo
    	   catch(Exception e){};
       }
    }

	//Metodo que se ejecuta cuando el usuario presiona una tecla
	public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
        	case KeyEvent.VK_SPACE:
        		System.out.println("Presiono espacio");
        		jugador.saltar();

	        	jugador.setSaltar(true);
	        	jugador.setBajar(false);
        		break;
        	case KeyEvent.VK_DOWN:
        		jugador.setAgachar(true);
        		System.out.println("preciono flecha abajo");
        		jugador.agacharse();
             
        	break;
             
        }
    }

	//Metodo que se ejecuta cuando el usuario suelta una tecla
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
	        case KeyEvent.VK_SPACE:
	        	System.out.println("Solto espacio");
	        	
	        	//jugador.setY(370);
	        	
	    		break;
	        case KeyEvent.VK_DOWN:
	        	jugador.setAgachar(false);
	        	jugador.setY(430);//-----------------------------------------------------------------------------------------------------
	        	
        }
    }
    //Sin uso, pero a fuerzas se debe redefinir
  	public void keyTyped(KeyEvent e) {}

  	
    public static void main(String[] args){
		new Juego(); //Crear un objeto del tipo Juego.
	}
}

