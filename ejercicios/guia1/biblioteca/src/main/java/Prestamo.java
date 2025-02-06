import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

import java.time.LocalDate;

@Builder
public class Prestamo {
    private Copia copia;
    private Usuario us;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
}
