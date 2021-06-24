package es.gastosApi.rest;


import es.gastosApi.entidades.MovimientoConId;
import es.gastosApi.repositorios.MovimientoDAO;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RepositoryRestController
@RequestMapping("/movimientos/search")
public class MovimientoController {

    MovimientoDAO movimientoDAO;

    public MovimientoController(MovimientoDAO movimientoDAO) {
        this.movimientoDAO = movimientoDAO;
    }

    @GetMapping(value ="/por-categoria")
    @ResponseBody
    public CollectionModel<PersistentEntityResource> getMovimientosPorCategoria(@RequestParam String categoria, PersistentEntityResourceAssembler assembler){
        final List<MovimientoConId> movimientosPorCategorias = movimientoDAO.getMovimientosPorCategorias(categoria);
        return assembler.toCollectionModel(movimientosPorCategorias);
    }
}
