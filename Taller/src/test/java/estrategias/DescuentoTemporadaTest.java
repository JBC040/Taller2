package estrategias;

import compras.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DescuentoTemporadaTest {
    @Test void aplicaPorcentajeAlSubtotal() {
        DescuentoTemporada descuento = new DescuentoTemporada(0.20);
        assertEquals(200, descuento.calcularDescuento(1000, new Cliente("1", "Ana")), 0.001);
    }
    @Test void rechazaPorcentajesFueraDelRango() {
        assertThrows(IllegalArgumentException.class, () -> new DescuentoTemporada(-0.1));
        assertThrows(IllegalArgumentException.class, () -> new DescuentoTemporada(1.1));
    }
}
