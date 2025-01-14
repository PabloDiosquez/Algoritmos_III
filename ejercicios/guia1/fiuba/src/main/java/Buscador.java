import java.util.List;
import java.util.function.Predicate;

public class Buscador<T> {
    private Predicate<T> estrategiaBusqueda;

    public Buscador(Predicate<T> estrategiaBusqueda) {
        this.estrategiaBusqueda = estrategiaBusqueda;
    }

    public T buscar(List<T> items) {
        for (T item: items) {
            if(estrategiaBusqueda.test(item)){
                return item;
            }
        }
        return null;
    }
}