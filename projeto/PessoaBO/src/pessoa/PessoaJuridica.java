package pessoa;

import java.io.Serializable;

import telefone.Telefone;

public abstract class PessoaJuridica extends Pessoa implements Serializable {

	private static final long serialVersionUID = -6250188282115889307L;
	
	protected CNPJ cnpj;

	public PessoaJuridica() {
		super();
	}
	
	public CNPJ getCnpj() {
		return cnpj;
	}

	public void setCnpj(CNPJ cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		String pessoa = nome + ", CNPJ: " + cnpj + "\n";
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
