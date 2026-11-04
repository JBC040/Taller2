package modelo;

public class Ropa extends Producto {

    private final String talla;

    public Ropa(String c, String n, double p, int s, String t) {
        super(c, n, Categoria.ROPA, p, s);
        talla = t;
    }

    public String getTalla() {
        return talla;
    }
}
