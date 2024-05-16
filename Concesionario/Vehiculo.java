package Concesionario;

public class Vehiculo {

	   protected String marca;
	    protected String modelo;
	    protected int año;
	    protected double precio;
	    protected String color;
	    protected String matricula;
	    protected  boolean comprada = false;
	    protected boolean alquilada; 
	    protected long diasAlquilados; 


	    // Getters y Setters
	    public String getMarca() {
	        return marca;
	    }

	    public boolean setComprada() {
			return comprada;
		}

		public void setComprada(boolean comprada) {
			this.comprada = comprada;
		}

		public void setMarca(String marca) {
	        this.marca = marca;
	    }

	    public String getModelo() {
	        return modelo;
	    }

	    public void setModelo(String modelo) {
	        this.modelo = modelo;
	    }

	    public int getAño() {
	        return año;
	    }

	    public void setAño(int año) {
	        this.año = año;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }

	    public String getColor() {
	        return color;
	    }

	    public void setColor(String color) {
	        this.color = color;
	    }

	    public String getMatricula() {
	        return matricula;
	    }

	    public void setMatricula(String matricula) {
	        this.matricula = matricula;
	    }

	    public boolean isAlquilada() {
	        return alquilada;
	    }

	    public void setAlquilada(boolean alquilada) {
	        this.alquilada = alquilada;
	    }

	    public long getDiasAlquilados() {
	        return diasAlquilados;
	    }

	    public void setDiasAlquilados(long diasAlquiler) {
	        this.diasAlquilados = diasAlquiler;
	    }
}
