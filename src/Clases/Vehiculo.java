package Clases;
public class Vehiculo {

	   private String marca;
	    private String modelo;
	    private int año;
	    private double precio;
	    private String color;
	    private String matricula;
	    private String tipo;
	    private  boolean comprada = false;
	    private boolean alquilada; 
	    private long diasAlquilados =1; 


	  

		public Vehiculo(String marca, String modelo, int año, double precio, String color, String matricula,
				String tipo) {
			super();
			this.marca = marca;
			this.modelo = modelo;
			this.año = año;
			this.precio = precio;
			this.color = color;
			this.matricula = matricula;
			this.tipo = tipo;
			
		}

		public Vehiculo() {
			// TODO Auto-generated constructor stub
		}

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

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public boolean isComprada() {
			return comprada;
		}
	    
}
