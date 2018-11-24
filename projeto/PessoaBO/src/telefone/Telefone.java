package telefone;

import java.io.Serializable;

import util.PessoaException;

public class Telefone implements Serializable {

	private static final long serialVersionUID = 3229619560611919781L;

	private DDD ddd;
	private String numeroTelefone;

	public DDD getDdd() {
		return ddd;
	}

	public void setDdd(DDD ddd) {
		this.ddd = ddd;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) throws PessoaException {
		if(isTelefone(numeroTelefone)) {
			this.numeroTelefone = numeroTelefone;
		} else {
			throw new PessoaException("TELEFONE INVALIDO");
		}
	}

	@Override
	public String toString() {
		return ddd + " " + numeroTelefone;
	}

	public boolean isTelefone(String telefone) {
		return telefone.matches("[6-9][0-9]{7}") ||
				telefone.matches("[9][6-9][0-9]{7}");
	}

}
