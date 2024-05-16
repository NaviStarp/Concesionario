package Concesionario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Factura {

    private Cliente cliente;
    private ArrayList<Vehiculo> VehiculosAlquilados;
    private double total;

    public Factura(Cliente cliente, ArrayList<Vehiculo> VehiculosAlquilados) {
        this.cliente = cliente;
        this.VehiculosAlquilados = VehiculosAlquilados;
        this.total = calcularTotal(VehiculosAlquilados);
    }

    private double calcularTotal(ArrayList<Vehiculo> VehiculosAlquilados) {
        double total = 0;
        for (Vehiculo Vehiculo : VehiculosAlquilados) {
            total += Vehiculo.getPrecio() * Vehiculo.getDiasAlquilados();
        }
        return total;
    }

    public boolean guardarFacturaEnArchivo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fechaActual = dateFormat.format(new Date());
        String nombreArchivo = cliente.getNombre() + "_" + VehiculosAlquilados.get(0).getMatricula() + "_" + fechaActual + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("========== FACTURA ==========\n");
            writer.write("Cliente:\n");
            writer.write("Nombre: " + cliente.getNombre() + "\nApellido: " + cliente.getApellido() + "\nContraseña: " + cliente.getcontraseña() + "\nTelefono: " + cliente.getTelefono() + "\n");
            writer.write("\nVehiculos Alquilados:\n");
            for (Vehiculo Vehiculo : VehiculosAlquilados) {
                writer.write("Marca: " + Vehiculo.getMarca() + ", Modelo: " + Vehiculo.getModelo() + ", Precio por día: " + Vehiculo.getPrecio() + ", Días Alquilados: " + Vehiculo.getDiasAlquilados() + ", Subtotal: " + Vehiculo.getPrecio() * Vehiculo.getDiasAlquilados() + "\n");
            }
            writer.write("\nTotal a pagar: " + total + "\n");
            writer.write("=============================\n");
            System.out.println("Factura guardada en el archivo: " + nombreArchivo);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar la factura en el archivo: " + e.getMessage());
        }
        return false;
    }
}
