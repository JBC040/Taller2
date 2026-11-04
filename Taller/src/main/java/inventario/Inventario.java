package inventario;

import modelo.*;
import excepciones.*;
import java.util.*;
import java.util.logging.Logger;

public class Inventario {

    private static final Logger LOG = Logger.getLogger(Inventario.class.getName());
    private final Map<String, Producto> productos = new LinkedHashMap<>();

    public void agregar(Producto p) {
        if (productos.putIfAbsent(p.getCodigo(), p) != null)
            throw new IllegalArgumentException("Código repetido");

        LOG.info("Producto agregado " + p.getCodigo());
    }

    public Optional<Producto> buscar(String c) {
        return Optional.ofNullable(productos.get(c));
    }

    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos.values());
    }

    public void validarDisponibilidad(Producto p, int q) {
        Producto base = productos.get(p.getProductoBase().getCodigo());

        if (base == null) {
            LOG.severe("Producto no encontrado: " + p.getCodigo());
            throw new ProductoNoEncontradoException("No existe producto");
        }

        if (q <= 0 || q > base.getStock()) {
            LOG.warning("Intento de exceder stock: " + p.getCodigo());
            throw new StockInsuficienteException("Stock insuficiente");
        }

        if (base instanceof Alimento)
            ((Alimento) base).validarVigencia();
    }

    public void descontar(Producto p, int q) {
        validarDisponibilidad(p, q);
        productos.get(p.getProductoBase().getCodigo()).descontarStock(q);
        LOG.info("Stock actualizado");
    }
}