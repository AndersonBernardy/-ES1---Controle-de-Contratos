package pessoa;

import java.io.Serializable;

import telefone.Telefone;

public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 2612904316583941854L;

	protected String nome;
	protected Email[] emailList;
	protected Telefone[] telefoneList;
	protected EnderecoEspecifico enderecoEspecifico;

	public Email[] getEmailList() {
		return emailList;
	}

	public void setEmailList(Email[] emailList) {
		this.emailList = emailList;
	}

	public Telefone[] getTelefoneList() {
		return telefoneList;
	}

	public void setTelefoneList(Telefone[] telefoneList) {
		this.telefoneList = telefoneList;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnderecoEspecifico getEnderecoEspecifico() {
		return enderecoEspecifico;
	}

	public void setEnderecoEspecifico(EnderecoEspecifico enderecoEspecifico) {
		this.enderecoEspecifico = enderecoEspecifico;
	}

	@Override
	public String toString() {
		String pessoa = nome + "\n";
		pessoa += "\n" + enderecoEspecifico + "\n";
		pessoa += "\nEmails: \n";
		for (Email email : emailList) {
			if (email != null) {
				pessoa += email + "\n";
			}
		}
		pessoa += "\nTelefones: \n";
		for (Telefone telefone : telefoneList) {
			if (telefone != null) {
				pessoa += telefone + "\n";
			}
		}
		return pessoa;
	}

}
