package estrategias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstrategiaEnvioTest {
    @Test void permiteImplementacionFuncional() {
        EstrategiaEnvio estrategia = subtotal -> subtotal >= 50000 ? 0 : 6000;
        assertEquals(6000, estrategia.calcularCosto(10000), 0.001);
        assertEquals(0, estrategia.calcularCosto(50000), 0.001);
    }
}
