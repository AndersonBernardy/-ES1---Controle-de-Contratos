package endereco;

import java.io.Serializable;

public class Rua implements Serializable {

	private static final long serialVersionUID = 504985939934473533L;

	private String rua;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Override
	public String toString() {
		return this.rua;
	}
	
	
	
}
