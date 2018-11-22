package pessoa;

import java.io.Serializable;

import telefone.Telefone;

public abstract class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 3652474480541251574L;

	protected CPF cpf;

	public PessoaFisica() {
		super();
	}
	
	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		String pessoa = nome + "\n"
				+ "CPF: " + cpf + "\n";
		pessoa += "\n" + enderecoEspecifico + "\n";
		pessoa += "\nEmails: \n";		
		for (Email email : emailList) {
			pessoa += email + "\n";
		}
		pessoa += "\nTelefones: \n";
		for (Telefone telefone : telefoneList) {
			pessoa += telefone + "\n";
		}
		return pessoa;
	}
	
}
