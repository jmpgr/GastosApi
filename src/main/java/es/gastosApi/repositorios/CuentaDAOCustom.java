package es.gastosApi.repositorios;

import comun.Cuenta;

public interface CuentaDAOCustom <T extends Cuenta> {

    double totalEnCuenta(long id);
}
