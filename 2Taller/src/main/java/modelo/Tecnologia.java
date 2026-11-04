package modelo;

public class Tecnologia extends Producto {

    private final String marca;

    public Tecnologia(String c, String n, double p, int s, String m) {
        super(c, n, Categoria.TECNOLOGIA, p, s);
        marca = m;
    }

    public String getMarca() {
        return marca;
    }
}