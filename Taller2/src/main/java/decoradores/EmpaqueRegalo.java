package decoradores;

import modelo.Producto;

public class EmpaqueRegalo extends ProductoDecorador {

    public EmpaqueRegalo(Producto p) {
        super(p);
    }

    protected double costoExtra() {
        return 5000;
    }
}