import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
    private Map<String, Usuario> usuarios;
    private List<Mensaje> mensajes;
    private Map<String, Boolean> sesiones;

    public boolean autenticar(String us, String password){
        if(usuarios.containsKey(us)){
            Usuario usuario = usuarios.get(us);
            boolean ok = password.equals(usuario.getPassword());
            if(ok){
                sesiones.put(us, true);
                usuario.setActivo(true);
                return true;
            }
        }
        return false;
    }

    public void cerrarSesion(Usuario us){
        if(us.isActivo()){
            sesiones.put(us.getUs(), false);
            us.cerrarSesion();
        }
    }
    public boolean enviarMensaje(Usuario emisor, Usuario receptor, String contenido){
        if(usuarios.containsKey(emisor.getUs()) && usuarios.containsKey(receptor)){
            Mensaje mensaje = emisor.enviarMensaje(receptor, contenido);
            mensajes.add(mensaje);
            return true;
        }
        return false;
    }

    public List<Mensaje> obtenerMensajesEnviados(Usuario us){
        if(usuarios.containsKey(us.getUs())){
            return mensajes.stream().filter(mensaje
                    -> mensaje.getEmisor().equals(us)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
    public List<Mensaje> obtenerMensajesRecibidos(Usuario us) {
        if(usuarios.containsKey(us.getUs())){
            return mensajes.stream().filter(mensaje
                    -> mensaje.getReceptor().equals(us)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    public void salir(UsAutorizado us){
        System.out.println("Apagando....");
        us.salirSistema();
    }
}
