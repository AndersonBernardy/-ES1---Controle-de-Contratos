package manager;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {

	public static void main(String[] args) {

		try {
			UCManterClienteManager clienteManager = new UCManterClienteManager();
			UCManterClienteRMI clienteStub = (UCManterClienteRMI) 
					UnicastRemoteObject.exportObject(clienteManager, 0);

			// Bind the remote object's stub in the registry
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			Registry registry = LocateRegistry.getRegistry(1099);

			registry.bind("ClienteManager", clienteStub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}

	}

}
