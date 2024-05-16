package Concesionario;

public class Administrador extends Cliente {

    private String ID;

    // Constructores
    public Administrador(String nombre, String apellido, int telefono, String ID) {
        super(nombre, apellido, telefono);
        this.ID = ID;
    }

    // Getters and setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    // Métodos
    public void MostrarInfoCliente() {
    	System.out.println("*INFORMACION ADMINISTRADOR*");
     	this.nombre = "Admin";
     	this.contraseña = "Admin";
    	this.ID = "12345";
    	super.MostrarInfoCliente();
    	System.out.println("ID: " + this.ID);
        System.out.println("-----------------------------");

    }
}
