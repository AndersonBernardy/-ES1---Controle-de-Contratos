package manager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import model.Cliente;
import pessoa.CPF;
import pessoa.Email;
import pessoa.EnderecoEspecifico;
import pessoa.RG;
import pessoa.Sexo;
import telefone.DDD;
import telefone.DDI;
import telefone.Telefone;
import util.validaException;

public class Client {

	public static void main(String[] args) {

		try {
			
			Registry registry = LocateRegistry.getRegistry(1099);
            UCManterClienteRMI stub = (UCManterClienteRMI) registry.lookup("ClienteManager");
            
            Cliente cliente = stub.obterClientePorCpf("07041605957");
            System.out.println(cliente);
            
            cliente = stub.obterClientePorCpf("10842088903");
            System.out.println(cliente);
            
            cliente = stub.obterClientePorCpf("06128022995");
            System.out.println(cliente);
            
            cliente = new Client().randomCliente();
            stub.cadastrarCliente(cliente);
            
		} catch (RemoteException e) {
			System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
	    } catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
	

	public Cliente randomCliente() throws validaException {
		Cliente cliente = new Cliente();

		cliente.setNome("José da Silva");

		ArrayList<Telefone> telefoneList = new ArrayList<Telefone>();
		Telefone telefone = new Telefone();
		DDI ddi = new DDI();
		ddi.setDdi("55");
		DDD ddd = new DDD();
		ddd.setDdd("45");
		telefone.setDdi(ddi);
		telefone.setDdd(ddd);
		telefone.setTelefone("99312-1232");
		telefoneList.add(telefone);
		cliente.setTelefoneList(telefoneList);

		ArrayList<Email> emailList = new ArrayList<Email>();
		Email email = new Email();
		email.setEmail("josedasilva@gmail.com");
		emailList.add(email);
		cliente.setEmailList(emailList);

		RG rg = new RG();
		rg.setRg("229170316");
		cliente.setRg(rg);

		CPF cpf = new CPF();
		cpf.setCpf("89424334052");
		cliente.setCpf(cpf);

		Sexo sexo = new Sexo();
		sexo.setSexo("Masculino");
		cliente.setSexo(sexo);

		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		enderecoEspecifico.setNumero(50);
		enderecoEspecifico.setComplemento("compl.");
		cliente.setEnderecoEspecifico(enderecoEspecifico);

		System.out.println(cliente);

		return cliente;
		
	} 

}
