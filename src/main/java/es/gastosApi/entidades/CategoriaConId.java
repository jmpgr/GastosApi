package es.gastosApi.entidades;

import comun.Categoria;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class CategoriaConId extends Categoria {

    private Long id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = MovimientoConId.class, mappedBy = "categoria")
    private List<MovimientoConId> movimientos;

    public Long getId() {
        return id;
    }

    public List<MovimientoConId> getMovimientos() {
        return this.movimientos;
    }

    public void setMovimientos(List<MovimientoConId> movimiento) {
        this.movimientos = movimiento;
    }


}
