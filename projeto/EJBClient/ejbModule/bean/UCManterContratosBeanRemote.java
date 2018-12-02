package bean;

import javax.ejb.Remote;

import contrato.Contrato;

@Remote
public interface UCManterContratosBeanRemote {

	public void cadastrarContrato(Contrato contrato) throws Exception;
	public Contrato consultarContratoPorNumero(int numero) throws Exception;
	
}
