package estrategias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResumenPrecioTest {
    @Test void calculaTotalConDescuentoYEnvio() {
        ResumenPrecio resumen = new ResumenPrecio(1000, 100, 50);
        assertEquals(1000, resumen.getSubtotal(), 0.001);
        assertEquals(100, resumen.getValorDescuento(), 0.001);
        assertEquals(50, resumen.getCostoEnvio(), 0.001);
        assertEquals(950, resumen.getTotal(), 0.001);
    }
}
