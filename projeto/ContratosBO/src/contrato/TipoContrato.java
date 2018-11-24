package contrato;

import java.io.Serializable;

public class TipoContrato implements Serializable {

	private static final long serialVersionUID = 7846448191861279672L;

	private String tipo;
	private int idTipoContrato;
	
	public int getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(int idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return tipo;
	}

	
	
}
