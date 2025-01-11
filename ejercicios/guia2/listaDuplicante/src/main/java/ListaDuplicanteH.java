import java.util.ArrayList;

public class ListaDuplicanteH<T> extends ArrayList<T> implements ListaDuplicante<T>{

    @Override
    public boolean add(T x){
        super.add(x);
        return super.add(x);
    }
}
