package compras;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test void creaClienteConDatosValidos() {
        Cliente cliente = new Cliente("123", "Ana");
        assertEquals("123", cliente.getIdentificacion());
        assertEquals("Ana", cliente.getNombre());
        assertEquals(0, cliente.getComprasRealizadas());
        assertFalse(cliente.esFrecuente());
    }

    @Test void rechazaDatosNulosOVacios() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente(null, "Ana"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("123", " "));
    }

    @Test void seConvierteEnFrecuenteAlRegistrarCincoCompras() {
        Cliente cliente = new Cliente("123", "Ana");
        for (int i = 0; i < 5; i++) cliente.registrarCompra();
        assertEquals(5, cliente.getComprasRealizadas());
        assertTrue(cliente.esFrecuente());
    }
}
