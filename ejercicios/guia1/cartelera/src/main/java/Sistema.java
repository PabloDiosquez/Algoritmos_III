import java.util.Map;
import java.util.List;
public class Sistema {
    private Map<String, Usuario> usuarios;
    private List<Mensaje> mensajes;
    private Map<String, Boolean> sesionesActivas;

    public boolean autenticar(String us, String password){
        return false;
    }

    public void cerrarSesion(Usuario us){

    }

    public boolean enviarMensaje(Usuario emisor, Usuario receptor, String contenido){
        return false;
    }

    public List<Mensaje> obtenerMensajesEnviados(Usuario us){
        return null;
    }
    public List<Mensaje> obtenerMensajesRecibidos(Usuario us){
        return null;
    }

    public void salir(Usuario us){
        
    }
}
