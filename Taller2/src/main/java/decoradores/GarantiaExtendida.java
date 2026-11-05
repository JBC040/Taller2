package decoradores;

import modelo.Producto;

public class GarantiaExtendida extends ProductoDecorador {

    public GarantiaExtendida(Producto p) {
        super(p);
    }

    @Override
    protected double costoExtra() {
        return 12000;
    }
}