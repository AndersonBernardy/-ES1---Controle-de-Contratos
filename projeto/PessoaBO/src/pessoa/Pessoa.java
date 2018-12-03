package pessoa;

import java.io.Serializable;
import java.util.List;

import telefone.Telefone;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 2612904316583941854L;

	protected String nome;
	protected List<Email> emailList;
	protected List<Telefone> telefoneList;
	protected EnderecoEspecifico enderecoEspecifico;

	public List<Email> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<Email> emailList) {
		this.emailList = emailList;
	}

	public List<Telefone> getTelefoneList() {
		return telefoneList;
	}

	public void setTelefoneList(List<Telefone> telefoneList) {
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
			pessoa += email + "\n";
		}
		pessoa += "\nTelefones: \n";
		for (Telefone telefone : telefoneList) {
			pessoa += telefone + "\n";
		}
		return pessoa;
	}

}
