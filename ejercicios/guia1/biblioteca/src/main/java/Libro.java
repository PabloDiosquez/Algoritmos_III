import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@RequiredArgsConstructor
public class Libro {
    private final @NonNull int isbn;
    private final @NonNull String titulo;

    @Builder.Default
    private LocalDate fechaPublicacion = LocalDate.of(1900, 1, 1);

    @Builder.Default
    @ToString.Exclude
    private List<String> autores = new ArrayList<>();

    private int stock;

    public void incrementarStock() {
        setStock(getStock() + 1);
    }
}
