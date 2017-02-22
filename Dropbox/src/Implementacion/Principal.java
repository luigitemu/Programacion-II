package Implementacion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clases.Archivo;
import Clases.Fecha;
import Clases.Usuario;

public class Principal {

	public static void main(String[] args) {
		int menu =0;   
		int n=0;
		int n1=0;
	    ArrayList<Archivo> archivos=new ArrayList<Archivo>();
		String fecha;
		String mostrar="";
		Archivo a = new Archivo();
		Usuario u = new Usuario();
		String[] fechas= new String[3];
		Usuario usuarios[];
		Fecha f = new Fecha();
		 	
	   n=Integer.parseInt(JOptionPane.showInputDialog("Cuantos Archivos desea agregar : "));
	   for(int i=0;i<n;i++){
		   a.setNombreCompleto(JOptionPane.showInputDialog("Ingrese el nombre con  la extension . (Ejemplo Nombre Archivo.txt)"));
		   a.setTamanioBytes((a.verificarTamanioArchivo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamanño en bytes :   (No mayor  a 500MB )  ")))));
		   u.setNombreUsuario(JOptionPane.showInputDialog("Ingrese su nombre de Usuario: "));
		   u.setCorreoElectronico(u.verificarCorreo(JOptionPane.showInputDialog("Ingrese su correo electronico: ")));
		   a.setUsuarioSubio(u);
		   n1=Integer.parseInt(JOptionPane.showInputDialog("Con cuantos Usuarios desea compartir  ; no mayor a 5"));
		   while(n1>5){
			   n1= Integer.parseInt(JOptionPane.showInputDialog("Solo puede compartir a maximo 5 usuarios: "));
			   
		   }
		   usuarios=new Usuario[n1];
		   for(int j=0;j<usuarios.length;j++){
			   usuarios[i]=new Usuario(JOptionPane.showInputDialog("Ingrese elnombre de usuario"),u.verificarCorreo(JOptionPane.showInputDialog("Ingrese su correo electronico")));
			   
			   
		   }
		   a.setUsuariosCompartio(usuarios);
		   a.setNombreCarpeta(JOptionPane.showInputDialog("Ingrese el nombre de la carpeta a almacenar "));
		   fecha =JOptionPane.showInputDialog("Ingrese la fecha en formato DD-MM-YYYY \n"
		   		+ "Ejemplo 12-12-2012");
		      fechas=fecha.split("-");
		      f.setDia(Integer.parseInt(fechas[0]));
		      f.setMes(Integer.parseInt(fechas[1]));
		      f.setAnio(Integer.parseInt(fechas[2]));
		      a.setFechaSubida(f);
		      fecha =JOptionPane.showInputDialog("Ingrese la fecha de la ultima modificacion  en formato DD-MM-YYYY \n"
				   		+ "Ejemplo 12-12-2012");
		      fechas=fecha.split("-");
		      f.setDia(Integer.parseInt(fechas[0]));
		      f.setMes(Integer.parseInt(fechas[1]));
		      f.setAnio(Integer.parseInt(fechas[2]));
	       a.setFechaModificacion(f);
	       archivos.add(a);
		   
	   }
        menu= Integer.parseInt(JOptionPane.showInputDialog("1. Mostrar Informacion.\n"
        		+ "2. Salir."));
        switch (menu) {
		case 1:
			for(int i=0;i<archivos.size();i++){
				mostrar+=archivos.get(i).toString()+"\n";
			     
			}
			JOptionPane.showMessageDialog(null, mostrar);
			break;
		case 0:
			JOptionPane.showMessageDialog(null,"Adios!");
		default:
			JOptionPane.showMessageDialog(null,"Caracter no valido ");
			break;
		}
		}       
}