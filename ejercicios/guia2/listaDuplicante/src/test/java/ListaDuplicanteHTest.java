import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDuplicanteHTest {

    @Test
    void testHerencia() {
        ListaDuplicante<Integer> listaDuplicante = new ListaDuplicanteH<>();
        listaDuplicante.add(1);
        listaDuplicante.add(2);
        listaDuplicante.add(3);
        assertEquals(listaDuplicante.get(0), 1);
        assertEquals(listaDuplicante.get(1), 1);
        assertEquals(listaDuplicante.get(2), 2);
        assertEquals(listaDuplicante.get(3), 2);
        assertEquals(listaDuplicante.get(4), 3);
        assertEquals(listaDuplicante.get(5), 3);
    }
}