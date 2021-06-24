package es.gastosApi.entidades;

import comun.Gasto;
import comun.GastoImpl;
import comun.Usuario;

public class GastoConId extends MovimientoConId implements Gasto {
	private boolean autorizado;
	
	public GastoConId() {
		super();
	}

	@Override
	public Usuario getUsuarioAutorizado() {
		return null;
	}

	@Override
	public boolean getAutorizado() {
		return autorizado;
	}

	public void setAutorizado( boolean autorizado){
		this.autorizado=autorizado;
	}
}
