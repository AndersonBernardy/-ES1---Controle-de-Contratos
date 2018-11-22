package pessoa;

import java.io.Serializable;

public class Sexo implements Serializable {

	private static final long serialVersionUID = 2982872308216310725L;
	
	private String sexo;

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return sexo;
	}
	
}
