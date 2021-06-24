package es.gastosApi.entidades;

import comun.Ingreso;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


public class IngresoConId extends MovimientoConId implements Ingreso {

	private boolean compartido;
	
	public IngresoConId() {
		super();
	}

	public boolean isCompartido() {
		return compartido;
	}

	public void setCompartido(boolean compartido) {
		this.compartido = compartido;
	}

	public boolean getCompartido() {
		return compartido;
	}
}
