package decoradores;

import modelo.*;

public abstract class ProductoDecorador extends Producto {

    protected final Producto producto;

    protected ProductoDecorador(Producto p) {
        super(p.getCodigo(), p.getNombre(), p.getCategoria(), p.getPrecioBase(), p.getStock());
        producto = p;
    }

    protected abstract double costoExtra();

    public double getPrecioBase() {
        return producto.getPrecioBase() + costoExtra();
    }

    public int getStock() {
        return producto.getStock();
    }

    public void descontarStock(int q) {
        producto.descontarStock(q);
    }

    public void aumentarStock(int q) {
        producto.aumentarStock(q);
    }

    public Producto getProductoBase() {
        return producto.getProductoBase();
    }
}