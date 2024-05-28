package BD;
import java.sql.Connection;
import java.sql.Date;

import Clases.*;
 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.time.LocalDate;

public class ConexionBD {

	/** base de datos */

	public static Connection con;

	private static final String user = "root";
    private static final String pass = "Patata_123"; // contraseña ivan BD
	//private static final String pass  = "1234"; // contraseña javier BD
	private static final String url = "jdbc:mysql://localhost:3306/tienda";

	public Connection conectar() {
		con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Fallo al conectar con la base de datos");
			System.exit(1);
		}

		return con;
	}

	public boolean crearUsuario(Cliente cliente, boolean admin) {
		Connection c = conectar();
		try {
			PreparedStatement ps = null;
			if (admin) {
				ps = c.prepareStatement(
						"INSERT INTO USUARIOS (DNI,NOMBRE,APELLIDO,CONTRASEÑA,TELEFONO,AÑO_DEL_CARNET,rol) VALUES (?,?,?,?,?,?,'admin')");

			} else {
				ps = c.prepareStatement(
						"INSERT INTO USUARIOS (DNI,NOMBRE,APELLIDO,CONTRASEÑA,TELEFONO,AÑO_DEL_CARNET) VALUES (?,?,?,?,?,?)");

			}
			ps.setString(1, cliente.getDNI());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellido());
			ps.setString(4, cliente.getcontraseña());
			ps.setString(5, cliente.getTelefono());
			ps.setInt(6, cliente.getAñodelCarnet());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean borrarUsuario(String dni) {
		Connection c = conectar();
		try {
			PreparedStatement ps = null;

			ps = c.prepareStatement("DELETE FROM USUARIOS WHERE DNI = ?");

			ps.setString(1, dni);
			boolean resultado = ps.execute();
			return resultado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean existeUsuario(String dni) {
		Connection c = conectar();
		try {
			PreparedStatement ps = null;

			ps = c.prepareStatement("select * FROM USUARIOS WHERE DNI = ?");

			ps.setString(1, dni);
			boolean resultado = ps.execute();
			return resultado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean modificarUsuario(String dni,String campo,String cambio) {
		Connection c = conectar();
		try {
			PreparedStatement ps = null;

			ps = c.prepareStatement(String.format("UPDATE USUARIOS SET %s = ? WHERE dni = ? ",campo));
			ps.setString(1, cambio);
			ps.setString(2, dni);
			ps.execute();
			return true;
		} catch (SQLException e) {
             e.printStackTrace();
		}
		return false;
	}
	public boolean crearVehiculo(Vehiculo vehiculo) {
		Connection c = conectar();
		try {
			PreparedStatement ps = null;
				ps = c.prepareStatement(
						"INSERT INTO Vehiculos (Matricula,Marca,Modelo,Año,Color,Precio,Tipo) VALUES (?,?,?,?,?,?,?)");

			ps.setString(1, vehiculo.getMatricula());
			ps.setString(2, vehiculo.getMarca());
			ps.setString(3, vehiculo.getModelo());
			ps.setInt(4, vehiculo.getAño());
			ps.setString(5, vehiculo.getColor());
			ps.setDouble(6, vehiculo.getPrecio());
			ps.setString(7, vehiculo.getTipo());
			ps.execute();
			return true;
		} catch (SQLException e) {
             System.out.println("Error :" + e.getMessage());
		}
		return false;
	}

	public boolean borrarVehiculo(String dni) {
		Connection c = conectar();
		try {
			PreparedStatement ps = null;

			ps = c.prepareStatement("DELETE FROM vehiculos WHERE matricula = ?");

			ps.setString(1, dni);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean modificarVehiculo(String matricula,String campo,String cambio) {
		Connection c = conectar();
		try {
			PreparedStatement ps = null;

			ps = c.prepareStatement(String.format("UPDATE Vehiculos SET %s = ? WHERE Matricula = ? ",campo));
			ps.setString(1, cambio);
			ps.setString(2, matricula);
			ps.execute();
			return true;
		} catch (SQLException e) {
              System.out.println("Error : "  +e.getMessage());
		}
		return false;
	}
	public boolean existeVehiculo(String matricula) {
		String query = "SELECT * FROM VEHICULOS WHERE MATRICULA = ?";
		PreparedStatement ps;
		try {
			ps = new ConexionBD().conectar().prepareStatement(query);
			ps.setString(1, matricula);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
		}
		return false;
	}
	public static void buscarVehiculos(ArrayList<String> matriculas,ArrayList<Vehiculo> vehiculos) {
		String query = "SELECT * FROM vehiculos where matricula = ?;";
		PreparedStatement s;
		try {
			for(String matricula : matriculas) {
			s = new ConexionBD().conectar().prepareStatement(query);
		    s.setString(1, matricula);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
		        String Matricula = rs.getString(1);
		        String Marca = rs.getString(2);
		        String Modelo = rs.getString(3);
		        int Año;
		        double Precio = rs.getDouble(6);
		        Año = rs.getInt(4);
		        String Color = rs.getString(5);
		         String tipo = rs.getString(7);   
		         
		        vehiculos.add(new Vehiculo(Marca, Modelo, Año, Precio, Color, Matricula, tipo));
			}
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void buscarUsuarios(ArrayList<String> DNIs, ArrayList<Cliente> usuarios) {
	    String query = "SELECT * FROM usuarios WHERE dni = ?;"; 
	    PreparedStatement statement;
	    try {
	        for (String dni : DNIs) {
	            statement = new ConexionBD().conectar().prepareStatement(query);
	            statement.setString(1, dni);
	            ResultSet rs = statement.executeQuery();
	            while (rs.next()) {
	                String DNI = rs.getString(1);
	                String nombre = rs.getString(2);
	                String apellido = rs.getString(3);
	                String contraseña = rs.getString(4);
	                String telefono = rs.getString(5);
	                int añoDelCarnet = rs.getInt(6);
	                
	                usuarios.add(new Cliente(DNI, nombre, apellido, contraseña, telefono, añoDelCarnet));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static double BuscarPrecio(String matricula) {
		String query = "SELECT * FROM vehiculos where matricula = ?;";
		PreparedStatement s;
		try {
			s = new ConexionBD().conectar().prepareStatement(query);
		    s.setString(1, matricula);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
		        double Precio = rs.getDouble(6);
                   return Precio;		         
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public boolean actualizarVehiculo(String matricula,Cliente cliente,boolean alquilado,int diasAlquiler)   {
        PreparedStatement ps;
        String sql = "";
        // Calcular la fecha de devolución
         Date fechaDevolucion =  Date.valueOf(LocalDate.now().plusDays(diasAlquiler));
        System.out.println(matricula);
        if (alquilado) {
        	sql = String.format("UPDATE vehiculos SET FechaFinAlquiler = ?, `DNI-propietario` = ?, `Comprado-alquilado` = 'Si' WHERE matricula = '%s'", matricula);
    		try {
				ps = new ConexionBD().conectar().prepareStatement(sql);
				ps.setDate(1, fechaDevolucion);
	    		ps.setString(2, cliente.getDNI());
	    		int resultado = ps.executeUpdate();
	    	 	
	    		if (resultado>0) {
					return true;
				}
	    		return false;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
 	    		return false;
			}
   
    		
		}else {
			 sql = String.format("UPDATE vehiculos SET `comprado-alquilado` = 'Si',`DNI-propietario` = ? WHERE matricula = '%s'", matricula);
			try {
				ps = new ConexionBD().conectar().prepareStatement(sql);
				ps.setString(1, cliente.getDNI());
				int resultado = ps.executeUpdate();
				if (resultado >0) {
					return true;
					
				}
				return false;
			} catch (SQLException e) {
			 System.out.println(e.getMessage());
			}
              return false;
		}

	}
	public boolean sePuedeComprarAlquilar(String matricula) 
	{
		String sql = "SELECT * FROM VEHICULOS WHERE MATRICULA = ?";
		try {
			PreparedStatement ps = new ConexionBD().conectar().prepareStatement(sql);
			ps.setString(1, matricula);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String comprable = rs.getString(8);
				if (comprable.equalsIgnoreCase("Si")) {
					return false;
				}
				return true;
			}
		} catch (Exception e) {
              System.out.println("Error : " + e.getMessage());
		}
		return false;
	}
	
	

}