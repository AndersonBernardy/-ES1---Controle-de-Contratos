package webservices;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import contrato.Contrato;
import manager.UCManterContratosManager;

@Path("/contrato")
public class UCManterContratoServices {

	UCManterContratosManager manager = new UCManterContratosManager();
	Gson gson = new GsonBuilder().setDateFormat("MMM d, yyyy").create();

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String consultarPorNumero(@PathParam("id") int id) throws Exception {

		Contrato contrato = manager.consultarContratoPorNumero(id);
		String json = gson.toJson(contrato);
		
		return json;
		
		
	}

	@PUT
	@Path("/")
	@Produces("application/json")
	public String cadastrarContrato() throws Exception {

		String json = "{\"cliente\":{\"pessoa\":{\"cpf\":{\"cpf\":\"07041605957\"},\"nome\":\"Anderson Bernardy Martinelli\",\"emailList\":[{\"email\":\"andersonbernardy@outlook.com\"}],\"telefoneList\":[{\"ddd\":{\"ddd\":\"45\"},\"numeroTelefone\":\"998142342\"}],\"enderecoEspecifico\":{\"endereco\":{\"cep\":{\"cep\":\"85863610\"},\"cidade\":{\"nomeCidade\":\"Foz do Iguaçu\",\"estado\":{\"nomeEstado\":\"Paraná\",\"sigla\":\"PR\",\"idEstado\":1},\"idCidade\":1},\"bairro\":{\"nomeBairro\":\"Parque Presidente II\",\"idBairro\":1},\"rua\":{\"nomeRua\":\"Avenida Salvador\",\"idRua\":1},\"idEndereco\":1},\"numero\":31,\"complemento\":\"Complemento\"}},\"quantidadeContratos\":2,\"idCliente\":0},\"tipoContrato\":{\"tipo\":\"Prestação de Serviços\",\"idTipoContrato\":1},\"valor\":10.0,\"dataEmissao\":\"nov 25, 2018\",\"inicioValidade\":\"nov 25, 2018\",\"fimValidade\":\"dez 25, 2018\",\"descricao\":\"descricao\",\"numero\":1}";
		Contrato contrato = gson.fromJson(json, Contrato.class);
		manager.cadastrarContrato(contrato);

		return "hello";
	}

}
