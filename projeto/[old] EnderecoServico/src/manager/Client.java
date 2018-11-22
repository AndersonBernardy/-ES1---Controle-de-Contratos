package manager;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import endereco.Endereco;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry(1100);
            UCManterEnderecoRMI stub = (UCManterEnderecoRMI) registry.lookup("EnderecoManager");
            
            Endereco endereco = stub.obterEnderecoPorCep("85863-610");
            
            System.out.println(endereco);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}