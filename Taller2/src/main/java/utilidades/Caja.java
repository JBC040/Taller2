package utilidades;

public class Caja <T> {

    private T contenido;

    public void guardar(T contenido) {
        this.contenido = contenido;
    }

    public T obtener() {
        return contenido;
    }

    public boolean estaVacia() {
        return contenido == null;
    }
}
