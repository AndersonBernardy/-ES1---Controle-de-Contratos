package endereco;

import java.io.Serializable;

public class Rua implements Serializable {

	private static final long serialVersionUID = 8568907250779968407L;

	private String nomeRua;
	private int idRua;
	
	public int getIdRua() {
		return idRua;
	}

	public void setIdRua(int idRua) {
		this.idRua = idRua;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	@Override
	public String toString() {
		return nomeRua;
	}
	
	
	
}
