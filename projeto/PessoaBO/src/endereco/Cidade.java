package endereco;

import java.io.Serializable;

public class Cidade implements Serializable {

	private static final long serialVersionUID = 2345308565987443955L;

	private String cidade;
	private Estado estado;
	
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
