import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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

    public void agregarLibro(String titulo){
        if(pertenece(titulo)){
            buscar(titulo).actualizarStock(1);
            return;
        }
        Libro libro = Libro.builder()
                .ISBN(generarISBN())
                .titulo(titulo)
                .build();
        libros.add(libro);
    }

    public String quitarLibro(String titulo){
        if(pertenece(titulo)){
            Libro libro = buscar(titulo);
            libros.remove(libro);
            return libro.getTitulo();
        }
        return "El libro no forma parte de la colección de la biblioteca";
    }

    public int consultarStock(String titulo){
        return consultarStock(libro -> libro.getTitulo().equals(titulo));
    }

    public int consultarStock(int ISBN){
        return consultarStock(libro -> libro.getISBN() == ISBN);
    }

    private int consultarStock(Predicate<Libro> criterio){
        if(pertenece(criterio)){
            return buscar(criterio).getStock();
        }
        return 0;
    }
    private Libro buscar(int ISBN){
        return buscar(libro -> libro.getISBN() == ISBN);
    }

    private Libro buscar(String titulo){
        return buscar(libro -> libro.getTitulo().equals(titulo));
    }
    private Libro buscar(Predicate<Libro> criterio){
        Iterator<Libro> iter = libros.iterator();
        while(iter.hasNext()){
            Libro libro = iter.next();
            if(criterio.test(libro)){
                return libro;
            }
        }
        return null;
    }

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


    private boolean esCliente(String nombre, String apellido){
        Iterator<Cliente> iter = clientes.iterator();
        while(iter.hasNext()){
            Cliente cliente = iter.next();
            if(cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellido)){
                return true;
            }
        }
        return false;
    }

    // --------------------------------------------------

    private int generarISBN(){
        return new Random().nextInt(1000);
    }

}