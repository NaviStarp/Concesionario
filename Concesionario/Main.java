package Concesionario;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

	private static final String URL_USUARIOS = "jdbc:mysql://localhost:3306/tienda";
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "javier";// cambiar

	public static void main(String[] args) {
		inicio();
		opcionesInicio();
		leerRegistros();
		
		
		// Registrarse();
		// IniciarSesion();
		// eliminarRegistro();
		// menuAdmin();
		// actualizarRegistro();

		System.out.println("fuera");
	}

	public static Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(URL_USUARIOS, USUARIO, CONTRASENA);
	}

	/***************************************************************************************
	 * Iniciar sesio:
	 */

	public static void opcionesInicio() {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		do {

			menuInicio();
			char opc = sc.next().charAt(0);
			switch (opc) {
			case '1':
				IniciarSesion();
				break;
			case '2':
				Registrarse();
				break;
			case '3':
				salir = true;
				break;
			default:
				System.out.println("Opcion no valida, vuelve a intentarlo\n");
			}
		} while (salir != true);
		System.out.println("¡Gracias por usar nuestra aplicación!, que tengas un buen día");
	}

	public static void IniciarSesion() {
	    Scanner scanner = new Scanner(System.in);  // Scanner para entrada del usuario
	    System.out.println("Ingrese su DNI:");
	    String dniIngresado = scanner.nextLine();
	    System.out.println("Ingrese su contraseña:");
	    String contrasenaIngresada = scanner.nextLine();

	    String consulta = "SELECT nombre, apellido, rol FROM usuarios WHERE DNI = ? AND contraseña = ?;";
	    
	    try (
	        Connection conexion = obtenerConexion();  // Obtener la conexión a la base de datos
	        PreparedStatement declaracion = conexion.prepareStatement(consulta);  // Preparar la declaración SQL
	    ) {
	        declaracion.setString(1, dniIngresado);  // Asignar DNI
	        declaracion.setString(2, contrasenaIngresada);  // Asignar contraseña

	        ResultSet resultado = declaracion.executeQuery();  // Ejecutar consulta

	        // Comprobar si se obtuvo algún resultado
	        if (resultado.next()) {
	            String nombre = resultado.getString("nombre");
	            String rol = resultado.getString("rol");

	            System.out.println("\nBienvenido, " + nombre + " ");
	            
	            // Decidir el flujo de acción basado en el rol del usuario
	            if ("administrador".equalsIgnoreCase(rol)) {
	                System.out.println("Acceso como administrador.");
	                
	                // Aquí irían métodos relacionados con funciones de administrador
	            } else if ("usuario".equalsIgnoreCase(rol)) {
	                System.out.println("Acceso como cliente.");
	                // Aquí irían métodos relacionados con funciones de cliente
	            } else {
	                System.out.println("Rol no reconocido.");
	            }
	        } else {
	            System.out.println("DNI o contraseña incorrectos.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al conectar con la base de datos.");
	    }
	}


	public static void Registrarse() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduzca el DNI del nuevo usuario:");
		String dni = scanner.nextLine();
		System.out.println("Introduzca el nombre del nuevo usuario:");
		String nombre = scanner.nextLine();
		System.out.println("Introduzca el apellido del nuevo usuario:");
		String apellido = scanner.nextLine();
		System.out.println("Introduzca la contraseña del nuevo usuario:");
		String contrasena = scanner.nextLine();
		System.out.println("Introduzca el teléfono del nuevo usuario:");
		int telefono = scanner.nextInt();
		scanner.nextLine(); 
		System.out.println("Introduzca el año del carnet del nuevo usuario:");
		int anoCarnet = scanner.nextInt();
		scanner.nextLine(); 
		System.out.println("Introduzca el rol del nuevo usuario:");
		String rol = scanner.nextLine();

		String consulta = "INSERT INTO usuarios (DNI, nombre, contraseña, apellido, telefono, año_del_carnet, rol) VALUES (?, ?, ?, ?, ?, ?, ?);";

		try (Connection conexion = obtenerConexion();
				PreparedStatement declaracion = conexion.prepareStatement(consulta);) {
			declaracion.setString(1, dni);
			declaracion.setString(2, nombre);
			declaracion.setString(3, contrasena);
			declaracion.setString(4, apellido);
			declaracion.setInt(5, telefono);
			declaracion.setInt(6, anoCarnet);
			declaracion.setString(7, rol);

			int resultado = declaracion.executeUpdate();
			if (resultado > 0) {
				System.out.println("Usuario creado exitosamente.");
			} else {
				System.out.println("No se pudo crear el usuario.");
			}
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos.");
			e.printStackTrace();
		}
	}

	/***************************************************************************************
	 * Usuarios:
	 */
	public static boolean eliminarRegistro() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca DNI para eliminar el registro: ");
		String DNI = sc.nextLine();
		String consulta = "DELETE FROM usuarios WHERE DNI = ?;";
		try (Connection conexion = obtenerConexion();
				PreparedStatement declaracion = conexion.prepareStatement(consulta)) {
			declaracion.setString(1, DNI);
			// Ejecuta la consulta SQL de eliminación
			int resultado = declaracion.executeUpdate();
			if (resultado > 0) {
				System.out.println("Registro eliminado correctamente.");
				return true;
			} else {
				System.out.println("No se encontró el registro a eliminar o no se pudo eliminar.");
				return false;
			}
		} catch (SQLException e) {
			// Manejo de errores SQL
			System.out.println("Error al eliminar registro: " + e.getMessage());
		}
		return false;
	}
 
	public static void leerRegistros() {
		String consulta = "SELECT * FROM usuarios";
		try (Connection conexion = obtenerConexion();
				Statement declaracion = conexion.createStatement();
				ResultSet resultados = declaracion.executeQuery(consulta)) {
			while (resultados.next()) {
				String DNI = resultados.getString("DNI");
				String nombre = resultados.getString("nombre");
				String contraseña = resultados.getString("contraseña");
				String apellido = resultados.getString("apellido");
				int telefono = resultados.getInt("telefono");
				int año_del_carnet = resultados.getInt("año_del_carnet");
				String rol = resultados.getString("rol");

				// Imprime la información de cada usuario
				System.out.println("\nDNI: " + DNI);
				System.out.println("Nombre: " + nombre);
				System.out.println("Contraseña: " + contraseña);
				System.out.println("Apellido: " + apellido);
				System.out.println("Teléfono: " + telefono);
				System.out.println("Año del carnet: " + año_del_carnet);
				System.out.println("Rol: " + rol);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarRegistro() {
		Scanner scanner = new Scanner(System.in);

		// Solicitar la matrícula de la moto a actualizar
		System.out.println("Ingrese el DNI del usuario que desea actualizar:");
		String DNI = scanner.nextLine();

		// Mostrar opciones de lo que se puede actualizar
		System.out.println("¿Qué quieres actualizar?");
		System.out.println("1. DNI");
		System.out.println("2. Nombre");
		System.out.println("3. Contraseña");
		System.out.println("4. Apellido");
		System.out.println("5. Telefono");
		System.out.println("6. Año del carnet");
		System.out.println("7. Rol\n");
		System.out.print("Opción: ");
		int opcion = Integer.parseInt(scanner.nextLine());

		String campo = "";
		switch (opcion) {
		case 1:
			campo = "DNI";
			break;
		case 2:
			campo = "Nombre";
			break;
		case 3:
			campo = "Contraseña";
			break;
		case 4:
			campo = "Apellido";
			break;
		case 5:
			campo = "Telefono";
			break;
		case 6:
			campo = "Año del Carnet";
			break;
		case 7:
			campo = "Rol";
			break;
		default:
			System.out.println("Opción no válida");
			return;
		}

		// Pedir el nuevo valor para el campo seleccionado
		String nuevoValor;
		if (opcion == 3) {
			System.out.println("Ingrese el nuevo valor para la " + campo + ":");
			nuevoValor = scanner.nextLine();
		} else {
			System.out.println("Ingrese el nuevo valor para el " + campo + ":");
			nuevoValor = scanner.nextLine();
		}
		// Crear la consulta SQL usando PreparedStatement para evitar inyecciones SQL
		String consulta = "UPDATE usuarios SET " + campo + " = ? WHERE DNI = ?";

		try (Connection conexion = obtenerConexion();
				PreparedStatement declaracion = conexion.prepareStatement(consulta)) {

			declaracion.setString(1, nuevoValor);
			declaracion.setString(2, DNI);

			// Ejecutar la actualización
			int filasAfectadas = declaracion.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Usuario actualizado correctamente.");
			} else {
				System.out.println("No se encontró ningun usuario con ese DNI.");
			}

		} catch (SQLException e) {
			System.out.println("Error al actualizar la usuario.");
			e.printStackTrace();
		}
	}

	/***************************************************************************************
	 * Motos metodos:
	 */
	public static void añadirMoto() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduzca la matricula: ");
		String matricula = scanner.nextLine();
		System.out.println("Introduzca el marca: ");
		String marca = scanner.nextLine();
		System.out.println("Introduzca el modelo :");
		String modelo = scanner.nextLine();
		System.out.println("Introduzca el año: ");
		int año = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Introduzca el color :");
		String color = scanner.nextLine();
		System.out.println("Introduzca el precio: ");
		int precio = scanner.nextInt();
		scanner.nextLine(); // Limpia el buffer después de leer un número.
		System.out.println("Introduzca el tipo: ");
		String tipo = scanner.nextLine();

		String consulta = "INSERT INTO motos (matricula, marca, modelo, año, color, precio, tipo) VALUES (?, ?, ?, ?, ?, ?, ?);";

		try (Connection conexion = obtenerConexion();
				PreparedStatement declaracion = conexion.prepareStatement(consulta);) {
			declaracion.setString(1, matricula);
			declaracion.setString(2, marca);
			declaracion.setString(3, modelo);
			declaracion.setInt(4, año);
			declaracion.setString(5, color);
			declaracion.setInt(6, precio);
			declaracion.setString(7, tipo);

			int resultado = declaracion.executeUpdate();
			if (resultado > 0) {
				System.out.println("Moto agregada al catalogo.");
			} else {
				System.out.println("No se pudo agregar la moto.");
			}
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos.");
			e.printStackTrace();
		}
	}

	public static void eliminarMoto() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca Matricula para eliminar la moto: ");
		String matricula = sc.nextLine();
		String consulta = "DELETE FROM motos WHERE matricula = ?;";
		try (Connection conexion = obtenerConexion();
				PreparedStatement declaracion = conexion.prepareStatement(consulta)) {
			declaracion.setString(1, matricula);
			// Ejecuta la consulta SQL de eliminación
			int resultado = declaracion.executeUpdate();
			if (resultado > 0) {
				System.out.println("Moto eliminada correctamente.");
			} else {
				System.out.println("No se encontró la moto a eliminar o no se pudo eliminar.");
			}
		} catch (SQLException e) {
			// Manejo de errores SQL
			System.out.println("Error al eliminar moto: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void actualizarMoto() {
		Scanner scanner = new Scanner(System.in);

		// Solicitar la matrícula de la moto a actualizar
		System.out.println("Ingrese la matrícula de la moto que desea actualizar:");
		String matricula = scanner.nextLine();

		// Mostrar opciones de lo que se puede actualizar
		System.out.println("¿Qué quieres actualizar?");
		System.out.println("1. Marca");
		System.out.println("2. Modelo");
		System.out.println("3. Año");
		System.out.println("4. Color");
		System.out.println("5. Precio");
		System.out.println("6. Tipo\n");
		System.out.print("Opción: ");
		int opcion = Integer.parseInt(scanner.nextLine());

		String campo = "";
		switch (opcion) {
		case 1:
			campo = "Marca";
			break;
		case 2:
			campo = "Modelo";
			break;
		case 3:
			campo = "Año";
			break;
		case 4:
			campo = "Color";
			break;
		case 5:
			campo = "Precio";
			break;
		case 6:
			campo = "Tipo";
			break;
		default:
			System.out.println("Opción no válida");
			return;
		}

		// Pedir el nuevo valor para el campo seleccionado
		String nuevoValor;
		if (opcion == 1) {
			System.out.println("Ingrese el nuevo valor para la " + campo + ":");
			nuevoValor = scanner.nextLine();
		} else {
			System.out.println("Ingrese el nuevo valor para el " + campo + ":");
			nuevoValor = scanner.nextLine();
		}
		// Crear la consulta SQL usando PreparedStatement para evitar inyecciones SQL
		String consulta = "UPDATE motos SET " + campo + " = ? WHERE Matricula = ?";

		try (Connection conexion = obtenerConexion();
				PreparedStatement declaracion = conexion.prepareStatement(consulta)) {

			declaracion.setString(1, nuevoValor);
			declaracion.setString(2, matricula);

			// Ejecutar la actualización
			int filasAfectadas = declaracion.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Moto actualizada correctamente.");
			} else {
				System.out.println("No se encontró una moto con esa matrícula.");
			}

		} catch (SQLException e) {
			System.out.println("Error al actualizar la moto.");
			e.printStackTrace();
		}
	}

	public static void catalogo() {
		String consulta = "SELECT * FROM motos";
		try (Connection conexion = obtenerConexion();
				Statement declaracion = conexion.createStatement();
				ResultSet resultados = declaracion.executeQuery(consulta)) {
			while (resultados.next()) {
				String matricula = resultados.getString("Matricula");
				String marca = resultados.getString("Marca");
				String modelo = resultados.getString("Modelo");
				int año = resultados.getInt("Año");
				String color = resultados.getString("Color");
				int precio = resultados.getInt("Precio");
				String tipo = resultados.getString("tipo");

				// Imprime la información de cada moto
				System.out.println("Matricula: " + matricula);
				System.out.println("Marca: " + marca);
				System.out.println("Modelo: " + modelo);
				System.out.println("Año: " + año);
				System.out.println("Color: " + color);
				System.out.println("Precio: " + precio);
				System.out.println("Tipo: " + tipo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/***************************************************************************************
	 * Menus:
	 */

	public static void menuAdmin() {
		System.out.println("-------------------------------------------------------");
		System.out.println("* Menú Administrador: \n");
		System.out.println("*Motos: ");
		System.out.println("   1. Introducir Moto");
		System.out.println("   2. Eliminar moto");
		System.out.println("   3. Buscar por marca");
		System.out.println("   4. Mostrar motos");
		System.out.println("   5. Modificar moto");
		System.out.println("*Usuarios: ");
		System.out.println("   6. Mostrar usuarios registrados");
		System.out.println("   7. Crear usuario nuevo");
		System.out.println("   8. Eliminar usuario");
		System.out.println("   9. Modificar datos usuario");
		System.out.println("10. Cerrar Sesion");
	}

	public static void menuCliente() {
		System.out.println("-------------------------------------------------------");
		System.out.println("* Menú Clientes: \n");
		System.out.println("1. Alquilar Moto");
		System.out.println("2. Comprar Moto");
		System.out.println("3. Ver catalogo");
		System.out.println("4. Mostrar mis datos");
		System.out.println("5. Cerrar Sesion");
	}

	public static void inicio() {
		System.out.println("****************************************************************************************");
		System.out
				.println("  _____ ___ _____ _   _ ____    _      __  __  ___ _____ ___  __  __    _    __  __ ___ \r\n"
						+ " |_   _|_ _| ____| \\ | |  _ \\  / \\    |  \\/  |/ _ \\_   _/ _ \\|  \\/  |  / \\  |  \\/  |_ _|\r\n"
						+ "   | |  | ||  _| |  \\| | | | |/ _ \\   | |\\/| | | | || || | | | |\\/| | / _ \\ | |\\/| || | \r\n"
						+ "   | |  | || |___| |\\  | |_| / ___ \\  | |  | | |_| || || |_| | |  | |/ ___ \\| |  | || | \r\n"
						+ "   |_| |___|_____|_| \\_|____/_/   \\_\\ |_|  |_|\\___/ |_| \\___/|_|  |_/_/   \\_\\_|  |_|___|\r\n"
						+ "                                                                                       ");
		System.out.println("****************************************************************************************");
		System.out.println("_____________                               ______________      \r\n"
				+ "___  __ )__(_)______________   ________________(_)_____  /_____ \r\n"
				+ "__  __  |_  /_  _ \\_  __ \\_ | / /  _ \\_  __ \\_  /_  __  /_  __ \\\r\n"
				+ "_  /_/ /_  / /  __/  / / /_ |/ //  __/  / / /  / / /_/ / / /_/ /\r\n"
				+ "/_____/ /_/  \\___//_/ /_/_____/ \\___//_/ /_//_/  \\__,_/  \\____/ \r\n"
				+ "                                                                ");
	}

	public static void menuInicio() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Iniciar sesión ");
		System.out.println("2. Registrarte ");
		System.out.println("3. Salir ");
	}
}



