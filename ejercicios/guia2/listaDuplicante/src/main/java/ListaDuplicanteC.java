import java.util.ArrayList;
import java.util.List;

public class ListaDuplicanteC<T> implements ListaDuplicante<T>{
    private final List<T> items;

    public ListaDuplicanteC(){
        items = new ArrayList<>();
    }

    public boolean add(T x){
        items.add(x);
        return items.add(x);
    }

    public T get(int i){
        return items.get(i); // Delego la implementación a otro objeto.
    }
}
