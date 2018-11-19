package pessoa;

import java.io.Serializable;

import telefone.Telefone;

public abstract class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = -4581412340466637820L;
	
	protected CPF cpf;
	protected RG rg;
	protected Sexo sexo;

	public PessoaFisica() {
		super();
	}
	
	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public RG getRg() {
		return rg;
	}

	public void setRg(RG rg) {
		this.rg = rg;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		String pessoa = nome + ", " + sexo + "\n"
				+ "CPF: " + cpf + ", RG: " + rg + "\n";
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
