package compras;
import modelo.Producto;
import inventario.Inventario;
import estrategias.*;
import excepciones.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
public class Carrito {
    private static final Logger LOG = Logger.getLogger(Carrito.class.getName());
    private final Cliente cliente;
    private final Inventario inventario;
    private final CalculadoraPrecios calculadora;
    private final HistorialCompras historial;
    private final List<ItemCarrito> items = new ArrayList<>();
    public Carrito(Cliente c, Inventario i, CalculadoraPrecios cp, HistorialCompras h) {
        cliente = c;
        inventario = i;
        calculadora = cp;
        historial = h;
    }
    public List<ItemCarrito> getItems() {
        return new ArrayList<>(items);
    }
    public void agregarProducto(Producto p, int q) {
        inventario.validarDisponibilidad(p, q);
        int ya = items.stream().filter(x -> x.getProducto().getCodigo().equals(p.getCodigo())).mapToInt(ItemCarrito:: getCantidad).sum();
        if (ya + q> p.getStock()) throw new StockInsuficienteException("El carrito supera el stock");
        items.add(new ItemCarrito(p, q));
        LOG.info("Agregado al carrito");
    }
    public void quitarProducto(String codigo) {
        if (!items.removeIf(x -> x.getProducto().getCodigo().equals(codigo))) throw new ProductoNoEncontradoException("No está en carrito");
    }
    public Compra confirmarCompra(EstrategiaDescuento d, EstrategiaEnvio e, String codigo) {
        if (items.isEmpty()) throw new IllegalStateException("Carrito vacío");
        Map<String, Integer> cantidades = new HashMap<>();
        for (ItemCarrito x: items) {
            inventario.validarDisponibilidad(x.getProducto(), x.getCantidad());
            cantidades.merge(x.getProducto().getProductoBase().getCodigo(), x.getCantidad(), Integer:: sum);
        }
        for (Map.Entry<String, Integer> x: cantidades.entrySet()) {
            Producto base = inventario.buscar(x.getKey()).orElseThrow(() -> new ProductoNoEncontradoException("Producto inexistente"));
            if (x.getValue()> base.getStock()) throw new StockInsuficienteException("Stock insuficiente");
        }
        double subtotal = items.stream().mapToDouble(x -> x.getProducto().getPrecioConImpuesto() * x.getCantidad()).sum();
        ResumenPrecio r = calculadora.calcular(subtotal, d, e, cliente);
        List<DetalleCompra> ds = items.stream().map(x -> new DetalleCompra(x.getProducto(), x.getCantidad(), x.getProducto().getPrecioConImpuesto())).collect(Collectors.toList());
        Compra c = new Compra(codigo, cliente, ds, subtotal, r.getValorDescuento(), r.getCostoEnvio(), r.getTotal());
        cantidades.forEach((id, q) -> inventario.descontar(inventario.buscar(id).orElseThrow(), q));
        historial.registrar(c);
        cliente.registrarCompra();
        items.clear();
        LOG.info("Compra confirmada " + codigo);
        return c;
    }
}
