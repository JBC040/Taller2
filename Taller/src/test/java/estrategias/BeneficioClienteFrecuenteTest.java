package estrategias;

import compras.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BeneficioClienteFrecuenteTest {
    @Test void soloAplicaDescuentoAClientesFrecuentes() {
        BeneficioClienteFrecuente beneficio = new BeneficioClienteFrecuente(0.10);
        Cliente cliente = new Cliente("1", "Ana");
        assertEquals(0, beneficio.calcularDescuento(1000, cliente), 0.001);
        for (int i = 0; i < 5; i++) cliente.registrarCompra();
        assertEquals(100, beneficio.calcularDescuento(1000, cliente), 0.001);
    }
    @Test void rechazaPorcentajeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new BeneficioClienteFrecuente(-0.1));
        assertThrows(IllegalArgumentException.class, () -> new BeneficioClienteFrecuente(1.1));
    }
}
