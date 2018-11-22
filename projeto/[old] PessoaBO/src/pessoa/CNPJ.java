package pessoa;

import java.io.Serializable;

public class CNPJ implements Serializable{

	private static final long serialVersionUID = 5742461391833835125L;
	
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return cnpj;
	}

}
