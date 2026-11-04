package inventario;

import modelo.Producto;
import java.util.Comparator;

public class ComparadorPorPrecio implements Comparator<Producto> {

    public int compare(Producto a, Producto b) {
        return Double.compare(a.getPrecioConImpuesto(), b.getPrecioConImpuesto());
    }
}