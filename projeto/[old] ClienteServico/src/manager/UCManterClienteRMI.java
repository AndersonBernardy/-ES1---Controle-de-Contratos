package manager;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Cliente;
import util.validaException;

public interface UCManterClienteRMI extends Remote {

	public void cadastrarCliente(Cliente cliente) throws RemoteException;
	public Cliente obterClientePorCpf(String cpf) throws validaException, RemoteException;

}
