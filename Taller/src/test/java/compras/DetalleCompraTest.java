package compras;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DetalleCompraTest {
    @Test void calculaSubtotalMultiplicandoPrecioPorCantidad() {
        DetalleCompra detalle = new DetalleCompra(null, 3, 150.0);
        assertEquals(450.0, detalle.getSubtotal(), 0.001);
        assertEquals(3, detalle.getCantidad());
        assertEquals(150.0, detalle.getPrecioUnitario(), 0.001);
        assertNull(detalle.getProducto());
    }
}
