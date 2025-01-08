import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data
public class Cliente {
    private @NonNull int id;
    private String nomYApell;

    @Builder.Default
    private List<Libro> librosPrestados = new ArrayList<>();

}
