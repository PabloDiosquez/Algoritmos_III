import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
@Builder
public class Cuenta {
    @NonNull @Getter
    private String id;
    @NonNull
    private String titularId;

    protected double saldo;

    public boolean depositar(double monto){
        if(monto < 0){
            return false;
        }
        saldo += monto;
        return true;
    }

    public boolean retirar(double monto){
        if(saldo - monto <= 0){
            return false;
        }
        saldo -= monto;
        return true;
    }

    public double obtenerSaldo(){
        return saldo;
    }
}
