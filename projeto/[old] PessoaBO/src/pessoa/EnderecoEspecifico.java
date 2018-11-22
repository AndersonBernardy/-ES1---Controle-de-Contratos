package pessoa;

import java.io.Serializable;

import endereco.Endereco;

public class EnderecoEspecifico implements Serializable {

	private static final long serialVersionUID = 3910455323289432746L;
	
	private Endereco endereco;
	private int numero;
	private String complemento;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return endereco + "\nnº" + numero + ", " + complemento;
	}
	
}
