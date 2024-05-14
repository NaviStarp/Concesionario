package tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

	protected String nombre = "Sin nombre";
	protected String apellido = "Sin apellidos";
	protected String DNI;
	protected long telefono = 0000000000;
	protected String contraseña = "Sin contraseña";
	
	//Constructores
	
	public Cliente(String nombre, String apellido, long telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
    public Cliente() {
    }

    
    //Getters y Setters
    
    public String getNombre() {
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
    
    //Metodos
    
    public void MostrarInfoCliente() {
    	System.out.println("\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nContraseña:"  + this.contraseña  + "\nTelefono: " + this.telefono);
    }
    
}
