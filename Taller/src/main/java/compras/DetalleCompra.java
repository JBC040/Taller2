package compras;
import modelo.Producto;
public class DetalleCompra {
    private final Producto producto;
    private final int cantidad;
    private final double precioUnitario;
    public DetalleCompra(Producto p, int q, double pu) {
        producto = p;
        cantidad = q;
        precioUnitario = pu;
    }
    public Producto getProducto() {
        return producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public double getSubtotal() {
        return precioUnitario * cantidad;
    }
}