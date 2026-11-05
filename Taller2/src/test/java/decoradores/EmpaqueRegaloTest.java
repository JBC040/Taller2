package decoradores;

import modelo.Producto;
import modelo.Ropa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpaqueRegaloTest {

    @Test
    void debeAgregarCostoDeEmpaqueAlPrecioBase() {
        Producto ropa = new Ropa(
                "R001", "Camisa", 100000, 10, "M"
        );

        Producto decorado = new EmpaqueRegalo(ropa);

        assertEquals(105000, decorado.getPrecioBase());
    }

    @Test
    void debeCalcularPrecioConImpuestoYEmpaque() {
        Producto ropa = new Ropa(
                "R001", "Camisa", 100000, 10, "M"
        );

        Producto decorado = new EmpaqueRegalo(ropa);

        assertEquals(110250, decorado.getPrecioConImpuesto());
    }

    @Test
    void debeDescontarStockDelProductoOriginal() {
        Producto ropa = new Ropa(
                "R001", "Camisa", 100000, 10, "M"
        );

        Producto decorado = new EmpaqueRegalo(ropa);
        decorado.descontarStock(2);

        assertEquals(8, ropa.getStock());
    }
}