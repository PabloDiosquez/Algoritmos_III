import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Empleado extends Usuario implements UsAutorizado {
    @Override
    public boolean iniciarSesion(String password) {
        return false;
    }

    @Override
    public void salirSistema() {

    }
}
