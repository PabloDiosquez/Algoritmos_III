
import lombok.Builder;
import lombok.NonNull;

import java.time.LocalDate;
@Builder
public class Mensaje {
    @NonNull
    private Usuario emisor;
    @NonNull
    private Usuario receptor;
    private String contenido;
    private LocalDate timestamp;
}
