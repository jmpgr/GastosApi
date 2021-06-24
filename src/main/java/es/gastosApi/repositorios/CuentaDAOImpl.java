package es.gastosApi.repositorios;

import comun.IngresoImpl;
import comun.Movimiento;
import es.gastosApi.entidades.CuentaConId;
import es.gastosApi.entidades.IngresoConId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional(readOnly = true)
public class CuentaDAOImpl implements CuentaDAOCustom<CuentaConId> {

    @PersistenceContext
    EntityManager entityManager;



    @Override
    public double totalEnCuenta(long id) {
        Query query = entityManager.createNativeQuery(
                "SELECT c.* FROM cuentas as c " +
                        "WHERE c.id = ?1", CuentaConId.class);
        query.setParameter(1, id);
        CuentaConId cuenta = (CuentaConId) query.getSingleResult();
        double total = 0;

        List<Movimiento> movimientos = cuenta.getMovimientos();
        for (int i = 0; i < movimientos.size(); i++){
            Movimiento movimiento = movimientos.get(i);
            if(movimiento instanceof IngresoConId){
                total += movimiento.getImporte();
            }
        }

        return total;
    }
}
