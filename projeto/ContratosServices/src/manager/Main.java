package manager;

import java.sql.Date;

import cliente.Cliente;
import contrato.Contrato;
import contrato.TipoContrato;
import pessoa.CPF;
import pessoa.PessoaFisica;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Contrato contrato = new Contrato();
		contrato.setCliente(new Cliente());
		contrato.getCliente().setPessoa(new PessoaFisica());
		CPF cpf = new CPF();
		cpf.setCpf("07041605957");
		((PessoaFisica) contrato.getCliente().getPessoa()).setCpf(cpf);
		contrato.setDataEmissao(new Date(118, 11, 27));
		contrato.setInicioValidade(new Date(118, 11, 27));
		contrato.setFimValidade(new Date(118, 11, 30));
		TipoContrato tipoContrato = new TipoContrato();
		tipoContrato.setTipo("Prestação de Serviços");
		contrato.setTipoContrato(tipoContrato);
		contrato.setValor(10);
		contrato.setDescricao("DESCRICAO");

		
		UCManterContratosManager manager = new UCManterContratosManager();
		
		manager.cadastrarContrato(contrato);
		System.out.println(manager.consultarContratoPorNumero(123));
		
		
	}

}
