
package servicios;

import compras.*;
import modelo.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GestorReportesTest {

    private static class ProductoPrueba extends Producto {

        public ProductoPrueba(String codigo, String nombre,
                              Categoria categoria, double precio, int stock) {
            super(codigo, nombre, categoria, precio, stock);
        }
    }

    @Test
    void probarProductosMasVendidos() {

        Producto camisa = new ProductoPrueba(
                "P01", "Camisa", Categoria.ROPA, 100, 50);

        Producto celular = new ProductoPrueba(
                "P02", "Celular", Categoria.TECNOLOGIA, 300, 50);

        Producto alimento = new ProductoPrueba(
                "P03", "Alimento", Categoria.ALIMENTO, 50, 50);

        List<DetalleCompra> detalles1 = Arrays.asList(
                new DetalleCompra(camisa, 2, 100),
                new DetalleCompra(celular, 2, 300)
        );

        List<DetalleCompra> detalles2 = Arrays.asList(
                new DetalleCompra(camisa, 3, 100),
                new DetalleCompra(alimento, 2, 50)
        );

        Compra compra1 = new Compra(
                "C01", null, detalles1, 800, 0, 0, 800);

        Compra compra2 = new Compra(
                "C02", null, detalles2, 400, 0, 0, 400);

        List<Compra> compras = Arrays.asList(compra1, compra2);

        GestorReportes gestor = new GestorReportes();

        List<GestorReportes.ReporteProducto> resultado =
                gestor.productosMasVendidos(compras);

        assertEquals(3, resultado.size());
        assertEquals("Camisa", resultado.get(0).getNombre());
        assertEquals(5, resultado.get(0).getUnidadesVendidas());
        assertEquals(500, resultado.get(0).getIngresos());


        assertEquals("Celular", resultado.get(1).getNombre());
        assertEquals("Alimento", resultado.get(2).getNombre());
    }

    @Test
    void probarVentasPorCategoria() {

        Producto camisa = new ProductoPrueba(
                "P01", "Camisa", Categoria.ROPA, 100, 50);

        Producto celular = new ProductoPrueba(
                "P02", "Celular", Categoria.TECNOLOGIA, 300, 50);

        Producto alimento = new ProductoPrueba(
                "P03", "Alimento", Categoria.ALIMENTO, 50, 50);

        List<DetalleCompra> detalles = Arrays.asList(
                new DetalleCompra(camisa, 2, 100),
                new DetalleCompra(celular, 2, 300),
                new DetalleCompra(alimento, 2, 50)
        );

        Compra compra = new Compra(
                "C01", null, detalles, 900, 0, 0, 900);

        GestorReportes gestor = new GestorReportes();

        List<GestorReportes.ReporteCategoria> resultado =
                gestor.ventasPorCategoria(
                        Collections.singletonList(compra));

        assertEquals(3, resultado.size());


        assertEquals("ALIMENTO", resultado.get(0).getCategoria());
        assertEquals(2, resultado.get(0).getUnidadesVendidas());
        assertEquals(100, resultado.get(0).getVentas());

        assertEquals("ROPA", resultado.get(1).getCategoria());
        assertEquals(2, resultado.get(1).getUnidadesVendidas());
        assertEquals(200, resultado.get(1).getVentas());

        assertEquals("TECNOLOGIA", resultado.get(2).getCategoria());
        assertEquals(2, resultado.get(2).getUnidadesVendidas());
        assertEquals(600, resultado.get(2).getVentas());
    }

    @Test
    void probarTotalVendido() {

        Compra compra1 = new Compra(
                "C01", null, Collections.emptyList(),
                100, 0, 0, 100);

        Compra compra2 = new Compra(
                "C02", null, Collections.emptyList(),
                200, 0, 0, 200);

        Compra compra3 = new Compra(
                "C03", null, Collections.emptyList(),
                150, 0, 0, 150);

        List<Compra> compras = Arrays.asList(
                compra1, compra2, compra3);

        GestorReportes gestor = new GestorReportes();

        double resultado = gestor.totalVendido(compras);

        assertEquals(450, resultado);
    }

    @Test
    void probarTotalVendidoSinCompras() {

        GestorReportes gestor = new GestorReportes();

        double resultado = gestor.totalVendido(
                Collections.emptyList());

        assertEquals(0, resultado);
    }
}
