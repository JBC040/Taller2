package servicios;

import compras.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GestorReportes {

    private static final Logger LOG = Logger.getLogger(GestorReportes.class.getName());

    public static class ReporteProducto {

        private final String codigo;
        private final String nombre;
        private final int unidades;
        private final double ingresos;

        public ReporteProducto(String c, String n, int u, double i) {
            codigo = c;
            nombre = n;
            unidades = u;
            ingresos = i;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public int getUnidadesVendidas() {
            return unidades;
        }

        public double getIngresos() {
            return ingresos;
        }

        @Override
        public String toString() {
            return nombre + " - unidades: " + unidades
                    + ", ingresos: $" + String.format("%.2f", ingresos);
        }
    }

    public static class ReporteCategoria {

        private final String categoria;
        private final int unidades;
        private final double ventas;

        public ReporteCategoria(String c, int u, double v) {
            categoria = c;
            unidades = u;
            ventas = v;
        }

        public String getCategoria() {
            return categoria;
        }

        public int getUnidadesVendidas() {
            return unidades;
        }

        public double getVentas() {
            return ventas;
        }

        @Override
        public String toString() {
            return categoria + " - unidades: " + unidades
                    + ", ventas: $" + String.format("%.2f", ventas);
        }
    }

    public List<ReporteProducto> productosMasVendidos(Collection<Compra> compras) {

        Map<String, List<DetalleCompra>> m = compras.stream()
                .flatMap(c -> c.getDetalles().stream())
                .collect(Collectors.groupingBy(
                        d -> d.getProducto().getCodigo()
                ));

        List<ReporteProducto> r = new ArrayList<>();

        m.forEach((id, ds) -> {

            int u = ds.stream()
                    .mapToInt(DetalleCompra::getCantidad)
                    .sum();

            double v = ds.stream()
                    .mapToDouble(DetalleCompra::getSubtotal)
                    .sum();

            r.add(new ReporteProducto(
                    id,
                    ds.get(0).getProducto().getNombre(),
                    u,
                    v
            ));
        });

        r.sort(
                Comparator.comparingInt(ReporteProducto::getUnidadesVendidas)
                        .thenComparingDouble(ReporteProducto::getIngresos)
                        .reversed()
        );

        LOG.info("Reporte de productos generado");

        return r;
    }

    public List<ReporteCategoria> ventasPorCategoria(Collection<Compra> compras) {

        Map<String, List<DetalleCompra>> m = compras.stream()
                .flatMap(c -> c.getDetalles().stream())
                .collect(Collectors.groupingBy(
                        d -> d.getProducto().getCategoria().name(),
                        TreeMap::new,
                        Collectors.toList()
                ));

        List<ReporteCategoria> r = new ArrayList<>();

        m.forEach((cat, ds) -> {

            r.add(new ReporteCategoria(
                    cat,
                    ds.stream()
                            .mapToInt(DetalleCompra::getCantidad)
                            .sum(),
                    ds.stream()
                            .mapToDouble(DetalleCompra::getSubtotal)
                            .sum()
            ));
        });

        LOG.info("Reporte por categoría generado");

        return r;
    }

    public double totalVendido(Collection<Compra> compras) {
        return compras.stream()
                .mapToDouble(Compra::getTotal)
                .sum();
    }
}