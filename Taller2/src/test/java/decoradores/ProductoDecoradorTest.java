package decoradores;

import modelo.Producto;
import modelo.Ropa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoDecoradorTest {

    static class DecoradorPrueba extends ProductoDecorador {

        public DecoradorPrueba(Producto producto) {
            super(producto);
        }

        @Override
        protected double costoExtra() {
            return 2000;
        }
    }

    @Test
    void debeAgregarCostoExtraAlProducto() {
        Producto ropa = new Ropa(
                "R001", "Camisa", 50000, 10, "M"
        );

        Producto decorado = new DecoradorPrueba(ropa);

        assertEquals(52000, decorado.getPrecioBase());
    }

    @Test
    void debeConservarElStockDelProductoOriginal() {
        Producto ropa = new Ropa(
                "R001", "Camisa", 50000, 10, "M"
        );

        Producto decorado = new DecoradorPrueba(ropa);

        assertEquals(10, decorado.getStock());
    }

    @Test
    void debePermitirDescontarStock() {
        Producto ropa = new Ropa(
                "R001", "Camisa", 50000, 10, "M"
        );

        Producto decorado = new DecoradorPrueba(ropa);
        decorado.descontarStock(3);

        assertEquals(7, ropa.getStock());
    }

    @Test
    void debeRetornarProductoBase() {
        Producto ropa = new Ropa(
                "R001", "Camisa", 50000, 10, "M"
        );

        DecoradorPrueba decorado = new DecoradorPrueba(ropa);

        assertEquals(ropa, decorado.getProductoBase());
    }
}