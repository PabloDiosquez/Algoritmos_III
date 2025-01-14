import java.util.List;
import java.util.function.Predicate;

public class Buscador<T> {
    public Boolean pertenece(List<T> items, Predicate<T> criterio){
        for (T item: items) {
            if(criterio.test(item)){
                return true;
            }
        }
        return false;
    }
    public T buscar(List<T> items, Predicate<T> criterio){
        for (T item: items) {
            if(criterio.test(item)){
                return item;
            }
        }
        return null;
    }
}
