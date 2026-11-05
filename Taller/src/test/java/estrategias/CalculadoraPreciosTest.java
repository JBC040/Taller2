package estrategias;

import compras.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraPreciosTest {
    @Test void calculaSubtotalDescuentoEnvioYTotal() {
        CalculadoraPrecios calculadora = new CalculadoraPrecios(() -> new EnvioEstandar(5000, 100000));
        ResumenPrecio resultado = calculadora.calcular(50000, (s, c) -> s * 0.10,
                new EnvioExpress(7000), new Cliente("1", "Ana"));
        assertEquals(50000, resultado.getSubtotal(), 0.001);
        assertEquals(5000, resultado.getValorDescuento(), 0.001);
        assertEquals(7000, resultado.getCostoEnvio(), 0.001);
        assertEquals(52000, resultado.getTotal(), 0.001);
    }

    @Test void usaEnvioPredeterminadoCuandoLaEstrategiaEsNula() {
        CalculadoraPrecios calculadora = new CalculadoraPrecios(() -> new EnvioExpress(3000));
        ResumenPrecio resultado = calculadora.calcular(10000, new SinDescuento(), null,
                new Cliente("1", "Ana"));
        assertEquals(3000, resultado.getCostoEnvio(), 0.001);
    }

    @Test void rechazaSubtotalNegativoYDescuentoInvalido() {
        CalculadoraPrecios calculadora = new CalculadoraPrecios(() -> new EnvioExpress(0));
        Cliente cliente = new Cliente("1", "Ana");
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcular(-1, new SinDescuento(), null, cliente));
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcular(100, (s, c) -> 101, null, cliente));
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcular(100, (s, c) -> -1, null, cliente));
    }
}
