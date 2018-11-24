package endereco;

import java.io.Serializable;

public class Rua implements Serializable {

	private static final long serialVersionUID = -1708555828843578480L;

	private String rua;
	private int idRua;
	
	public int getIdRua() {
		return idRua;
	}

	public void setIdRua(int idRua) {
		this.idRua = idRua;
	}

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
