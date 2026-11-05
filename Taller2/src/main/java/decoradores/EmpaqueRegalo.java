package decoradores;

import modelo.Producto;

public class EmpaqueRegalo extends ProductoDecorador {

    public EmpaqueRegalo(Producto p) {
        super(p);
    }

    @Override
    public double getPrecioBase() {
        return super.getPrecioBase();
    }

    protected double costoExtra() {
        return 5000;
    }
}