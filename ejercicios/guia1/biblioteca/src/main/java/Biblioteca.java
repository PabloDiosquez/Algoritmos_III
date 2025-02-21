import lombok.Builder;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

@Builder
public class Biblioteca {
    private Map<String, Libro> libros;
    private Map<String, List<Copia>> copias;
    private Map<String, Usuario> usuarios;
    @Builder.Default
    private List<Prestamo> prestamos = new ArrayList<>();

    public void agregarLibro(Libro libro, int cantidad) {
        String isbn = libro.getISBN();
        List<Copia> copiasExistentes = copias.getOrDefault(isbn, new ArrayList<>());

        int numeroCopiaInicial = copiasExistentes.size() + 1;
        List<Copia> nuevasCopias = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            String idCopia = String.format("%s-%04d", isbn, numeroCopiaInicial + i);
            nuevasCopias.add(
                    Copia.builder()
                            .idCopia(idCopia)
                            .libro(libro)
                            .disponible(true)
                            .build()
            );
        }

        copiasExistentes.addAll(nuevasCopias);
        copias.put(isbn, copiasExistentes);
    }

    public Boolean eliminarLibro(String ISBN){
        if(!libros.containsKey(ISBN)){
            return false;
        }

        boolean hayCopiasPrestadas = copias.get(ISBN)
                .stream().anyMatch(copia -> !copia.getDisponible());
        if(hayCopiasPrestadas){
            return false;
        }

        libros.remove(ISBN);
        copias.remove(ISBN);
        return true;
    }

    public boolean registrarUsuario(Usuario us) {
        String id = us.getId();
        if(usuarios.containsKey(id)){
            return false;
        }
        usuarios.put(id, us);
        return true;
    }

    public boolean prestarCopia(String ISBN, Usuario usuario) {
        if (!usuarios.containsKey(usuario.getId())) {
            return false;
        }

        List<Copia> copiasDelLibro = copias.getOrDefault(ISBN, Collections.emptyList());

        Optional<Copia> copiaDisponible = copiasDelLibro.stream()
                .filter(Copia::getDisponible)
                .findFirst();

        if (copiaDisponible.isPresent()) {
            Copia copia = copiaDisponible.get();
            if (copia.getDisponible()) {
                copia.setDisponible(false);
                usuario.agregarCopia(copia);
                registrarPrestamo(copia, usuario);
                return true;
            }
        }
        return false;
    }

    public boolean devolverCopia(Usuario us, Copia copia) {
        Optional<Prestamo> prestamoOpt = buscarPrestamo(us.getId(), copia.getIdCopia());
        if (prestamoOpt.isEmpty()) {
            return false;
        }

        Prestamo prestamo = prestamoOpt.get();
        if (!prestamos.contains(prestamo)) {
            return false;
        }

        us.devolverCopia(copia);
        copia.setDisponible(true);
        prestamo.setFechaDevolucion(LocalDate.now());
        prestamos.remove(prestamo);
        return true;
    }

    public int consultarStockPorTitulo(String titulo) {
        return consultarStock(libro -> libro.getTitulo().equals(titulo));
    }

    public int consultarStockPorFecha(LocalDate fecha) {
        return consultarStock(libro -> libro.getFechaPublicacion().equals(fecha));
    }

    public int consultarStockPorAutor(String autor) {
        return libros.values().stream()
                .filter(l -> l.getAutores().stream()
                        .anyMatch(a -> a.equalsIgnoreCase(autor)))
                .mapToInt(l -> copias.getOrDefault(l.getISBN(), Collections.emptyList()).size())
                .sum();
    }

    private void registrarPrestamo(Copia copia, Usuario usuario) {
        Prestamo prestamo = Prestamo.builder()
                .copia(copia)
                .us(usuario)
                .fechaPrestamo(LocalDate.now())
                .fechaDevolucion(LocalDate.now().plusDays(15))
                .build();
        prestamos.add(prestamo);
    }

    private Optional<Prestamo> buscarPrestamo(String usId, String copiaId){
        return prestamos.stream().filter(prestamo ->
                prestamo.getUs().getId().equals(usId) &&
                prestamo.getCopia().getIdCopia().equals(copiaId))
                .findFirst();
    }

    private int consultarStock(Predicate<Libro> condicionBusqueda){
        return libros.values().stream()
                .filter(condicionBusqueda)
                .mapToInt(l -> copias.getOrDefault(l.getISBN(), Collections.emptyList()).size())
                .sum();
    }
}
