import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
public class Banco {
    @Builder.Default
    private List<Usuario> usuarios = new ArrayList<>();
    @Builder.Default
    private List<Cuenta> cuentas = new ArrayList<>();

    public Cuenta crearCuenta(Usuario us){
        Optional<Usuario> usOpt = buscarUsuario(us.getId());
        if(usOpt.isPresent()){
            Cuenta cuenta = Cuenta.builder()
                    .id(Helper.generarStringRandom(10))
                    .titularId(us.getId())
                    .saldo(0)
                    .build();
            us.agregarCuenta(cuenta);
            cuentas.add(cuenta);
            return cuenta;
        }
        return null;
    }

    public Cuenta crearCajaDeAhorro(Usuario us, double tasaDeInteres){
        CajaDeAhorro cajaDeAhorro = (CajaDeAhorro) crearCuenta(us);
        cajaDeAhorro.setTasaDeInteres(tasaDeInteres);
        return cajaDeAhorro;
    }
    public boolean transferir(String origenId, String destinoId, double monto){
        Optional<Cuenta> origenOpt = buscarCuenta(origenId);
        if(origenOpt.isEmpty()){
            return false;
        }

        Cuenta origen = origenOpt.get();
        if(origen.obtenerSaldo() - monto < 0){
            return false;
        }

        Optional<Cuenta> destinoOpt = buscarCuenta(destinoId);
        if(destinoOpt.isEmpty()){
            return false;
        }
        Cuenta destino = destinoOpt.get();
        origen.retirar(monto);
        destino.depositar(monto);
        return true;
    }

    public Optional<Cuenta> buscarCuenta(String id){
        return cuentas.stream()
                .filter(cuenta -> cuenta.getId().equals(id))
                .findFirst();
    }

    public Optional<Usuario> buscarUsuario(String id){
        return usuarios
                .stream()
                .filter(us -> us.getId().equals(id))
                .findFirst();
    }
}