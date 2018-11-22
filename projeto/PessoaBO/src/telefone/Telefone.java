package telefone;

import java.io.Serializable;

import util.PessoaException;

public class Telefone implements Serializable {

	private static final long serialVersionUID = 3229619560611919781L;

	private DDD ddd;
	private String telefone;

	public DDD getDdd() {
		return ddd;
	}

	public void setDdd(DDD ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws PessoaException {
		if(isTelefone(telefone)) {
			this.telefone = telefone;
		} else {
			throw new PessoaException("TELEFONE INVALIDO");
		}
	}

	@Override
	public String toString() {
		return ddd + " " + telefone;
	}

	public boolean isTelefone(String telefone) {
		return telefone.matches("[6-9][0-9]{3}-[0-9]{4}") ||
				telefone.matches("[9][6-9][0-9]{3}-[0-9]{4}");
	}

}
