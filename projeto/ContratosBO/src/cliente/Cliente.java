package cliente;

import java.io.Serializable;

import pessoa.Pessoa;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 2209281355099449742L;

	Pessoa pessoa;
	private int quantidadeContratos;
	private int idCliente;
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getQuantidadeContratos() {
		return quantidadeContratos;
	}

	public void setQuantidadeContratos(int quantidadeContratos) {
		this.quantidadeContratos = quantidadeContratos;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return pessoa + "\nQuantidade de Contratos: " + quantidadeContratos + "\n";
	}
	
}
