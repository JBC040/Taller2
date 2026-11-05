package compras;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompraTest {
    @Test void conservaDatosYExponeDetallesNoModificables() {
        Compra compra = new Compra("C-001", null, new ArrayList<>(), 500, 50, 20, 470);
        assertEquals("C-001", compra.getCodigo());
        assertNull(compra.getCliente());
        assertTrue(compra.getDetalles().isEmpty());
        assertEquals(500, compra.getSubtotal(), 0.001);
        assertEquals(50, compra.getDescuento(), 0.001);
        assertEquals(20, compra.getEnvio(), 0.001);
        assertEquals(470, compra.getTotal(), 0.001);
        assertNotNull(compra.getFecha());
        assertThrows(UnsupportedOperationException.class, () -> compra.getDetalles().add(null));
    }
}
