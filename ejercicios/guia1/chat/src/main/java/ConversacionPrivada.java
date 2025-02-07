import lombok.Builder;
import lombok.NonNull;
@Builder
public class ConversacionPrivada extends Conversacion{
    @NonNull
    private Usuario participante1;
    @NonNull
    private Usuario participante2;

    public ConversacionPrivada(@NonNull String id) {
        super(id);
    }
}
