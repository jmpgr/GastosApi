package es.gastosApi.entidades;

import comun.Usuario;

public class UsuarioConId extends Usuario {

    private Long id;
    private CuentaConId cuenta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CuentaConId getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaConId cuenta) {
        this.cuenta = cuenta;
    }
}
