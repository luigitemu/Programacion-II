package Clases;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Archivo {
   private String nombreCompleto;
   private int  tamanioBytes;
   private Usuario usuarioSubio;
   private Usuario UsuariosCompartio[];
   private  String nombreCarpeta;
   private Fecha fechaModificacion;
   private Fecha fechaSubida;
public Archivo(String nombreCompleto, int tamanioBytes, Usuario usuarioSubio, Usuario[] usuariosCompartio,
		String nombreCarpeta, Fecha fechaModificacion, Fecha fechaSubida) {
	super();
	this.nombreCompleto = nombreCompleto;
	this.tamanioBytes = tamanioBytes;
	this.usuarioSubio = usuarioSubio;
	UsuariosCompartio = usuariosCompartio;
	this.nombreCarpeta = nombreCarpeta;
	this.fechaModificacion = fechaModificacion;
	this.fechaSubida = fechaSubida;
}
   public Archivo(){}
public String getNombreCompleto() {
	return nombreCompleto;
}
public void setNombreCompleto(String nombreCompleto) {
	this.nombreCompleto = nombreCompleto;
}
public int getTamanioBytes() {
	return tamanioBytes;
}
public void setTamanioBytes(int tamanioBytes) {
	this.tamanioBytes = tamanioBytes;
}
public Usuario getUsuarioSubio() {
	return usuarioSubio;
}
public void setUsuarioSubio(Usuario usuarioSubio) {
	this.usuarioSubio = usuarioSubio;
}
public Usuario[] getUsuariosCompartio() {
	return UsuariosCompartio;
}
public void setUsuariosCompartio(Usuario[] usuariosCompartio) {
	UsuariosCompartio = usuariosCompartio;
}
public String getNombreCarpeta() {
	return nombreCarpeta;
}
public void setNombreCarpeta(String nombreCarpeta) {
	this.nombreCarpeta = nombreCarpeta;
}
public Fecha getFechaModificacion() {
	return fechaModificacion;
}
public void setFechaModificacion(Fecha fechaModificacion) {
	this.fechaModificacion = fechaModificacion;
}
public Fecha getFechaSubida() {
	return fechaSubida;
}
public void setFechaSubida(Fecha fechaSubida) {
	this.fechaSubida = fechaSubida;
}
@Override
public String toString() {
	return "Archivo [nombreCompleto=" + nombreCompleto +"\n"+ ", tamanioBytes=" + tamanioBytes + ", usuarioSubio="
			+ usuarioSubio +"\n"+ ", UsuariosCompartio=" + Arrays.toString(UsuariosCompartio) +"\n"+ ", nombreCarpeta="
			+ nombreCarpeta + ", fechaModificacion=" + fechaModificacion + ", fechaSubida=" + fechaSubida + "]";
}
   public int  verificarTamanioArchivo(int tamanioBytes){
	   while(tamanioBytes>(500*1024)){
		  tamanioBytes=Integer.parseInt(JOptionPane.showInputDialog("El Tamaño debe ser menor de 500MB"));
	   }
	   return tamanioBytes;
   }
   public String verificarExtensionArchivo(String nombreCompleto){
 	   String[] aux=nombreCompleto.split(".");
 	   while(aux[1]=="bat"||aux[1]=="exe"){
 		   nombreCompleto=JOptionPane.showInputDialog("Ingrese una extension valida");
 	   }
 	   return nombreCompleto;
   }
   
   
}
