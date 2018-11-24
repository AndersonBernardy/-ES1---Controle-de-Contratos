package cliente;

import java.io.Serializable;

import pessoa.PessoaFisica;

public class Cliente extends PessoaFisica implements Serializable{
	
	private static final long serialVersionUID = -5457473960386228749L;
	
	private int quantidadeContratos;
	private int idCliente;
	
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
		return super.toString() + "\nQuantidade de Contratos: " + quantidadeContratos + "\n";
	}
	
}
