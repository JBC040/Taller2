package estrategias;

import compras.Cliente;

public class DescuentoTemporada implements EstrategiaDescuento {

    private final double porcentaje;

    public DescuentoTemporada(double p) {
        if (p<0 || p>1) throw new IllegalArgumentException();
        porcentaje = p;
    }

    public double calcularDescuento(double s, Cliente c) {
        return s * porcentaje;
    }
}
