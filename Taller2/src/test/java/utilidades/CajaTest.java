
package utilidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CajaTest {

    private Caja<String> caja;

    @BeforeEach
    void setUp() {
        caja = new Caja<>();
    }

    @Test
    void guardarYObtenerContenido() {

        caja.guardar("Hola");

        assertEquals("Hola", caja.obtener());
    }

    @Test
    void unaCajaNuevaDebeEstarVacia() {

        assertTrue(caja.estaVacia());
    }

    @Test
    void unaCajaConContenidoNoDebeEstarVacia() {

        caja.guardar("Juan");

        assertFalse(caja.estaVacia());
    }

    @Test
    void debePermitirCambiarElContenido() {

        caja.guardar("Primero");
        caja.guardar("Segundo");

        assertEquals("Segundo", caja.obtener());
    }
}
