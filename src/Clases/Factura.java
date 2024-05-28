package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Factura {

    private Cliente cliente;
    private static ArrayList<Vehiculo> VehiculosAlquilados = new ArrayList<>();
    private double total;
    private boolean alquilado;
    public Factura(Cliente cliente, ArrayList<Vehiculo> VehiculosAlquilados,boolean alquilado) {
        this.cliente = cliente;
        this.VehiculosAlquilados = VehiculosAlquilados;
        this.alquilado =alquilado;
        this.total = calcularTotal(VehiculosAlquilados);
        System.out.println("Total calculado en el constructor: " + this.total);
    }

    private double calcularTotal(ArrayList<Vehiculo> VehiculosAlquilados) {
        double total = 0;
        for (Vehiculo Vehiculo : VehiculosAlquilados) {
        	if (alquilado) {
        		   Vehiculo.setPrecio(((Vehiculo.getPrecio() * 0.5) / 100) * Vehiculo.getDiasAlquilados());
        		   total += Vehiculo.getPrecio();
                   System.out.println("Vehiculo: " + Vehiculo.getMarca() + " Subtotal: " + Vehiculo.getPrecio());
			}else {
				   total += Vehiculo.getPrecio() * Vehiculo.getDiasAlquilados();
		            System.out.println("Vehiculo: " + Vehiculo.getMarca() + " Subtotal: " + (Vehiculo.getPrecio() * Vehiculo.getDiasAlquilados()));
			}
         
        }
        return total;
    }

    public boolean guardarFacturaEnArchivo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fechaActual = dateFormat.format(new Date());
        if (VehiculosAlquilados.size() == 0) {
            JOptionPane.showMessageDialog(null, "Ningún vehículo ha sido seleccionado", "Error factura", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!(new File("facturas").isDirectory())) {
            new File("facturas").mkdir();
        }
        String nombreArchivo = "facturas/" + cliente.getNombre() + "_" + VehiculosAlquilados.get(0).getMatricula() + "_" + fechaActual + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(" ________ ________  ________ _________  ___  ___  ________  ________          ________  ___       ___  ________  ________  ________  ________      \r\n"
                    + "|\\  _____\\\\   __  \\|\\   ____\\\\___   ___\\\\  \\|\\  \\|\\   __  \\|\\   __  \\        |\\   ____\\|\\  \\     |\\  \\|\\   ____\\|\\   __  \\|\\   __  \\|\\   ____\\     \r\n"
                    + "\\ \\  \\__/\\ \\  \\|\\  \\ \\  \\___\\|___ \\  \\_\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\|\\  \\       \\ \\  \\___|\\ \\  \\    \\ \\  \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\___|_    \r\n"
                    + " \\ \\   __\\\\ \\   __  \\ \\  \\       \\ \\  \\ \\ \\  \\\\\\  \\ \\   _  _\\ \\   __  \\       \\ \\  \\    \\ \\  \\    \\ \\  \\ \\  \\    \\ \\   __  \\ \\   _  _\\ \\_____  \\   \r\n"
                    + "  \\ \\  \\_| \\ \\  \\ \\  \\ \\  \\____   \\ \\  \\ \\ \\  \\\\\\  \\ \\  \\\\  \\\\ \\  \\ \\  \\       \\ \\  \\____\\ \\  \\____\\ \\  \\ \\  \\____\\ \\  \\ \\  \\ \\  \\\\  \\\\|____|\\  \\  \r\n"
                    + "   \\ \\__\\   \\ \\__\\ \\__\\ \\_______\\  \\ \\__\\ \\ \\_______\\ \\__\\\\ _\\\\ \\__\\ \\__\\       \\ \\_______\\ \\_______\\ \\__\\ \\_______\\ \\__\\ \\__\\ \\__\\\\ _\\ ____\\_\\  \\ \r\n"
                    + "    \\|__|    \\|__|\\|__|\\|_______|   \\|__|  \\|_______|\\|__|\\|__|\\|__|\\|__|        \\|_______|\\|_______|\\|__|\\|_______|\\|__|\\|__|\\|__|\\|__|\\_________\\\r\n"
                    + "                                                                                                                                       \\|_________|");
            writer.write("   ___ _    ___ ___ _  _ _____ ___ \r\n"
                    + "  / __| |  |_ _| __| \\| |_   _| __|\r\n"
                    + " | (__| |__ | || _|| .` | | | | _| \r\n"
                    + "  \\___|____|___|___|_|\\_| |_| |___|\n");

            writer.write("\n\n* Nombre: " + cliente.getNombre() + "\n* Apellido: " + cliente.getApellido() + "\n* Teléfono: " + cliente.getTelefono() + "\n");
            writer.write(" __   _____ _  _ ___ ___ _   _ _    ___  ___  \r\n"
                    + " \\ \\ / / __| || |_ _/ __| | | | |  / _ \\/ __| \r\n"
                    + "  \\ V /| _|| __ || | (__| |_| | |_| (_) \\__ \\ \r\n"
                    + "   \\_/ |___|_||_|___\\___|\\___/|____\\___/|___/ \n");
            if (alquilado) {
                for (Vehiculo Vehiculo : VehiculosAlquilados) {
                    writer.write("\n* Marca: " + Vehiculo.getMarca() + "\n" +
                            "* Modelo: " + Vehiculo.getModelo() + "\n" +
                            "* Año: " + Vehiculo.getAño() + "\n" +
                            "* Días Alquilados: " + Vehiculo.getDiasAlquilados() + "\n" +
                            "* Subtotal: " +Vehiculo.getPrecio() + "€\n");
            
                }
                writer.write("=============================");
                writer.write("\nTotal a pagar: " + this.total + "€\n");
                writer.write("=============================\n");
            } else {
                for (Vehiculo Vehiculo : VehiculosAlquilados) {
                    writer.write("\n\n* Marca: " + Vehiculo.getMarca() + "\n" +
                            "* Modelo: " + Vehiculo.getModelo() + "\n" +
                            "* Año: " + Vehiculo.getAño() + "\n" +
                            "* Matrícula: " + Vehiculo.getMatricula() + "\n" +
                            "* Precio: " + Vehiculo.getPrecio() + "€\n");
       
                }
                writer.write("=============================");
                writer.write("\nTotal a pagar: " + this.total + "€\n");
                writer.write("=============================\n");
            }

            System.out.println("Factura guardada en el archivo: " + nombreArchivo);
            JOptionPane.showMessageDialog(null, "Factura Generada con éxito en: \n" + new File(nombreArchivo).getAbsolutePath(), "Facturación", JOptionPane.INFORMATION_MESSAGE);
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar la factura en el archivo: " + e.getMessage());
        }
        return false;
    }
}
