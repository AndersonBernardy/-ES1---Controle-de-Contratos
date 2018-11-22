package endereco;

import java.io.Serializable;

public class Endereco implements Serializable {

	private static final long serialVersionUID = -4594178015143949029L;

	private CEP cep;
	private Cidade cidade;
	private Bairro bairro;
	private Rua rua;

	public CEP getCep() {
		return cep;
	}
	
	public void setCep(CEP cep) {
		this.cep = cep;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Bairro getBairro() {
		return bairro;
	}
	
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	public Rua getRua() {
		return rua;
	}
	
	public void setRua(Rua rua) {
		this.rua = rua;
	}

	@Override
	public String toString() {
		return rua + ", " + bairro + ", " + cidade + ", " + cep;
	}
	
}
