package endereco;

import java.io.Serializable;

public class Estado implements Serializable {

	private static final long serialVersionUID = 4567832058487210447L;

	private String estado;
	private String sigla;
	
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
