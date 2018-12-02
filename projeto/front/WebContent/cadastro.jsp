<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="pt">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Cadastrar Contrato</title>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

  </head>
  <body>
		<form id="form" class="form-horizontal" action="ServletCadastro"  method="POST">
			<!-- Form Name -->
			<legend>Cadastrar Contrato</legend>

			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="Nro Contrato">Num Contrato <b>(*)</b></label>  
			  <div class="col-md-4">
			  <input id="Nro Contrato" name="numContrato" type="text" placeholder="" class="form-control input-md" required="">
			    
			  </div>
			</div>

			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="textinput">Data Emissão <b>(*)</b></label>  
			  <div class="col-md-4">
			  <input id="dtEmissao" name="dtEmissao" type="text" class="form-control input-md date placeholder" required="">
			    
			  </div>
			</div>

			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="textinput">Validade <b>(*)</b></label>  
			  <div class="container col-md-4">
				  <input id="validadeInicio" name="validadeInicio" type="text" class="form-control input-md date placeholder" required="">
				  a
				  <input id="validadeFim" name="validadeFim" type="text" class="form-control input-md date placeholder" required="">
			  </div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="selectbasic">Tipo Contrato <b>(*)</b></label>
			  <div class="col-md-4">
			    <select id="selectbasic" name="tipoContrato" class="form-control">
			      <option value="1">Prestação Serviço</option>
			      <option value="2">Serviços Jurídicos</option>
			      <option value="3">Contratação mão de obra</option>
			    </select>
			  </div>
			</div>

			<hr>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">Nome <b>(*)</b></span>
			      <input id="prependedtext" name="nomeCliente" class="form-control" placeholder="" type="text" required="">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">CPF <b>(*)</b></span>
			      <input id="cpf" name="cpfCliente" class="form-control cpf" placeholder="" type="text">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">CNPJ <b>(*)</b></span>
			      <input id="cnpj" name="cnpjCliente" class="form-control cnpj" placeholder="" type="text">
			    </div>
			    
			  </div>
			</div>


			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">Email <b>(*)</b></span>
			      <input id="email1" name="email" class="form-control" placeholder="" type="text" required="">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">Email </span>
			      <input id="email2" name="emailOpcional" class="form-control" placeholder="" type="text">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">Telefone <b>(*)</b></span>
			      <input id="fone1" name="telefone" class="form-control phone_with_ddd" type="text" required="">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">Telefone</span>
			      <input id="fone2" name="telefoneOpcional" class="form-control phone_with_ddd" placeholder="" type="text">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">CEP <b>(*)</b></span>
			      <input id="cep" name="cep" class="form-control cep" placeholder="" type="text" required="">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">Cidade <b>(*)</b></span>
			      <input id="prependedtext" name="cidade" class="form-control" placeholder="" type="text" required="">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">Bairro <b>(*)</b></span>
			      <input id="prependedtext" name="bairro" class="form-control" placeholder="" type="text" required="">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">Rua <b>(*)</b></span>
			      <input id="prependedtext" name="rua" class="form-control" placeholder="" type="text" required="">
			    </div>
			    
			  </div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="prependedtext"></label>
			  <div class="col-md-4">
			    <div class="input-group">
			      <span class="input-group-addon">Num <b>(*)</b></span>
			      <input id="prependedtext" name="numCasa" class="form-control" placeholder="" type="text" required="">
			    </div>
			    
			  </div>
			</div>
			<hr>

			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="textinput">VALOR (R$) <b>(*)</b></label>  
			  <div class="col-md-4">
			  <input id="valor" name="total" type="text" class="form-control input-md money" required="">
			    
			  </div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="textarea">Descrição</label>
			  <div class="col-md-4">                     
			    <textarea class="form-control" id="textarea" name="descricao"></textarea>
			  </div>
			</div>

			<!-- Button (Double) -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="button1id"></label>
			  <div class="col-md-8">
			    <button id="button1id" name="button1id" class="btn btn-danger"><a href="index.jsp">Cancelar</a></button>
			    <button type="submit" id="button2id" name="button2id" class="btn btn-success">Enviar</button>
			  </div>
			</div>

		</form>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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

		  $( "#form" ).submit(function( event ) {
				
		  	var valor = $( "#valor" ).val();
		  	if(parseInt(valor) < 1){
		  		alert("O valor total deve ser maior que R$ 1,00");
		  	}

		  	var dtEmissao = $( "#dtEmissao" ).val();
		  	var validadeInicio = $( "#validadeInicio" ).val();
		  	var validadeFim = $( "#validadeFim" ).val();

		  	var cpf = $( "#cpf" ).val();
		  	var cnpj = $( "#cnpj" ).val();

		  	var cep = $( "#cep" ).val();

		  	var email2 = $( "#email2" ).val();
		  	var email2 = $( "#email2" ).val();

		  	var fone1 = $( "#fone1" ).val();
		  	var fone2 = $( "#fone2" ).val();

		    if ( (dtEmissao.length != 10) || (validadeInicio.length != 10) || (validadeInicio.length != 10) ) {
				event.preventDefault();
				alert("Data esta incorreta!");
		    }

			if ( (fone1.length != 15) ) {
				event.preventDefault();
				alert("O telefone esta incorreto!");
		    }
 	
		    if ( (fone2.length != 15) && (fone2.length != 0)) {
				event.preventDefault();
				alert("O telefone esta incorreto!");
		    }

	        if (cep.length != 9) {
		    	event.preventDefault();
				alert("O CEP esta incorreto!");
		    }

		    if(cpf){
			    if (cpf.length != 14) {
			    	event.preventDefault();
					alert("O CPF esta incorreto!");
			    }
			}else{
				if (cnpj.length != 18) {
			    	event.preventDefault();
					alert("O CNPJ esta incorreto!");
			    }
			}   
		   });
		});
    </script>
  </body>
</html>