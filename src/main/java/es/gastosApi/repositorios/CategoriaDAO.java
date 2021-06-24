package es.gastosApi.repositorios;

import es.gastosApi.entidades.CategoriaConId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="categorias", itemResourceRel="categoria", collectionResourceRel="categorias")
public interface CategoriaDAO extends JpaRepository<CategoriaConId, Long> {

    CategoriaConId findByNombreCategoria(String nombre);
}
