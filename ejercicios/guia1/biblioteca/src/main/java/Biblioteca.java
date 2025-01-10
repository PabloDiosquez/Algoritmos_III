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
        for (Libro libro : libros) {
            if (criterio.test(libro)) {
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
        for (Libro libro : libros) {
            if (criterio.test(libro)) {
                return true;
            }
        }
        return false;
    }

    // -------------------- CLIENTES --------------------

    public String agregarCliente(String nombre, String apellido){
        if(esCliente(nombre, apellido)){
            return "Ya es cliente!";
        }
        Cliente cliente = Cliente.builder()
                .id(generarId())
                .nombre(nombre)
                .apellido(apellido)
                .build();
        return String.format("Cliente ID: %s - Nombre Completo: %s", cliente.getId(), cliente.nomYApell());
    }

    public String quitarCliente(String nombre, String apellido){
        if(esCliente(nombre, apellido)){
            Cliente cliente = buscarCliente(nombre, apellido);

            return String.format("Cliente ID: %s - Nombre completo: %s", cliente.getId(), cliente.nomYApell());
        }
        return "No es cliente de nuestra biblioteca";
    }

    public String prestarLibro(String titulo, String nombre, String apellido){
        if(consultarStock(titulo) > 0 && esCliente(nombre, apellido)){
            Libro libro = buscar(titulo);
            libro.actualizarStock(-1);
            Cliente cliente = buscarCliente(nombre, apellido);
            cliente.agregarLibro(libro);
            return String.format("Libro: %s -- Cliente: %s", libro.getTitulo(), cliente.nomYApell());
        }
        return "No se puede prestar el libro.\nRevisar datos solicitados.";
    }

    public String devolverLibro(String titulo, String nombre, String apellido){
        if(!esCliente(nombre, apellido)){
            return "No es cliente";
        }
        Cliente cliente = buscarCliente(nombre, apellido);
        if(!cliente.tieneLibro(titulo)){
            return "El cliente no tiene el libro";
        }
        Libro libro = cliente.devolverLibro(titulo);
        libro.actualizarStock(1);
        return String.format("Libro %s devuelto por Cliente: %s", libro.getTitulo(), cliente.nomYApell());
    }

    public String consultarPrestamo(String titulo, String nombre, String apellido){
        if(!esCliente(nombre, apellido)){
            return "No es cliente";
        }
        return buscarCliente(nombre, apellido).verLibros();
    }

    private Cliente buscarCliente(String nombre, String apellido){
        for (Cliente cliente: clientes) {
            if(cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellido)){
                return cliente;
            }
        }
        return null;
    }
    private boolean esCliente(String nombre, String apellido){
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellido)) {
                return true;
            }
        }
        return false;
    }

    // --------------------------------------------------

    private int generarISBN(){
        return new Random().nextInt(1000);
    }

    private int generarId(){
        return new Random().nextInt(1000);
    }

}