package estrategias;

import compras.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinDescuentoTest {
    @Test void siempreDevuelveCero() {
        SinDescuento estrategia = new SinDescuento();
        assertEquals(0, estrategia.calcularDescuento(1000, new Cliente("1", "Ana")), 0.001);
    }
}
