package manager;

import java.rmi.Remote;
import java.rmi.RemoteException;

import endereco.Endereco;

public interface UCManterEnderecoRMI extends Remote {

	public Endereco obterEnderecoPorCep(String cep) throws RemoteException;
	
}
