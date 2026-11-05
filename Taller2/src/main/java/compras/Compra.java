package compras;
import java.time.LocalDateTime;
import java.util.*;
public class Compra {
    private final String codigo;
    private final Cliente cliente;
    private final List<DetalleCompra> detalles;
    private final LocalDateTime fecha = LocalDateTime.now();
    private final double subtotal, descuento, envio, total;
    public Compra(String c, Cliente cl, List<DetalleCompra> d, double s, double desc, double e, double t) {
        codigo = c;
        cliente = cl;
        detalles = Collections.unmodifiableList(new ArrayList<>(d));
        subtotal = s;
        descuento = desc;
        envio = e;
        total = t;
    }
    public String getCodigo() {
        return codigo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public List<DetalleCompra> getDetalles() {
        return detalles;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getDescuento() {
        return descuento;
    }
    public double getEnvio() {
        return envio;
    }
    public double getTotal() {
        return total;
    }
}
