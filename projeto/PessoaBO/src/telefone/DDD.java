package telefone;

import java.io.Serializable;

import util.PessoaException;

public class DDD implements Serializable {

	private static final long serialVersionUID = 1442109828874699531L;
	
	private String ddd;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) throws PessoaException {
		if(isDDD(ddd)) {
		this.ddd = ddd;
		}else {
			throw new PessoaException("DDD INVALIDO");
		}
	}

	@Override
	public String toString() {
		return ddd;
	}
	
	public boolean isDDD(String ddd) {
        return ddd.matches("((([1,4,6,8,9][1-9])|(2[1,2,4,7,8])|(3[1-8])|(4[1-9])|(5[1-5])|(7[1,3,4,5,7,9])))");
    }
	
}
