package compras;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemCarritoTest {
    @Test void rechazaProductoNuloOCantidadNoPositiva() {
        assertThrows(IllegalArgumentException.class, () -> new ItemCarrito(null, 1));
        assertThrows(IllegalArgumentException.class, () -> new ItemCarrito(null, 0));
    }
}
