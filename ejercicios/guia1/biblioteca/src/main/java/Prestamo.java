import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Prestamo {
    private Copia copia;
    private Usuario us;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
}
