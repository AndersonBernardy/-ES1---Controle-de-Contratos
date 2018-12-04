<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Resultado</title>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
	<style type="text/css">
		.search-table{
		    padding: 10%;
		    margin-top: -6%;
		}
		.search-list{
		    background: #fff;
		    border: 1px solid #ababab;
		    border-top: none;
		}
		.search-list h3{
		    background: #eee;
		    padding: 3%;
		    margin-bottom: 0%;
		}
	</style>
	<script>
	$(document).ready(function(){
		<%
			String numContrato = request.getParameter("numContrato");
		%>
		var contratoFake = (function () {
		  return {"cliente":{"pessoa":{"cpf":{"cpf":"07041605957"},"nome":"Anderson Bernardy Martinelli","emailList":[{"email":"andersonbernardy@outlook.com"}],"telefoneList":[{"ddd":{"ddd":"45"},"numeroTelefone":"998142342"}],"enderecoEspecifico":{"endereco":{"cep":{"cep":"85863610"},"cidade":{"nomeCidade":"Foz do Iguaçu","estado":{"nomeEstado":"Paraná","sigla":"PR","idEstado":1},"idCidade":1},"bairro":{"nomeBairro":"Parque Presidente II","idBairro":1},"rua":{"nomeRua":"Avenida Salvador","idRua":1},"idEndereco":1},"numero":31,"complemento":"Complemento"}},"quantidadeContratos":2,"idCliente":21},"tipoContrato":{"tipo":"Prestação de Serviços","idTipoContrato":1},"valor":10.0,"dataEmissao":"nov 25, 2018","inicioValidade":"nov 25, 2018","fimValidade":"dez 25, 2018","descricao":"descricao","numero":1};
		})();
		
		/*
		$.getJSON("demo_ajax_json.js", function(result){
            $.each(result, function(i, field){
                $("div").append(field + " ");
            });
        });
		*/
		
		console.log(contratoFake);
		
		$("#numContrato").html(contratoFake.numero);
		$("#idCliente").html(contratoFake.cliente.idCliente);
		$("#quantCont").html(contratoFake.cliente.quantidadeContratos);
		$("#cpf").html(contratoFake.cliente.pessoa.cpf.cpf);
		$("#emails").append("<td class='email'>"+contratoFake.cliente.pessoa.emailList[0].email+"</td> |")
		$("#telefones").append("<td class='phone_with_ddd'>"+contratoFake.cliente.pessoa.telefoneList[0].ddd.ddd+contratoFake.cliente.pessoa.telefoneList[0].numeroTelefone+"</td>");
		
		$("#endereco").append(contratoFake.cliente.pessoa.enderecoEspecifico.endereco.rua.nomeRua+", ");
		$("#endereco").append(contratoFake.cliente.pessoa.enderecoEspecifico.numero+" - ");
		$("#endereco").append(contratoFake.cliente.pessoa.enderecoEspecifico.endereco.bairro.nomeBairro	+". ");
		$("#endereco").append(contratoFake.cliente.pessoa.enderecoEspecifico.endereco.cidade.nomeCidade	+" - ");
		$("#endereco").append(contratoFake.cliente.pessoa.enderecoEspecifico.endereco.cidade.estado.nomeEstado);
		
		$("#cep").html(contratoFake.cliente.pessoa.enderecoEspecifico.endereco.cep.cep);
		$("#complemento").html(contratoFake.cliente.pessoa.enderecoEspecifico.complemento);
		
		$("#tipoContrato").html(contratoFake.tipoContrato.tipo);
		$("#descricao").html(contratoFake.descricao);
		$("#total").html(contratoFake.valor);
		
	});
	</script>
  </head>
<body>
    <div class="container search-table">
	    <div class="search-list">
		    <h3>Contrato Nº <span id="numContrato"></span></h3>
		    <table class="table" id="myTable">
		        <thead>
		            <tr>
		                <th>Dados do Cliente</th>
		            </tr>
		        </thead>
		        <tbody>
		        <tr>
		            <th>idCliente</td>
		            <td id="idCliente">0</td>
		        </tr>
		        <tr>
		            <th>Quantidade de Contratos</td>
		            <td id="quantCont"></td>
		        </tr>
		        <tr>
		            <th>CPF</td>
		            <td id="cpf" class="cpf"></td>
		        </tr>
		        <tr id="emails">
		            <th>Emails </th>
		            
		        </tr>
		        <tr id="telefones">
		            <th>Telefones</td>
		            
		        </tr>
		        <tr>
		            <th>Endereço</th>
		            <td id="endereco"></td>
		        </tr>
		        <tr>
		            <th>CEP</td>
		            <td id="cep" class="cep">85863610</td>
		        </tr>
		        <tr>
		            <th>Complemento</td>
		            <td id="complemento"></td>
		        </tr>
		        </tbody>
		    </table>
		    <table class="table" id="myTable">
		        <thead>
		            <tr>
		                <th>Dados do Contrato</th>
		            </tr>
		        </thead>
		        <tbody>
		        <tr>
		            <th>Emissão</td>
		            <td>nov 25, 2018</td>
		        </tr>
		        <tr>
		            <th>Inicio Validade</td>
		            <td>nov 25, 2018</td>
		        </tr>
		        <tr>
		            <th>Fim Validade</td>
		            <td>dez 25, 2018</td>
		        </tr>
		        <tr>
		            <th>Tipo</td>
		            <td id="tipoContrato">Prestação de Serviços</td>
		        </tr>
		        <tr>
		            <th>Descrição</td>
		            <td id="descricao">fodase</td>
		        </tr>
		        <tr>
		            <th>Valor</td>
		            <td id="total" class="money"></td>
		        </tr>
		        </tbody>
		    </table>
		</div>
	</div>
	<form id="form" class="form-horizontal" action="consulta.jsp">
		<button type="submit" class="btn btn-secondary">Voltar</button>
	</form>
	<script src="js/jQuery-Mask-Plugin-master/src/jquery.mask.js"></script>
    <script>
    	$(document).ready(function(){
			$('.date').mask('00/00/0000');
			  $('.time').mask('00:00:00');
			  $('.date_time').mask('00/00/0000 00:00:00');
			  $('.cep').mask('00000-000');
			  $('.phone').mask('0000-0000');
			  $('.phone_with_ddd').mask('(00) 00000-0000');
			  $('.phone_us').mask('(000) 000-0000');
			  $('.mixed').mask('AAA 000-S0S');
			  $('.cpf').mask('000.000.000-00', {reverse: true});
			  $('.cnpj').mask('00.000.000/0000-00', {reverse: true});
			  $('.money').mask('000.000.000.000.000,00', {reverse: true});	
			  $('.ip_address').mask('099.099.099.099');
			  $('.percent').mask('##0,00%', {reverse: true});
			  $('.clear-if-not-match').mask("00/00/0000", {clearIfNotMatch: true});
			  $('.placeholder').mask("00/00/0000", {placeholder: "__/__/____"});
			  $('.selectonfocus').mask("00/00/0000", {selectOnFocus: true});
    	}); 
	  </script>
</body>
</html>