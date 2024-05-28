package BD;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Clases.Cliente;
import Clases.Vehiculo;

class ConexionBDTest {

	@Test
	void testCrearUsuario() {
		Cliente cliente = new Cliente("Test", "Test", "Test", "Test", "Test", 0);
		assertTrue(new ConexionBD().crearUsuario(cliente, false));
	}

	@Test
	void testModificarUsuario() {
		assertNotEquals(false, new ConexionBD().modificarUsuario("Test", "nombre", "patata"));

	}

	@Test
	void testBorrarUsuario() {
		assertTrue(new ConexionBD().borrarUsuario("Test"));
	}

	@Test
	void testCrearVehiculo() {
		Vehiculo vehiculo = new Vehiculo("Test", "Test", 5, 5, "Test", "Test", "Test");
		assertEquals(true, new ConexionBD().crearVehiculo(vehiculo));
	}

	@Test
	void testModificarVehiculo() {
		assertFalse(new ConexionBD().modificarVehiculo("Test", "patata", "rojo"));
	}

	@Test
	void testExisteVehiculo() {
		assertTrue(new ConexionBD().existeVehiculo("Test"));
	}

	@Test
	void testBorrarVehiculo() {
		assertTrue(new ConexionBD().borrarVehiculo("Test"));
	}

	@Test
	void BuscarPrecio() {
		String matricula = "ABC123";
		assertEquals(0, ConexionBD.BuscarPrecio(matricula));
	}
}
