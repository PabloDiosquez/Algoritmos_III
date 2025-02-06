import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

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
    public Boolean devolverCopia(Copia copia){
        return false;
    }

    public int consultarStockPorTitulo(String titulo) {
        return 0;
    }
    public int consultarStockPorFecha(LocalDate fecha) {
        return 0;
    }
    public int consultarStockPorAutor(String autor) {
        return 0;
    }

    // Métodos privados

    private void registrarPrestamo(Copia copia, Usuario usuario) {
        Prestamo prestamo = Prestamo.builder()
                .copia(copia)
                .us(usuario)
                .fechaPrestamo(LocalDate.now())
                .fechaDevolucion(LocalDate.now().plusDays(15))
                .build();
        prestamos.add(prestamo);
    }
}
