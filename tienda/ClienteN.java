package tienda;

public class ClienteN extends Cliente {

    private String DNI;
    private int AñodelCarnet = 2000;

    // Constructores
    public ClienteN(String nombre, String apellido, long telefono, String DNI, int AñodelCarnet) {
        super(nombre, apellido, telefono);
        this.DNI = DNI;
        this.AñodelCarnet = AñodelCarnet;
    }
    public ClienteN() {
    	
    }

    // Getters and setters
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    public int getAñodelCarnet() {
		return AñodelCarnet;
	}

	public void setAñodelCarnet(int añodelCarnet) {
		AñodelCarnet = añodelCarnet;
	}

	//Metodos
    public void MostrarInfoCliente() {
    	System.out.println("*INFORMACION CLIENTE*");
    	super.MostrarInfoCliente();
    	System.out.println("DNI: " + this.DNI);
    	System.out.println("Año que te sacaste el carnet: " + this.AñodelCarnet);
        System.out.println("-----------------------------");
    }
}
