package compras;
import modelo.Producto;
public class ItemCarrito {
    private final Producto producto;
    private int cantidad;
    public ItemCarrito(Producto p, int q) {
        if (p == null || q<= 0) throw new IllegalArgumentException();
        producto = p;
        cantidad = q;
    }
    public Producto getProducto() {
        return producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void aumentarCantidad(int q) {
        if (q<= 0) throw new IllegalArgumentException();
        cantidad += q;
    }
}