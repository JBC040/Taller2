package utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Repositorio <T> implements Buscable <T> {

    private List<T> elementos;

    public Repositorio() {
        elementos = new ArrayList<>();
    }

    public void agregar (T elemento) {
        elementos.add(elemento);
    }

    public List<T> obtenerTodos() {
        return new ArrayList<>(elementos);
    }

    @Override
    public Optional<T> buscar(Predicate<? super T> condicion) {
        return elementos.stream()
                .filter(condicion)
                .findFirst();
    }
}
