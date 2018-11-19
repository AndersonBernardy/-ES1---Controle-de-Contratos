package endereco;

import java.io.Serializable;

public class Bairro implements Serializable {

	private static final long serialVersionUID = -4097737024031781264L;
	
	private String bairro;

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
