import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListaDuplicanteCTest {
    @Test
    public void testComposicion() {
        ListaDuplicante<Integer> listaDuplicante = new ListaDuplicanteC<>();
        listaDuplicante.add(42);
        listaDuplicante.add(34);
        assertEquals(42, listaDuplicante.get(0));
        assertEquals(42, listaDuplicante.get(1));
        assertEquals(34, listaDuplicante.get(2));
        assertEquals(34, listaDuplicante.get(3));
    }
}