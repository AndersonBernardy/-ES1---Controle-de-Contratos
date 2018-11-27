package col.contrato;

import java.sql.Connection;
import java.sql.SQLException;

import cliente.Cliente;
import col.cliente.COLCliente;
import contrato.Contrato;
import contrato.TipoContrato;
import dao.cliente.DAOCliente;
import dao.contrato.DAOContrato;
import dao.contrato.DAOTipoContrato;
import pessoa.CNPJ;
import pessoa.CPF;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import util.NegocioException;
import util.PessoaException;

public class COLContrato {

	public Contrato consultarContrato(Connection connection, int numero)
			throws SQLException, PessoaException, NegocioException {
		DAOContrato daoContrato = new DAOContrato();
		Contrato contrato = daoContrato.selectContrato(connection, numero);

		DAOTipoContrato daoTipoContrato = new DAOTipoContrato();
		TipoContrato tipoContrato = daoTipoContrato.selectTipoContrato(connection,
				contrato.getTipoContrato().getIdTipoContrato());
		contrato.setTipoContrato(tipoContrato);

		COLCliente colCliente = new COLCliente();
		Cliente cliente = colCliente.consultarCliente(connection, contrato.getCliente().getIdCliente());
		contrato.setCliente(cliente);

		return contrato;
	}

	public void cadastrarContrato(Connection connection, Contrato contrato) throws SQLException, NegocioException {
		DAOCliente daoCliente = new DAOCliente();
		DAOContrato daoContrato = new DAOContrato();
		DAOTipoContrato daoTipoContrato = new DAOTipoContrato();
		Pessoa cliente = contrato.getCliente().getPessoa();
		int idCliente;
		int idTipoContrato;

		if (cliente instanceof PessoaFisica) {

			CPF cpf = ((PessoaFisica) cliente).getCpf();
			idCliente = daoCliente.selectIdCliente(connection, cpf);

		} else if (cliente instanceof PessoaJuridica) {

			CNPJ cnpj = ((PessoaJuridica) cliente).getCnpj();
			idCliente = daoCliente.selectIdCliente(connection, cnpj);

		} else {

			throw new NegocioException("Objeto inválido: Cliente");

		}

		idTipoContrato = daoTipoContrato.getidTipoContrato(connection, contrato.getTipoContrato().getTipo());

		contrato.getTipoContrato().setIdTipoContrato(idTipoContrato);
		contrato.getCliente().setIdCliente(idCliente);

		if(daoContrato.selectContrato(connection, contrato.getNumero()) != null) {
			throw new NegocioException("Um contrato com este numero ja esta cadastrado.");
		}
		
		if (daoContrato.verificaQuantidadeContratosPeriodo(connection, contrato)) {
			daoContrato.InsertContrato(connection, contrato);
		} else {
			throw new NegocioException("Não é possivel cadastrar mais que três contratos durante o mesmo periodo");
		}

	}

}
