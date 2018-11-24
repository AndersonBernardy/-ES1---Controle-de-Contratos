package endereco;

import java.io.Serializable;

public class Cidade implements Serializable {

	private static final long serialVersionUID = 5984241411871195387L;

	private String nomeCidade;
	private Estado estado;
	private int idCidade;
	
	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}
	
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return nomeCidade + "/" + estado;
	}
	
	
	
}
