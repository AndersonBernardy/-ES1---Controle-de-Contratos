
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cliente.Cliente;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numContrato = request.getParameter("numContrato");
		
		request.getRequestDispatcher("resultadoPesquisa.jsp?numContrato="+numContrato).forward(request, response);
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numContrato = request.getParameter("numContrato");
		String dtEmissao = request.getParameter("dtEmissao");
		String validadeInicio = request.getParameter("validadeInicio");
		String validadeFim = request.getParameter("validadeFim");
		String tipoContrato = request.getParameter("tipoContrato");
		String nomeCliente = request.getParameter("nomeCliente");
		String cpfCliente = request.getParameter("cpfCliente");
		String cnpjCliente = request.getParameter("cnpjCliente");
		String email = request.getParameter("email");
		String emailOpcional = request.getParameter("emailOpcional");
		String telefone = request.getParameter("telefone");
		String telefoneOpcional = request.getParameter("telefoneOpcional");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String rua = request.getParameter("rua");
		String numCasa = request.getParameter("numCasa");
		String descricao = request.getParameter("descricao");
		String total = request.getParameter("total");
		
		Cliente c = new Cliente();
		
		
		if(1==1) {
			response.sendRedirect("sucessoCadastro.jsp");
		}else {
			response.sendRedirect("falhaCadastro.jsp");
		}
	
	}

}
