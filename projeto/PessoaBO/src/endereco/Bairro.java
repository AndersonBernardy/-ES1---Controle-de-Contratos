package endereco;

import java.io.Serializable;

public class Bairro implements Serializable {

	private static final long serialVersionUID = 5172840116211386329L;

	private String nomeBairro;
	private int idBairro;
	
	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public int getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	@Override
	public String toString() {
		return nomeBairro;
	}
	
}
