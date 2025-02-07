
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Usuario {
    @NonNull @Getter
    private String us;
    @NonNull @Getter
    private String password;
    @Getter @Setter
    private boolean activo;

    public abstract boolean iniciarSesion(String password);

    public Mensaje enviarMensaje(Usuario otro, String contenido){
        return Mensaje.builder()
                .emisor(this)
                .receptor(otro)
                .contenido(contenido)
                .build();
    }
    public void cerrarSesion() {
        this.setActivo(false);
    }

}
