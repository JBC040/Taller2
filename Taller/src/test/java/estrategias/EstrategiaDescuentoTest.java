package estrategias;

import compras.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstrategiaDescuentoTest {
    @Test void permiteImplementacionFuncional() {
        EstrategiaDescuento estrategia = (subtotal, cliente) -> subtotal * 0.15;
        assertEquals(150, estrategia.calcularDescuento(1000, new Cliente("1", "Ana")), 0.001);
    }
}
