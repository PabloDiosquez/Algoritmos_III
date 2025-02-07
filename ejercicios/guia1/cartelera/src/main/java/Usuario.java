public abstract class Usuario {
    private String us;
    private String password;
    private boolean activo;

    public abstract boolean iniciarSesion(String password);
    public abstract void cerrarSesion(String password);

}
