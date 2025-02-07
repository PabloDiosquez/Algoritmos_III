import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Mensaje {
    private Usuario emisor;
    private Usuario receptor;
    private String contenido;
}
