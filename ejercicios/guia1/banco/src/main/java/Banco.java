import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Builder
public class Banco {
    @Builder.Default
    private List<Usuario> usuarios = new ArrayList<>();
    @Builder.Default
    private List<Cuenta> cuentas = new ArrayList<>();

    public Cuenta crearCuenta(Usuario us){
        Optional<Usuario> usOpt = buscarUsuario(us.getId());
        if(usOpt.isPresent()){
            return Cuenta.builder()
                    .id("######")
                    .titularId(us.getId())
                    .saldo(0)
                    .build();
        }
        return null;
    }

    public Cuenta crearCajaDeAhorro(Usuario us, double tasaDeInteres){
        Optional<Usuario> usOpt = buscarUsuario(us.getId());
        if(usOpt.isPresent()){
            return CajaDeAhorro.builder()
                    .tasaDeInteres(tasaDeInteres)
                    .id("######")
                    .titularId(us.getId())
                    .saldo(0)
                    .build();
        }
        return null;
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
                .filter(cuenta -> cuenta.equals(id))
                .findFirst();
    }

    public Optional<Usuario> buscarUsuario(String id){
        return usuarios
                .stream()
                .filter(us -> us.getId().equals(id))
                .findFirst();
    }
}
