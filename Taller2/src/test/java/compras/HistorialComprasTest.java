package compras;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HistorialComprasTest {
    @Test void registraComprasYDevuelveUnaCopiaDeLaLista() {
        HistorialCompras historial = new HistorialCompras();
        Compra compra = new Compra("C-001", null, List.of(), 100, 0, 10, 110);
        historial.registrar(compra);
        assertEquals(1, historial.obtenerTodas().size());
        assertSame(compra, historial.obtenerTodas().get(0));
        assertThrows(UnsupportedOperationException.class, () -> historial.obtenerTodas().clear());
    }

    @Test void noPermiteRegistrarCompraNula() {
        HistorialCompras historial = new HistorialCompras();
        assertThrows(NullPointerException.class, () -> historial.registrar(null));
    }
}
