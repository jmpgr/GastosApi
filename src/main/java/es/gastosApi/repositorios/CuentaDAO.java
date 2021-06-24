package es.gastosApi.repositorios;

import es.gastosApi.entidades.CuentaConId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="cuentas", itemResourceRel="cuenta", collectionResourceRel="cuentas")
public interface CuentaDAO extends JpaRepository<CuentaConId, Long>, CuentaDAOCustom<CuentaConId> {
}
