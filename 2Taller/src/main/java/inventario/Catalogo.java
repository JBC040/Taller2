package inventario;

import modelo.Producto;
import java.util.*;
import java.util.logging.Logger;

public class Catalogo {

    private static final Logger LOG = Logger.getLogger(Catalogo.class.getName());

    private final Inventario inv;

    public Catalogo(Inventario i) {
        inv = i;
    }

    public Optional<Producto> buscar(String c) {
        return inv.buscar(c);
    }

    public List<Producto> porNombre() {
        List<Producto> l = inv.obtenerTodos();
        Collections.sort(l);
        return l;
    }

    public List<Producto> porPrecio() {
        List<Producto> l = inv.obtenerTodos();
        l.sort(new ComparadorPorPrecio());
        return l;
    }

    public List<Producto> porStock() {
        List<Producto> l = inv.obtenerTodos();
        l.sort((x, y) -> Integer.compare(x.getStock(), y.getStock()));
        return l;
    }

    public List<Producto> porCategoriaPrecio() {
        List<Producto> l = inv.obtenerTodos();
        l.sort(Comparator.comparing(Producto::getCategoria)
                .thenComparing(Producto::getPrecioConImpuesto)
                .reversed());
        LOG.info("Catálogo ordenado");
        return l;
    }
}