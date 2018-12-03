<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Consultar Contrato</title>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

  </head>
<body>
		<form id="form" class="form-horizontal" action="Servlet"  method="GET">
			
			<legend>Consultar Contrato</legend>
						
			<div class="form-group">
			  <label class="col-md-4 control-label" for="Nro Contrato">Número contrato</b></label>  
			  <div class="col-md-4">
			  <input id="Nro Contrato" name="numContrato" type="text" placeholder="" class="form-control input-md" required="">
			  
			  <br>
			  <!-- Button (Double) -->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="button1id"></label>
				  <div class="col-md-8">
				    <button id="button1id" name="button1id" class="btn btn-danger"><a href="index.jsp">Cancelar</a></button>
				    <button type="submit" id="button2id" class="btn btn-success">Enviar</button>
				  </div>
				</div>
			   
			  </div>
			</div>
			
		</form>	
</body>
</html>