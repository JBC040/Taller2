package decoradores;

import modelo.*;

public abstract class ProductoDecorador extends Producto {

    protected final Producto producto;

    protected ProductoDecorador(Producto p) {
        super(p.getCodigo(), p.getNombre(), p.getCategoria(), p.getPrecioBase(), p.getStock());
        producto = p;
    }

    protected abstract double costoExtra();

    @Override
    public double getPrecioBase() {
        return producto.getPrecioBase() + costoExtra();
    }

    @Override
    public int getStock() {
        return producto.getStock();
    }

    @Override
    public void descontarStock(int q) {
        producto.descontarStock(q);
    }

    @Override
    public void aumentarStock(int q) {
        producto.aumentarStock(q);
    }

    @Override
    public Producto getProductoBase() {
        return producto.getProductoBase();
    }
}

