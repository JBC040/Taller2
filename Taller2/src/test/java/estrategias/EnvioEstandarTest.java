package estrategias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnvioEstandarTest {
    @Test void cobraTarifaDebajoDelMinimoYEsGratisAlAlcanzarlo() {
        EnvioEstandar envio = new EnvioEstandar(8000, 100000);
        assertEquals(8000, envio.calcularCosto(99999), 0.001);
        assertEquals(0, envio.calcularCosto(100000), 0.001);
        assertEquals(0, envio.calcularCosto(120000), 0.001);
    }
    @Test void rechazaValoresNegativos() {
        assertThrows(IllegalArgumentException.class, () -> new EnvioEstandar(-1, 100));
        assertThrows(IllegalArgumentException.class, () -> new EnvioEstandar(100, -1));
    }
}
