package es.gastosApi.repositorios;

import es.gastosApi.entidades.UsuarioConId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="usuarios", itemResourceRel="usuario", collectionResourceRel="usuarios")
public interface UsuarioDAO extends JpaRepository<UsuarioConId, Long> {
}
