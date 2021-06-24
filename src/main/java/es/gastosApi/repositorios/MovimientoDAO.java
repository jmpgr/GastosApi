package es.gastosApi.repositorios;

import es.gastosApi.entidades.MovimientoConId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "movimientos", itemResourceRel = "movimiento", collectionResourceRel = "movimientos")
public interface MovimientoDAO extends JpaRepository<MovimientoConId, Long>, MovimientoDAOCustom {
}
