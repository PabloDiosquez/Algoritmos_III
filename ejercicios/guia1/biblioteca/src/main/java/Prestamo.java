import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
public class Prestamo {
    @Getter
    private Copia copia;
    @Getter
    private Usuario us;
    private LocalDate fechaPrestamo;
    @Setter
    private LocalDate fechaDevolucion;
}
