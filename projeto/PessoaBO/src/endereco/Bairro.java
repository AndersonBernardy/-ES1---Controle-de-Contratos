package endereco;

import java.io.Serializable;

public class Bairro implements Serializable {

	private static final long serialVersionUID = -7405594288666920572L;

	private String bairro;
	private int idBairro;

	public int getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return bairro;
	}
	
}
