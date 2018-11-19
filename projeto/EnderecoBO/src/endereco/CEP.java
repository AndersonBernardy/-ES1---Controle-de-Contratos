package endereco;

import java.io.Serializable;

import util.validaException;

public class CEP implements Serializable {

	private static final long serialVersionUID = -7327747758502137566L;

	private String cep;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) throws validaException {
		if(isCEP(cep)) {
			this.cep = cep;
		} else {
			throw new validaException("CEP INVALIDO");
		}
	}

	@Override
	public String toString() {
		return cep;
	}

	public boolean isCEP(String cep) {
		return cep.matches("[0-9]{5}-[0-9]{3}");
	}

}
