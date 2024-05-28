package Clases;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

	protected String nombre = "Sin nombre";
	private String apellido = "Sin apellidos";
	private String DNI;
	private String telefono = "0000000000";
	protected String contraseña = "Sin contraseña";
	private int AñodelCarnet = 2000;
	private String rol = "Cliente";

	// Constructores

	public Cliente(String DNi,String nombre, String apellido,String contraseña, String telefono,int añoDelCarnet) {
		super();
		this.DNI = DNi;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.AñodelCarnet = añoDelCarnet;
	}

	public Cliente() {
	}

	// Getters y Setters



	public String getNombre() {
		return nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getcontraseña() {
		return contraseña;
	}

	public void setcontraseña(int telefono) {
		this.contraseña = contraseña;
	}

	public String getrol() {
		return rol;
	}

	public void setrol(String rol) {
		this.rol = rol;
	}
	

	public int getAñodelCarnet() {
		return AñodelCarnet;
	}

	public void setAñodelCarnet(int añodelCarnet) {
		AñodelCarnet = añodelCarnet;
	}

	public void MostrarInfoCliente() {
		System.out.println("\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nContraseña:"
				+ this.contraseña + "\nTelefono: " + this.telefono);
	}

}
