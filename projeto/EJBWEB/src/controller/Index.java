package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UCManterContratosBeanRemote;
import cliente.Cliente;
import contrato.Contrato;
import contrato.TipoContrato;
import manager.UCManterContratosManager;
import pessoa.CPF;
import pessoa.PessoaFisica;

@WebServlet("/")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UCManterContratosBeanRemote managerBean;

	public Index() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String param = request.getParameter("id");
			int id = Integer.parseInt(param);
			PrintWriter out = response.getWriter();

			out.println(managerBean.consultarContratoPorNumero(id));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
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
			contrato.setNumero(12);
			
			UCManterContratosManager manager = new UCManterContratosManager();
			
			manager.cadastrarContrato(contrato);
			
		} catch (Exception e) {
		
		}

	}

}
