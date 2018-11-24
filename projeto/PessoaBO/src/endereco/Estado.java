package endereco;

import java.io.Serializable;

public class Estado implements Serializable {

	private static final long serialVersionUID = -3112491298431151748L;

	private String nomeEstado;
	private String sigla;
	private int idEstado;
	
	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}
	
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return nomeEstado + " - " + sigla;
	}
	
}
