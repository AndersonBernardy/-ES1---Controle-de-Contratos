package telefone;

import java.io.Serializable;

public class DDI implements Serializable {

	private static final long serialVersionUID = 871907050939499444L;
	
	private String ddi;

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	@Override
	public String toString() {
		return ddi;
	}

}
