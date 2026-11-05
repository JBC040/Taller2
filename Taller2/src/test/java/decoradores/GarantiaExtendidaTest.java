package decoradores;

import modelo.Producto;
import modelo.Tecnologia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarantiaExtendidaTest {

    @Test
    void debeAgregarCostoDeGarantiaAlPrecioBase() {
        Producto tecnologia = new Tecnologia(
                "T001", "Portatil", 1000000, 5, "HP"
        );

        Producto decorado = new GarantiaExtendida(tecnologia);

        assertEquals(1012000, decorado.getPrecioBase());
    }

    @Test
    void debeCalcularPrecioConImpuestoYGarantia() {
        Producto tecnologia = new Tecnologia(
                "T001", "Portatil", 1000000, 5, "HP"
        );

        Producto decorado = new GarantiaExtendida(tecnologia);

        assertEquals(1204280, decorado.getPrecioConImpuesto());
    }

    @Test
    void debeDescontarStockDelProductoOriginal() {
        Producto tecnologia = new Tecnologia(
                "T001", "Portatil", 1000000, 5, "HP"
        );

        Producto decorado = new GarantiaExtendida(tecnologia);
        decorado.descontarStock(2);

        assertEquals(3, tecnologia.getStock());
    }
}