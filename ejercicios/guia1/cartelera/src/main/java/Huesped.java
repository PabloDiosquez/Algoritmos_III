import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Huesped extends Usuario{
    @Override
    public boolean iniciarSesion(String password) {
        return false;
    }

}
