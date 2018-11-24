package endereco;

import java.io.Serializable;

public class Estado implements Serializable {

	private static final long serialVersionUID = -2707574064107607313L;

	private String estado;
	private String sigla;
	private int idEstado;
	
	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return estado + " - " + sigla;
	}
	
}
