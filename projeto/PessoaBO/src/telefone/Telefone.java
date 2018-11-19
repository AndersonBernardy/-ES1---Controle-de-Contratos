package telefone;

import java.io.Serializable;

import util.validaException;

public class Telefone implements Serializable {

	private static final long serialVersionUID = 536581453749497671L;

	private DDI ddi;
	private DDD ddd;
	private String telefone;
	
	public DDI getDdi() {
		return ddi;
	}
	
	public void setDdi(DDI ddi) {
		this.ddi = ddi;
	}
	
	public DDD getDdd() {
		return ddd;
	}
	
	public void setDdd(DDD ddd) {
		this.ddd = ddd;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) throws validaException {
		if(isTelefone(telefone)) {
		this.telefone = telefone;
		}else {
			throw new validaException("TELEFONE INVALIDO");
		}
	}

	@Override
	public String toString() {
		return ddi + " " + ddd + " " + telefone;
	}
	
	public boolean isTelefone(String telefone) {
        return telefone.matches("[6-9][0-9]{3}-[0-9]{4}") ||
        		telefone.matches("[9][6-9][0-9]{3}-[0-9]{4}");
    }
	
}
