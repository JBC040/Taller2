package modelo;

import java.time.LocalDate;
import excepciones.ProductoVencidoException;

public class Alimento extends Producto {

    private final LocalDate vencimiento;

    public Alimento(String c, String n, double p, int s, LocalDate f) {
        super(c, n, Categoria.ALIMENTO, p, s);
        if (f == null) {
            throw new IllegalArgumentException();
        }
        vencimiento = f;
    }

    public LocalDate getFechaVencimiento() {
        return vencimiento;
    }

    public void validarVigencia() {
        if (vencimiento.isBefore(LocalDate.now())) {
            throw new ProductoVencidoException("Producto vencido: " + getNombre());
        }
    }
}
