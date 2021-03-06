package endereco;

import java.io.Serializable;

import util.PessoaException;

public class CEP implements Serializable {

	private static final long serialVersionUID = -7419116019451061298L;
	
	private String cep;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) throws PessoaException {
		if(isCEP(cep)) {
			this.cep = cep;
		} else {
			throw new PessoaException("CEP INVALIDO");
		}
	}

	@Override
	public String toString() {
		return cep.substring(0, 5) + "-" + cep.substring(5, 8);
	}

	public boolean isCEP(String cep) {
		return cep.matches("[0-9]{8}");
	}

}
