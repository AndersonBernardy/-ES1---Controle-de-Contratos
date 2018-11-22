package manager;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {

	public static void main(String[] args) {

		try {
			UCManterEnderecoManager enderecoPorCep = new UCManterEnderecoManager();
			UCManterEnderecoRMI enderecoPorCepStub = (UCManterEnderecoRMI) 
					UnicastRemoteObject.exportObject(enderecoPorCep, 0);

			// Bind the remote object's stub in the registry
			java.rmi.registry.LocateRegistry.createRegistry(1100);
			Registry registry = LocateRegistry.getRegistry(1100);

			registry.bind("EnderecoManager", enderecoPorCepStub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}

	}

}
