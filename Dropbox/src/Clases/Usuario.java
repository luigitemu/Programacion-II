package Clases;

import javax.swing.JOptionPane;

public class Usuario {
	public Usuario(String nombreUsuario, String correoElectronico) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.correoElectronico = correoElectronico;
	}

	private String nombreUsuario;
	private String correoElectronico;
	private String ususariosCompartio;
	public String getUsusariosCompartio() {
		return ususariosCompartio;
	}


	public void setUsusariosCompartio(String ususariosCompartio) {
		this.ususariosCompartio = ususariosCompartio;
	}


	public Usuario(){}
	
	
     public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", correoElectronico=" + correoElectronico + "]";
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public String verificarCorreo(String correoElectronico){
		
        while(correoElectronico.indexOf("@")!=correoElectronico.lastIndexOf("@")){
        	correoElectronico =JOptionPane.showInputDialog("correo erroneo escriba solo una @ ");
        }
        return correoElectronico;
	}
}
