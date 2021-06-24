package es.gastosApi.entidades;

import comun.Cuenta;
import comun.Movimiento;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class CuentaConId extends Cuenta {

    private Long id;

    @ManyToOne
    private UsuarioConId usuario;

    public CuentaConId() {
    }

    public Long getId() {
        return id;
    }

    @Override
    @OneToMany(targetEntity=MovimientoConId.class)
    public List<Movimiento> getMovimientos() {
        return super.getMovimientos();
    }

    public void addMovimientoConId(MovimientoConId movimiento) {
        super.addMovimiento(movimiento);
        movimiento.setCuenta(this);
    }
}
