import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@Builder
public class Biblioteca {

    @Getter
    private @NonNull String nombre;

    @Builder.Default
    private List<Libro> libros = new ArrayList<>();

    @Builder.Default
    public List<Cliente> clientes = new ArrayList<>();

    // -------------------- LIBROS --------------------

    
    private boolean pertenece(int ISBN){
        return pertenece(libro -> libro.getISBN() == ISBN);
    }

    private boolean pertenece(String titulo){
        return pertenece(libro -> libro.getTitulo().equals(titulo));
    }

    private boolean pertenece(Predicate<Libro> criterio){
        Iterator<Libro> iter = libros.iterator();
        while(iter.hasNext()){
            Libro libro = iter.next();
            if(criterio.test(libro)){
                return true;
            }
        }
        return false;
    }

    // -------------------- CLIENTES --------------------














}