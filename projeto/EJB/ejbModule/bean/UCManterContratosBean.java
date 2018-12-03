package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import contrato.Contrato;
import manager.UCManterContratosManager;

@Stateless
@LocalBean
public class UCManterContratosBean implements UCManterContratosBeanRemote{

    public UCManterContratosBean() {
        
    }

	public void cadastrarContrato(Contrato contrato) throws Exception {
		UCManterContratosManager manager = new UCManterContratosManager();
		manager.cadastrarContrato(contrato);
	}
	
	public Contrato consultarContratoPorNumero(int numero) throws Exception {
		UCManterContratosManager manager = new UCManterContratosManager();
		Contrato contrato = manager.consultarContratoPorNumero(numero);
		return contrato;
	}
    
}
