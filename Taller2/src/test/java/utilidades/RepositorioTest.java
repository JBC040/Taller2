package utilidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioTest {

    private Repositorio<String> repositorio;

    @BeforeEach
    void setUp() {
        repositorio = new Repositorio<>();

        repositorio.agregar("Juan");
        repositorio.agregar("Pedro");
        repositorio.agregar("Carlos");
    }

    @Test
    void debeAgregarElementos() {

        assertEquals(3, repositorio.obtenerTodos().size());
    }

    @Test
    void debeObtenerTodosLosElementos() {

        List<String> nombres = repositorio.obtenerTodos();

        assertEquals(List.of("Juan", "Pedro", "Carlos"), nombres);
    }

    @Test
    void debeEncontrarUnElemento() {

        Optional<String> resultado =
                repositorio.buscar(nombre -> nombre.equals("Pedro"));

        assertTrue(resultado.isPresent());
        assertEquals("Pedro", resultado.get());
    }

    @Test
    void debeDevolverOptionalVacioCuandoNoEncuentra() {

        Optional<String> resultado =
                repositorio.buscar(nombre -> nombre.equals("Andres"));

        assertTrue(resultado.isEmpty());
    }

    @Test
    void laListaObtenidaNoDebeModificarElRepositorio() {

        List<String> copia = repositorio.obtenerTodos();

        copia.add("Andres");

        assertEquals(3, repositorio.obtenerTodos().size());
    }
}

