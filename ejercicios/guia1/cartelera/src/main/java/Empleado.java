public class Empleado extends Usuario{
    @Override
    public boolean iniciarSesion(String password) {
        return false;
    }

    @Override
    public void cerrarSesion(String password) {

    }
}
