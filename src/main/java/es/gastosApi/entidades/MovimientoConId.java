package es.gastosApi.entidades;

import comun.Categoria;
import comun.MovimientoImpl;

import javax.persistence.*;
import java.util.List;


public class MovimientoConId extends MovimientoImpl {
    private Long id;

    @ManyToOne
    private CuentaConId cuenta;

    public CuentaConId getCuenta() {
        return cuenta;
    }

    @Override
    @ManyToOne(targetEntity = CategoriaConId.class)
    public Categoria getCategoria() {
        return super.getCategoria();
    }


    public void setCuenta(CuentaConId cuentaConId) {
        this.cuenta = cuentaConId;
    }

    public MovimientoConId() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
