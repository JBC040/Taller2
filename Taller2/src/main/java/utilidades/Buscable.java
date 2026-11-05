package utilidades;

import java.util.Optional;

import java.util.function.Predicate;

public interface Buscable <T> {

    Optional<T> buscar(Predicate<? super T> condicion);
}
