package tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Motos> motos = new ArrayList<Motos>();

        /************************************************************
         * Agrego motos a la tienda para empezar */
        motos.add(new Motos("Honda", "CBR500R", 2022, 5000, "Rojo", "1234 AHC"));
        motos.add(new Motos("Yamaha", "YZF-R6", 2023, 6000, "Negro", "564 XYZ"));
        motos.add(new Motos("Suzuki", "GSX-R750", 2021, 4500, "Azul", "243 DEF"));
        motos.add(new Motos("Kawasaki", "Ninja H2-R", 2020, 5500, "Verde", "345 GHI"));
        motos.add(new Motos("Ducati", "Panigale V4", 2019, 7000, "Rojo", "334 JKL"));

        boolean finalizarPrograma = false;
        do {
            finalizarPrograma = IniciarSesion(motos);
        } while (!finalizarPrograma);
    }
    
    /****************************************************************
     * Menu y opciones Administrador */
    
    public static void menuAdmin() {
        System.out.println("* Menú Administrador: \n");
        System.out.println("1. Introducir Moto");
        System.out.println("2. Eliminar moto");
        System.out.println("3. Buscar por marca");
        System.out.println("4. Mostrar motos");
        System.out.println("5. Modificar moto");
        System.out.println("6. Mostrar mis datos");
        System.out.println("7. Cerrar Sesion");
    }

    public static void opcionesAdmin(ArrayList<Motos> motos,  Administrador admin) {
        do {
            menuAdmin();
            Scanner sc = new Scanner(System.in);
            System.out.println("* Introduce una opcion: ");
            char opcA = sc.next().charAt(0);
            switch (opcA) {
                case '1':
                    introducirMoto(motos);                   
                    break;
                case '2':
                    eliminarMoto(motos);
                    break;
                case '3':
                    buscarPorMarca(motos);
                    break;
                case '4':
                    mostrarMotosDisponibles(motos);
                    break;
                case '5':
                    modificarMoto(motos);
                    break;
                case '6':
                	admin.MostrarInfoCliente();
                    break;
                case '7':
                    return;
                default:
                    System.out.println("Respuesta incorrecta, vuelve a introducir la opción ");
            }
        } while (true);
    }

    /****************************************************************
     * Menu y opciones Cliente */
    
    public static void menuCliente() {
        System.out.println("* Menú Clientes: \n");
        System.out.println("1. Alquilar Moto");
        System.out.println("2. Comprar Moto");
        System.out.println("3. Ver catalogo");
        System.out.println("4. Mostrar mis datos");
        System.out.println("5. Cerrar Sesion");
    }

    public static void opcionesCliente(ClienteN cliente, ArrayList<Motos> motos) {
        do {
            menuCliente();
            Scanner sc = new Scanner(System.in);
            System.out.println("* Introduce una opcion: ");
            char opcA = sc.next().charAt(0);
            switch (opcA) {
                case '1':
                    alquilarMoto(motos);
                    break;
                case '2':
                    comprarMoto(motos);
                    break;
                case '3':
                    mostrarMotosDisponibles(motos);
                    break;
                case '4':
                    cliente.MostrarInfoCliente();
                    break;
                case '5':
                    return;
                default:
                    System.out.println("");
            }
        } while (true);
    }

    /****************************************************************
     * Mostrar todas las motos disponibles */
    
    public static void mostrarMotosDisponibles(ArrayList<Motos> motos) {
        System.out.println("Motos disponibles para alquilar/comprar: \n");
        for (int i = 0; i < motos.size(); i++) {
            Motos moto = motos.get(i);
            System.out.println("Matrícula: " + moto.getMatricula());
            System.out.println("Marca: " + moto.getMarca());
            System.out.println("Modelo: " + moto.getModelo());
            System.out.println("Año: " + moto.getAño());
            System.out.println("Precio: " + moto.getPrecio() + "€");
            System.out.println("Color: " + moto.getColor());
            System.out.println("-----------------------------");
        }
    }
    
    /****************************************************************
     * Alquilar moto */
    
    public static void alquilarMoto(ArrayList<Motos> motos) {
        mostrarMotosDisponibles(motos);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese la matrícula de la moto que desea alquilar (o escriba 'salir' para salir al menu):");
            String opcion = scanner.nextLine();

            if (opcion.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo al menú...");
                break;
            }

            boolean encontrado = false;
            for (Motos moto : motos) {
                if (opcion.equalsIgnoreCase(moto.getMatricula())) {
                    if (moto.isAlquilada()) {
                        System.out.println("La moto no está disponible. Ya sido alquilada por " + moto.getDiasAlquilados() + " días.");
                        encontrado = true;
                        break;
                    }

                    System.out.println("Ha seleccionado alquilar la moto:");
                    System.out.println("Matrícula: " + moto.getMatricula());
                    System.out.println("Marca: " + moto.getMarca());
                    System.out.println("Modelo: " + moto.getModelo());
                    System.out.println("Año: " + moto.getAño());
                    System.out.println("Precio: " + moto.getPrecio() + "€");
                    System.out.println("Color: " + moto.getColor());
                    if(moto.getDiasAlquilados() > 0) {
                        System.out.println("Alquilada ya por: " + moto.getDiasAlquilados());
                    }

                    // Calcular el precio total del alquiler
                    int precioPorDia = 15; // Precio base por día
                    long diasAlquiler;

                    System.out.println("¿Cuántos días quieres alquilar la moto?");
                    diasAlquiler = scanner.nextLong();

                    if (diasAlquiler <= 0) {
                        System.out.println("Por favor, ingrese un número válido de días.");
                        break;
                    }

                    moto.setAlquilada(true);
                    moto.setDiasAlquilados(diasAlquiler);

                    double precioTotal = precioPorDia * diasAlquiler;
                    System.out.println("Precio total del alquiler por " + diasAlquiler + " días: " + precioTotal + "€");

                    // Preguntar si el usuario está seguro de alquilar la moto
                    System.out.println("¿Estás seguro de que quieres alquilar esta moto? (Si/No)");
                    scanner.nextLine(); // Limpiar el búfer
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("Si")) {
                        System.out.println("¡Excelente elección! ¡Disfruta tu moto nueva!");
                    } else {
                        System.out.println("Operación cancelada.");
                        // Revertir el estado de la moto si el usuario cancela
                        moto.setAlquilada(false);
                        moto.setDiasAlquilados(0);
                    }
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Matrícula no válida. Por favor, ingrese una matrícula existente o 'salir' para salir al menu.");
            }
        }
    }

    /****************************************************************
     * Comprar Moto */
    
    public static void comprarMoto(ArrayList<Motos> motos) {
        mostrarMotosDisponibles(motos);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese la matrícula de la moto que desea comprar (o escriba 'salir' para salir al menu):");
            String opcion = scanner.nextLine();

            if (opcion.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo al menu...");
                break;
            }

            boolean encontrado = false;
            for (int i = 0; i < motos.size(); i++) {
                Motos moto = motos.get(i);
                if (opcion.equalsIgnoreCase(moto.getMatricula())) {
                    if (moto.setComprada()) {
                        System.out.println("La moto ya ha sido comprada.");
                        motos.remove(i); // Eliminar la moto de la lista
                        System.out.println("Moto eliminada de la lista de motos disponibles.");
                        encontrado = true;
                        break;
                    }

                    System.out.println("Ha seleccionado comprar la moto:");
                    System.out.println("Matrícula: " + moto.getMatricula());
                    System.out.println("Marca: " + moto.getMarca());
                    System.out.println("Modelo: " + moto.getModelo());
                    System.out.println("Año: " + moto.getAño());
                    System.out.println("Precio: " + moto.getPrecio() + "€");
                    System.out.println("Color: " + moto.getColor());

                    // Preguntar si el usuario está seguro de comprar la moto
                    System.out.println("¿Estás seguro de que quieres comprar esta moto? (Si/No)");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("Si")) {
                        System.out.println("¡Felicidades! Has comprado la moto.");
                        moto.setComprada(true);
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Matrícula no válida. Por favor, ingrese una matrícula existente o 'salir' para salir al menu.");
            }
        }
    }

    /****************************************************************
     * Introducir moto */
    
    public static void introducirMoto(ArrayList<Motos> motos) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introducir nueva moto:");
        
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        
        System.out.println("Modelo: ");
        String modelo = scanner.nextLine();
        
        System.out.println("Año: ");
        int año = scanner.nextInt();
        
        System.out.println("Precio: ");
        double precio = scanner.nextDouble();
        
        scanner.nextLine(); // Consumir el salto de línea
        
        System.out.println("Color: ");
        String color = scanner.nextLine();
        
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        
        // Crear la nueva moto y añadirla a la lista
        motos.add(new Motos(marca, modelo, año, precio, color, matricula));
        System.out.println("Nueva moto añadida con éxito.");
    }

    /****************************************************************
     * Buscar moto por marca */
    
    public static void buscarPorMarca(ArrayList<Motos> motos) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce la marca de la moto que deseas buscar:");
        String marcaBuscada = scanner.nextLine();
        
        boolean encontrada = false;
        for (Motos moto : motos) {
            if (moto.getMarca().equalsIgnoreCase(marcaBuscada)) {
                System.out.println("Moto encontrada:");
                System.out.println("Matrícula: " + moto.getMatricula());
                System.out.println("Marca: " + moto.getMarca());
                System.out.println("Modelo: " + moto.getModelo());
                System.out.println("Año: " + moto.getAño());
                System.out.println("Precio: " + moto.getPrecio() + "€");
                System.out.println("Color: " + moto.getColor());
                System.out.println("-----------------------------");
                encontrada = true;
            }
        }
        
        if (!encontrada) {
            System.out.println("No se encontró ninguna moto de la marca especificada.");
        }
    }


    /****************************************************************
     * Modificar atributo moto */
    
    public static void modificarMoto(ArrayList<Motos> motos) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce la matrícula de la moto que deseas modificar:");
        String matriculaModificar = scanner.nextLine();
        
        boolean encontrada = false;
        for (Motos moto : motos) {
            if (moto.getMatricula().equalsIgnoreCase(matriculaModificar)) {
                System.out.println("¿Qué deseas modificar de la moto?");
                System.out.println("1. Marca");
                System.out.println("2. Modelo");
                System.out.println("3. Año");
                System.out.println("4. Precio");
                System.out.println("5. Color");
                
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce la nueva marca:");
                        String nuevaMarca = scanner.nextLine();
                        moto.setMarca(nuevaMarca);
                        System.out.println("Marca modificada correctamente.");
                        break;
                    case 2:
                        System.out.println("Introduce el nuevo modelo:");
                        String nuevoModelo = scanner.nextLine();
                        moto.setModelo(nuevoModelo);
                        System.out.println("Modelo modificado correctamente.");
                        break;
                    case 3:
                        System.out.println("Introduce el nuevo año:");
                        int nuevoAño = scanner.nextInt();
                        moto.setAño(nuevoAño);
                        System.out.println("Año modificado correctamente.");
                        break;
                    case 4:
                        System.out.println("Introduce el nuevo precio:");
                        double nuevoPrecio = scanner.nextDouble();
                        moto.setPrecio(nuevoPrecio);
                        System.out.println("Precio modificado correctamente.");
                        break;
                    case 5:
                        System.out.println("Introduce el nuevo color:");
                        String nuevoColor = scanner.nextLine();
                        moto.setColor(nuevoColor);
                        System.out.println("Color modificado correctamente.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                
                encontrada = true;
                break;
            }
        }
        
        if (!encontrada) {
            System.out.println("No se encontró ninguna moto con esa matrícula.");
        }
    }
    
    /****************************************************************
     * Eliminar moto */
    
    public static void eliminarMoto(ArrayList<Motos> motos) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce la matrícula de la moto que deseas eliminar:");
        String matriculaEliminar = scanner.nextLine();
        
        boolean eliminada = false;
        for (int i = 0; i < motos.size(); i++) {
            Motos moto = motos.get(i);
            if (moto.getMatricula().equalsIgnoreCase(matriculaEliminar)) {
                motos.remove(i);
                System.out.println("Moto eliminada correctamente.");
                eliminada = true;
                break;
            }
        }
        
        if (!eliminada) {
            System.out.println("No se encontró ninguna moto con esa matrícula.");
        }
    }
    
    /****************************************************************
     *  Metodos Iniciar sesion del Admin y Cliente */
    
    public static boolean IniciarSesion(ArrayList<Motos> motos) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Iniciar Sesión: \n");
            System.out.println("1. Administrador");
            System.out.println("2. Usuario Nuevo");
            System.out.println("3. Salir");

            char opcion = sc.next().charAt(0);

            switch (opcion) {
                case '1':
                    if (!SAdministrador()) {
                        System.out.println("Sesión iniciada como administrador.");
                        // Crear una instancia de Administrador
                        Administrador admin = new Administrador("nombre", "apellido", 123456789, "ID");
                        opcionesAdmin(motos, admin); // Pasar la instancia de Administrador como argumento
                    }
                    break;
                case '2':
                    // Crear una instancia de ClienteN
                    ClienteN cliente = usuarioNuevo();
                    System.out.println("Sesión iniciada como usuario.");
                    opcionesCliente(cliente, motos); // Pasar la instancia de ClienteN como argumento
                    break;
                case '3':
                    System.out.println("Finalizando programa....");
                    return true; // Finaliza el programa
                default:
                    System.out.println("Opción no válida.");
            }
        } while (true);
    }


    /*******************************************************************/
    
    public static boolean SAdministrador() {
        Scanner sc = new Scanner(System.in);
        String Usuario = "Admin";
        String Contraseña = "Admin";

        System.out.println("Usuario: ");
        Usuario = sc.nextLine();

        System.out.println("Contraseña: ");
        Contraseña = sc.nextLine();
        if (Usuario.equals("Admin") && Contraseña.equals("Admin")) {
            System.out.println("Bienvenido Administrador");
            return false;
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
        return true;
    }

    
    /*******************************************************************/
    
    public static ClienteN usuarioNuevo() {
        Scanner sc = new Scanner(System.in);
        ClienteN c = new ClienteN();
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Apelllido: ");
        String apelllido = sc.nextLine();
        System.out.println("Telefono: ");
        long telefono = sc.nextLong();
        sc.nextLine();
        System.out.println("Año que te sacaste el carnet: ");
        int año = (int) sc.nextDouble();
        sc.nextLine(); // Consumir el salto de línea
        System.out.println("DNI: ");
        String dni = sc.nextLine();

        return new ClienteN(nombre, apelllido, telefono, dni, año);
    }
    
    /*******************************************************************/



}