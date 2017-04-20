import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Compania;
import Clases.Marca;
import Clases.SistemaOperativo;
import Clases.Telefono;

public class Formulario implements ActionListener{
	private JFrame ventana;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblSistemaOperativo;
	private JLabel lblCapacidadMemoria;
	private JLabel lblCapacidadDisco;
	private JLabel lblresolucion;
	private JLabel lblTamanioPantalla;
	private JLabel lblCompania;
	private JLabel lblNumeroTelefonico;
	private JLabel lblCapacidadCamara;
	private JLabel lblOtrosComponentes;
	
	private JTextField txtCapacidadMemoria;
	private JTextField txtCapacidadDisco;
	private JTextField txtresolucion;
	private JTextField txtTamanioPantalla;
	private JTextField txtNumeroTelefonico;
	private JTextField txtCapacidadCamara;
	
	private JRadioButton rbrTigo;
	private JRadioButton rbrClaro;
	private JRadioButton rbrHondutel;
	private ButtonGroup btngCompania;
	
	private JCheckBox chkNfc;
	private JCheckBox chkLte;
	private JCheckBox chkBluetooh;
	
	private JComboBox<Marca> cmbMarca;
	private JComboBox<SistemaOperativo> cmbSistemaOperativo; 
	private JComboBox<String> cmbModelo;
	
	private JTextArea txtaInformacion;
	private JScrollPane scrollInformacion;
	
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnSalir;
	
	private ArrayList<Telefono> telefonos;

	public Formulario(){
	inicializarVentana();	
	inicializarMetodos();
	ventana.setVisible(true);
	}
	public void inicializarVentana(){
		ventana = new JFrame("Formulario");
		ventana.setSize(550, 560);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void inicializarMetodos(){
		//label
		lblMarca = new JLabel("Marca");
		lblModelo = new JLabel("Modelo");
		lblSistemaOperativo= new JLabel("Sistema Operativo");
		lblCapacidadMemoria = new JLabel("Capacidad de Memoria ");
		lblCapacidadDisco = new JLabel("Capacidad Disco");
		lblresolucion = new JLabel("Resolucion");
		lblTamanioPantalla = new JLabel("Tamaño pantalla");
		lblCompania = new JLabel("Compañia");
		lblNumeroTelefonico = new JLabel("Numero Telefonico");
		lblCapacidadCamara = new JLabel("Capacidad Camara");
		lblOtrosComponentes = new JLabel("Otros Componentes");
		
		//text fields
		txtCapacidadCamara = new JTextField();
		txtCapacidadDisco = new JTextField();
		txtCapacidadMemoria = new JTextField();
		txtNumeroTelefonico = new JTextField();
		txtresolucion = new JTextField();
		txtTamanioPantalla =new JTextField();
		
		//Radio Button 
		rbrClaro = new JRadioButton("Claro");
		rbrTigo = new JRadioButton("Tigo");
		rbrHondutel = new JRadioButton("Hondutel");
		btngCompania = new ButtonGroup();
		btngCompania.add(rbrClaro);
		btngCompania.add(rbrHondutel);
		btngCompania.add(rbrTigo);
		
		// check box
		chkBluetooh = new JCheckBox("Bluetooh");
		chkNfc = new JCheckBox("NFC");
		chkLte = new JCheckBox("LTE");
		
		//combo box
		cmbMarca= new JComboBox<Marca>();
		cmbSistemaOperativo = new JComboBox<SistemaOperativo>();
		cmbModelo = new JComboBox<String>();
		agregarcombobox();
		
		//button 
		btnActualizar = new JButton("Actualizar");
		btnEliminar = new JButton("Eliminar");
		btnGuardar = new JButton("Guardar");
		btnSalir = new JButton("Salir");
		btnNuevo = new JButton("Nuevo");
		
		eventos();
		
		//lbl Bounds
		lblMarca.setBounds(10, 24, 147, 14);
		lblModelo.setBounds(10, 49, 147, 14);
		lblSistemaOperativo.setBounds(10, 74, 147, 14);
		lblCapacidadMemoria.setBounds(10, 102, 147, 14);
		lblCapacidadDisco.setBounds(10, 127, 147, 14);
		lblresolucion.setBounds(10, 152, 147, 14);
		lblTamanioPantalla.setBounds(10, 177, 147, 14);
		lblCompania.setBounds(10, 202, 147, 14);
		lblNumeroTelefonico.setBounds(10, 230, 147, 14);
		lblCapacidadCamara.setBounds(10, 254, 123, 14);
		lblOtrosComponentes.setBounds(10, 277, 147, 14);
		
		// txt Bounds
		txtCapacidadCamara.setBounds(160, 253, 86, 20);
		txtCapacidadMemoria.setBounds(160, 99, 104, 20);
		txtCapacidadDisco.setBounds(160, 124, 104, 20);
		txtresolucion.setBounds(160, 149, 104, 20);
		txtTamanioPantalla.setBounds(160, 174, 147, 20);
		txtNumeroTelefonico.setBounds(160, 227, 194, 20);
		
		
		//rbt Bounds
		rbrClaro.setBounds(230, 198, 65, 23);
		rbrTigo.setBounds(163, 198, 65, 23);
		rbrHondutel.setBounds(297, 198, 109, 23);
		
		//chk Bounds
		chkBluetooh.setBounds(272, 273, 97, 23);
		chkNfc.setBounds(161, 273, 55, 23);
		chkLte.setBounds(218, 273, 49, 23);
		
		//cmb Bounds
		cmbMarca.setBounds(160, 21, 242, 20);
		cmbModelo.setBounds(160, 46, 242, 20);
		cmbSistemaOperativo.setBounds(160, 71, 242, 20);
		
		
		//btn bounds
		btnNuevo.setBounds(417, 19, 107, 23);
		btnGuardar.setBounds(417, 44, 107, 23);
		btnActualizar.setBounds(417, 69, 107, 23);
		btnEliminar.setBounds(417, 95, 107, 23);
		btnSalir.setBounds(417, 121, 107, 23);
		
		// textarea ScrollPane
		txtaInformacion = new JTextArea();
		scrollInformacion = new JScrollPane(txtaInformacion);
		scrollInformacion.setBounds(10, 302, 522, 208);
		txtaInformacion.setEditable(false);
		
		
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidadCamara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidadDisco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefonico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidadMemoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompania.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOtrosComponentes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblresolucion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSistemaOperativo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTamanioPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//ventana
		ventana.add(lblMarca);
		ventana.add(lblModelo);
		ventana.add(lblSistemaOperativo);
		ventana.add(lblCapacidadMemoria);
		ventana.add(lblCapacidadDisco);
		ventana.add(lblresolucion);
		ventana.add(lblTamanioPantalla);
		ventana.add(lblCompania);
		ventana.add(lblNumeroTelefonico);
		ventana.add(lblCapacidadCamara);
		ventana.add(lblOtrosComponentes);
		ventana.add(txtCapacidadCamara);
		ventana.add(txtCapacidadDisco);
		ventana.add(txtCapacidadMemoria);
		ventana.add(txtNumeroTelefonico);
		ventana.add(txtresolucion);
		ventana.add(txtTamanioPantalla);
		ventana.add(rbrClaro);
		ventana.add(rbrHondutel);
		ventana.add(rbrTigo);
		ventana.add(chkBluetooh);
		ventana.add(chkLte);
		ventana.add(chkNfc);
		ventana.add(cmbMarca);
		ventana.add(cmbModelo);
		ventana.add(cmbSistemaOperativo);
		ventana.add(scrollInformacion);
		ventana.add(btnActualizar);
		ventana.add(btnEliminar);
		ventana.add(btnGuardar);
		ventana.add(btnNuevo);
		ventana.add(btnSalir);
		
	}
	public void agregarcombobox(){
		cmbMarca.addItem(new Marca("1234", "Samsung"));
		cmbMarca.addItem(new Marca("1111", "Motorolla"));
		cmbMarca.addItem(new Marca("1344", "HTC"));
		cmbMarca.addItem(new Marca("444s", "Apple"));
		
		cmbSistemaOperativo.addItem(new SistemaOperativo("Windows", "2.01", "2011"));
		cmbSistemaOperativo.addItem(new SistemaOperativo("Android", "7.01", "2017"));
		cmbSistemaOperativo.addItem(new SistemaOperativo("IOS", "10.01", "2017"));
		
		cmbModelo.addItem("S8");
		cmbModelo.addItem("S7");
		cmbModelo.addItem("S6");
		cmbModelo.addItem("m8");
		cmbModelo.addItem("m9");
		cmbModelo.addItem("7s");
		cmbModelo.addItem("6s");
	}
	
	public static void main(String[] args) {
		new Formulario();

	}
	public void eventos(){
	 btnGuardar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			guardarRegistro();
			
		}
	});
	 btnActualizar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			actualizarRegistro();
			
		}
	});
	 
	 btnNuevo.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			nuevoRegistro();
			
		}
	});
	 btnEliminar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		int indice = Integer.parseInt(JOptionPane.showInputDialog("cual elemento desea eliminar"));
			telefonos.remove(indice);
			mostrarInformacion();
		}
	});
	 btnSalir.addActionListener(this);
	}
	
	public void guardarRegistro(){
	
		Compania c = new Compania();
		if(rbrClaro.isSelected())
			c = new Compania("Claro", "a2", "tegucigalpa", "89001789");
		if(rbrTigo.isSelected())
			c = new Compania("Tigo", "a1", "tegucigalpa", "90000102");
		if(rbrClaro.isSelected())
			c = new Compania("Hondutel", "a3", "tegucigalpa", "26561789");
		ArrayList<String> otros = new ArrayList<String>();
		if(chkBluetooh.isSelected())
			otros.add("Bluetooh");
		if(chkNfc.isSelected())
			otros.add("NFC");
		if(chkLte.isSelected())
			otros.add("LTE");
		
		
		telefonos.add(new Telefono(
				txtresolucion.getText(),
				txtTamanioPantalla.getText(),
				(SistemaOperativo)cmbSistemaOperativo.getSelectedItem(),
				Double.parseDouble(txtCapacidadDisco.getText()),
				Double.parseDouble(txtCapacidadMemoria.getText()),
				(Marca)cmbMarca.getSelectedItem(), 
				(String)cmbModelo.getSelectedItem(),
				txtNumeroTelefonico.getText(), 
				Double.parseDouble(txtCapacidadCamara.getText()),
				c,
				otros
				));
				
	mostrarInformacion();		
	
	}
	public void actualizarRegistro(){

		int indice = Integer.parseInt(JOptionPane.showInputDialog("cual elemento desea modificar"));
		
		
		Compania c = new Compania();
		if(rbrClaro.isSelected())
			c = new Compania("Claro", "a2", "tegucigalpa", "89001789");
		if(rbrTigo.isSelected())
			c = new Compania("Tigo", "a1", "tegucigalpa", "90000102");
		if(rbrClaro.isSelected())
			c = new Compania("Hondutel", "a3", "tegucigalpa", "26561789");
		else
			c= new Compania("Hondutel", "a3", "tegucigalpa", "26561789");
		
		ArrayList<String> otros = new ArrayList<String>();
		if(chkBluetooh.isSelected())
			otros.add("Bluetooh");
		if(chkNfc.isSelected())
			otros.add("NFC");
		if(chkLte.isSelected()){
			otros.add("LTE");
		}else {
			otros.add("no contiene ningun extra");
		}
		
		
		telefonos.set(indice, new Telefono(
				txtresolucion.getText(),
				txtTamanioPantalla.getText(),
				(SistemaOperativo)cmbSistemaOperativo.getSelectedItem(),
				Double.parseDouble(txtCapacidadDisco.getText()),
				Double.parseDouble(txtCapacidadMemoria.getText()),
				(Marca)cmbMarca.getSelectedItem(), 
				(String)cmbModelo.getSelectedItem(),
				txtNumeroTelefonico.getText(), 
				Double.parseDouble(txtCapacidadCamara.getText()),
				c,
				otros
				));
	mostrarInformacion();	
		
		
	
	}
	public void nuevoRegistro(){
		cmbMarca.setSelectedItem(null);
		cmbModelo.setSelectedItem(null);
		cmbSistemaOperativo.setSelectedItem(null);
		txtCapacidadCamara.setText(null);
		txtCapacidadDisco.setText(null);
		txtCapacidadMemoria.setText(null);
		txtNumeroTelefonico.setText(null);
		txtresolucion.setText(null);
		txtTamanioPantalla.setText(null);
		btngCompania.clearSelection();
		chkBluetooh.setSelected(false);
		chkNfc.setSelected(false);
		chkLte.setSelected(false);
	}
	
	public void mostrarInformacion(){
		txtaInformacion.setText(null);
		for(int i=0;i<telefonos.size();i++){
			txtaInformacion.append(telefonos.get(i).toString()+"\n");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getText()=="Salir"){
			System.exit(0);
		}
		
	}

}
