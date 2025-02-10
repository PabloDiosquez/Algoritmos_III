import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class CajaDeAhorro extends Cuenta{
    @NonNull
    private double tasaDeInteres;

    public double calcularInteres(int meses){
        return obtenerSaldo()*(1 + tasaDeInteres * meses);
    }

    public void aplicarInteres(int meses){
        saldo = obtenerSaldo()*(1 + tasaDeInteres * meses);
    }
}
