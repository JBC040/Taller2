package estrategias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnvioExpressTest {
    @Test void siempreCobraLaTarifaConfigurada() {
        EnvioExpress envio = new EnvioExpress(12000);
        assertEquals(12000, envio.calcularCosto(0), 0.001);
        assertEquals(12000, envio.calcularCosto(500000), 0.001);
    }
    @Test void rechazaTarifaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new EnvioExpress(-1));
    }
}
