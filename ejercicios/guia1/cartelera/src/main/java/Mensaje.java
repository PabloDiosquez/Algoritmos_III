
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
@Builder @Getter
public class Mensaje {
    @NonNull
    private Usuario emisor;
    @NonNull
    private Usuario receptor;
    private String contenido;
    private LocalDate timestamp;
}
