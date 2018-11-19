package pessoa;

import java.io.Serializable;

import util.validaException;

public class RG implements Serializable {

	private static final long serialVersionUID = -8325640994980284381L;
	
	private String rg;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) throws validaException {
		if(isRG(rg)) {
		this.rg = rg;
		}else {
			throw new validaException("RG INVALIDO");
		}
	}

	@Override
	public String toString() {
		return rg;
	}
	
	public boolean isRG(String rg) {
		   for (int i = 0; i < rg.length(); i++) {
		      if (!Character.isDigit(rg.charAt(i))) {
		         return false;
		      }
		   }
		   return true;
		}
	
}
