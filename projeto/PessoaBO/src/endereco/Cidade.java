package endereco;

import java.io.Serializable;

public class Cidade implements Serializable {

	private static final long serialVersionUID = 787410616497560145L;
	
	private String cidade;
	private Estado estado;
	private int idCidade;
	
	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return cidade + "/" + estado;
	}
	
	
	
}
