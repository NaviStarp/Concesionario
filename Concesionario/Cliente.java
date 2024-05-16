package Concesionario;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

	protected static String nombre = "Sin nombre";
	private String apellido = "Sin apellidos";
	private String DNI;
	private long telefono = 0000000000;
	protected static String contraseña = "Sin contraseña";
	private int AñodelCarnet = 2000;
	private static String rol = "Cliente";

	// Constructores

	public Cliente(String nombre, String apellido, long telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public Cliente() {
	}

	// Getters y Setters

	public static String getNombre() {
		return nombre;
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

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getcontraseña() {
		return contraseña;
	}

	public void setcontraseña(int telefono) {
		this.contraseña = contraseña;
	}

	public static String getrol() {
		return rol;
	}

	public void setrol(String rol) {
		this.rol = rol;
	}
	// Metodos

	public void MostrarInfoCliente() {
		System.out.println("\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nContraseña:"
				+ this.contraseña + "\nTelefono: " + this.telefono);
	}

}
