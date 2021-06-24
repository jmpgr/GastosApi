package es.gastosApi.repositorios;

import es.gastosApi.entidades.GastoConId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "gastos", itemResourceRel = "gasto", collectionResourceRel = "gastos")
public interface GastoDAO extends JpaRepository<GastoConId, Long> {
}
