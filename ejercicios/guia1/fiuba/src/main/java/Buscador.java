import java.util.List;
import java.util.function.Predicate;

public class Buscador<T> {
    private Predicate<T> estrategiaBusqueda;

    public Buscador(Predicate<T> estrategiaBusqueda) {
        this.estrategiaBusqueda = estrategiaBusqueda;
    }

    public T buscar(List<T> items) {
        return items.stream().filter(estrategiaBusqueda).findFirst().orElse(null);
    }
}