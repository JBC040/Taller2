
package utilidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdenamientoTest {

    private List<Integer> numeros;

    @BeforeEach
    void setUp() {
        numeros = new ArrayList<>(
                Arrays.asList(5, 2, 8, 1, 3)
        );
    }

    @Test
    void debeOrdenarNumerosDeMenorAMayor() {

        Ordenamiento.ordenar(numeros);

        assertEquals(
                List.of(1, 2, 3, 5, 8),
                numeros
        );
    }

    @Test
    void debeOrdenarUnaListaVacia() {

        List<Integer> vacia = new ArrayList<>();

        Ordenamiento.ordenar(vacia);

        assertTrue(vacia.isEmpty());
    }

    @Test
    void debeOrdenarUnaListaConUnSoloElemento() {

        List<Integer> lista = new ArrayList<>(List.of(10));

        Ordenamiento.ordenar(lista);

        assertEquals(List.of(10), lista);
    }

    @Test
    void debeOrdenarUnaListaConElementosRepetidos() {

        List<Integer> lista =
                new ArrayList<>(List.of(4, 2, 4, 1, 2));

        Ordenamiento.ordenar(lista);

        assertEquals(List.of(1, 2, 2, 4, 4), lista);
    }
}

