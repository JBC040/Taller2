package main;

import modelo.*;
import inventario.*;
import compras.*;
import decoradores.*;
import estrategias.*;
import servicios.*;
import utilidades.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       TIENDA EN LINEA");
        System.out.println("==================================");

        // 1. CREAR PRODUCTOS

        Tecnologia computador = new Tecnologia(
                "T01", "Portatil Lenovo", 2500000, 10, "Lenovo");

        Ropa camisa = new Ropa(
                "R01", "Camisa EIA", 80000, 20, "M");

        Alimento alimento = new Alimento(
                "A01", "Galletas", 5000, 30,
                LocalDate.now().plusDays(30));

        System.out.println("\n--- PRODUCTOS ---");
        System.out.println(computador);
        System.out.println(camisa);
        System.out.println(alimento);


        // 2. INVENTARIO

        Inventario inventario = new Inventario();

        inventario.agregar(computador);
        inventario.agregar(camisa);
        inventario.agregar(alimento);

        System.out.println("\n--- INVENTARIO ---");

        for (Producto p : inventario.obtenerTodos()) {
            System.out.println(p);
        }


        // 3. CATALOGO Y ORDENAMIENTO

        Catalogo catalogo = new Catalogo(inventario);

        System.out.println("\n--- PRODUCTOS ORDENADOS POR PRECIO ---");

        for (Producto p : catalogo.porPrecio()) {
            System.out.println(p);
        }

        System.out.println("\n--- BUSCAR PRODUCTO ---");

        catalogo.buscar("T01").ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Producto no encontrado")
        );


        // 4. DECORATOR

        Producto computadorDecorado = new EmpaqueRegalo(computador);
        computadorDecorado = new GarantiaExtendida(computadorDecorado);

        System.out.println("\n--- DECORATOR ---");

        System.out.println("Producto original: " + computador.getPrecioBase());

        System.out.println("Producto con extras: "
                + computadorDecorado.getPrecioBase());


        // 5. CLIENTE Y ESTRATEGIAS

        Cliente cliente = new Cliente("123", "Juanes");

        HistorialCompras historial = new HistorialCompras();

        CalculadoraPrecios calculadora = new CalculadoraPrecios(
                () -> new EnvioEstandar(12000, 200000)
        );

        EstrategiaDescuento descuento = new DescuentoTemporada(0.10);

        EstrategiaEnvio envio = new EnvioExpress(15000);


        // 6. CARRITO

        Carrito carrito = new Carrito(
                cliente,
                inventario,
                calculadora,
                historial
        );

        carrito.agregarProducto(computadorDecorado, 1);
        carrito.agregarProducto(camisa, 2);
        carrito.agregarProducto(alimento, 3);

        System.out.println("\n--- CARRITO ---");

        for (ItemCarrito item : carrito.getItems()) {
            System.out.println(
                    item.getProducto().getNombre()
                            + " | Cantidad: " + item.getCantidad()
            );
        }


        // 7. CONFIRMAR COMPRA

        System.out.println("\n--- CONFIRMACION DE COMPRA ---");

        Compra compra = carrito.confirmarCompra(
                descuento,
                envio,
                "C001"
        );

        System.out.println("Codigo: " + compra.getCodigo());
        System.out.println("Cliente: " + compra.getCliente().getNombre());
        System.out.println("Subtotal: $" + compra.getSubtotal());
        System.out.println("Descuento: $" + compra.getDescuento());
        System.out.println("Envio: $" + compra.getEnvio());
        System.out.println("TOTAL: $" + compra.getTotal());


        // 8. VERIFICAR INVENTARIO

        System.out.println("\n--- INVENTARIO DESPUES DE LA COMPRA ---");

        for (Producto p : inventario.obtenerTodos()) {
            System.out.println(
                    p.getNombre() + " | Stock: " + p.getStock()
            );
        }


        // 9. HISTORIAL

        System.out.println("\n--- HISTORIAL DE COMPRAS ---");

        for (Compra c : historial.obtenerTodas()) {
            System.out.println(
                    c.getCodigo() + " | Total: $" + c.getTotal()
            );
        }


        // 10. REPORTES

        GestorReportes gestor = new GestorReportes();

        System.out.println("\n--- PRODUCTOS MAS VENDIDOS ---");

        for (GestorReportes.ReporteProducto r :
                gestor.productosMasVendidos(historial.obtenerTodas())) {

            System.out.println(r);
        }

        System.out.println("\n--- VENTAS POR CATEGORIA ---");

        for (GestorReportes.ReporteCategoria r :
                gestor.ventasPorCategoria(historial.obtenerTodas())) {

            System.out.println(r);
        }

        System.out.println("\nTotal vendido: $"
                + gestor.totalVendido(historial.obtenerTodas()));


        // 11. UTILIDADES GENERICAS

        System.out.println("\n--- UTILIDADES GENERICAS ---");

        System.out.println("Cantidad de productos: "
                + UtilidadesGenericas.contarElementos(
                inventario.obtenerTodos()
        ));

        List<Producto> productosEconomicos =
                UtilidadesGenericas.filtrarElementos(
                        inventario.obtenerTodos(),
                        p -> p.getPrecioBase() < 100000
                );

        System.out.println("Productos economicos:");

        for (Producto p : productosEconomicos) {
            System.out.println(p.getNombre());
        }


        // 12. REPOSITORIO Y CAJA

        System.out.println("\n--- REPOSITORIO ---");

        Repositorio<Producto> repositorio = new Repositorio<>();

        repositorio.agregar(computador);
        repositorio.agregar(camisa);
        repositorio.agregar(alimento);

        repositorio.buscar(
                p -> p.getNombre().equals("Camisa EIA")
        ).ifPresent(System.out::println);

        Caja<Compra> caja = new Caja<>();

        caja.guardar(compra);

        System.out.println("\nCompra guardada en caja: "
                + !caja.estaVacia());

        System.out.println("\n==================================");
        System.out.println("       FIN DE LA EJECUCION");
        System.out.println("==================================");
    }
}

