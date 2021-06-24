package es.gastosApi.api;

import comun.Cuenta;
import comun.GastoImpl;
import comun.MovimientoImpl;
import es.gastosApi.entidades.*;
import es.gastosApi.repositorios.CategoriaDAO;
import es.gastosApi.repositorios.CuentaDAO;
import es.gastosApi.repositorios.MovimientoDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

@SpringBootApplication
@ImportResource({"classpath:config/jpa-config.xml"})
@Import(ConfiguracionPorJava.class)
public class GastosApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GastosApiApplication.class, args);

		CuentaDAO cuentaDAO = context.getBean(CuentaDAO.class);
		CategoriaDAO categoriaDAO = context.getBean(CategoriaDAO.class);
		MovimientoDAO movimientoDAO = context.getBean(MovimientoDAO.class);

		//cargarDatos(cuentaDAO, categoriaDAO, movimientoDAO);
	}

	public static void cargarDatos(CuentaDAO cuentaDAO, CategoriaDAO categoriaDAO, MovimientoDAO movimientoDAO) {

		CuentaConId cuentaConId = new CuentaConId();
		cuentaConId.setIban("ES1231235345431");
		final List<MovimientoImpl> movimientos = Cuenta.cargarMovimientos();
		cuentaConId = cuentaDAO.save(cuentaConId);
		for(int i = 0; i < movimientos.size(); i++){
			MovimientoImpl movimiento =movimientos.get(i);
			CategoriaConId categoriaConId = categoriaDAO.findByNombreCategoria(movimiento.getCategoria().getNombreCategoria());

			if(categoriaConId == null){
				categoriaConId = new CategoriaConId();
				categoriaConId.setNombreCategoria(movimiento.getCategoria().getNombreCategoria());
				categoriaDAO.save(categoriaConId);
			}

			MovimientoConId movimientoConId = new MovimientoConId();
			movimientoConId.setIdMovimiento(movimiento.getIdMovimiento());
			movimientoConId.setConcepto(movimiento.getConcepto());
			movimientoConId.setImporte(movimiento.getImporte());
			cuentaConId.addMovimientoConId(movimientoConId);
			if (movimiento instanceof GastoImpl){
				GastoConId gastoConId = new GastoConId();
				gastoConId.setIdMovimiento(movimiento.getIdMovimiento());
				gastoConId.setConcepto(movimiento.getConcepto());
				gastoConId.setImporte(movimiento.getImporte());
				gastoConId.setCuenta(cuentaConId);
				gastoConId.setCategoria(categoriaConId);
				gastoConId.setAutorizado(true);
				movimientoDAO.save(gastoConId);
			} else {
				IngresoConId ingresoConId = new IngresoConId();
				ingresoConId.setIdMovimiento(movimiento.getIdMovimiento());
				ingresoConId.setConcepto(movimiento.getConcepto());
				ingresoConId.setImporte(movimiento.getImporte());
				cuentaConId.addMovimientoConId(movimientoConId);
				ingresoConId.setCuenta(cuentaConId);
				ingresoConId.setCategoria(categoriaConId);
				ingresoConId.setCompartido(true);
				movimientoDAO.save(ingresoConId);
			}

		}

	}

}
