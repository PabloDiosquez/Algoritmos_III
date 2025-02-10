public class Cuenta {
    private String id;
    private String titular;
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
