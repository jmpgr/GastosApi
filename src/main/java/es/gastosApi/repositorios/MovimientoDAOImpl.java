package es.gastosApi.repositorios;

import es.gastosApi.entidades.MovimientoConId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class MovimientoDAOImpl implements MovimientoDAOCustom{

    @Autowired
    MovimientoDAO movimientoDAO;

    @Override
    public List<MovimientoConId> getMovimientosPorCategorias(String categoria) {
        return movimientoDAO.findAll().stream()
                .filter(movimiento -> movimiento.getCategoria()!= null && movimiento.getCategoria().getNombreCategoria().equals(categoria))
                .collect(Collectors.toList());
    }
}
