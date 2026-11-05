package compras;
public class Cliente {
    private final String identificacion, nombre;
    private int compras;
    public Cliente(String i, String n) {
        if (i == null || i.isBlank() || n == null || n.isBlank()) throw new IllegalArgumentException();
        identificacion = i;
        nombre = n;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public String getNombre() {
        return nombre;
    }
    public int getComprasRealizadas() {
        return compras;
    }
    public boolean esFrecuente() {
        return compras>= 5;
    }
    public void registrarCompra() {
        compras++;
    }
}
