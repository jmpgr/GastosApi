package es.gastosApi.repositorios;

import es.gastosApi.entidades.MovimientoConId;

import java.util.List;

public interface MovimientoDAOCustom {

    List<MovimientoConId> getMovimientosPorCategorias(String categoria);
}
