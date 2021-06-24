package es.gastosApi.repositorios;

import es.gastosApi.entidades.IngresoConId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "ingresos", itemResourceRel = "ingreso", collectionResourceRel = "ingresos")
public interface IngresoDAO extends JpaRepository<IngresoConId, Long> {
}
