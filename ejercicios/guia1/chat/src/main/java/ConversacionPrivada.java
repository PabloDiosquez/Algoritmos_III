import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
@Builder
public class ConversacionPrivada extends Conversacion{
    @NonNull
    private Usuario participante1;
    @NonNull
    private Usuario participante2;
    public boolean esParticipante(String usId){
        return participante1.getId().equals(usId)
            || participante2.getId().equals(usId);
    }
}
