package Sistema_Livraria.service;

import Sistema_Livraria.model.Cliente;

import java.util.ArrayList;
import java.util.List;

import static Sistema_Livraria.utils.Utils.checkName;
import static Sistema_Livraria.utils.Utils.checkEmail;

public class ClienteService {

    List<Cliente> clients = new ArrayList<>();

    {
        Cliente cliente1 = new Cliente("Drey", "drey_lucca@email.com");
        Cliente cliente2 = new Cliente("Andrey", "andrey_lucca@email.com");
        Cliente cliente3 = new Cliente("Harry", "harry@email.com");

        clients.add(cliente1);
        clients.add(cliente2);
        clients.add(cliente3);
    }

    public void registerClient(String nome, String email) {
        boolean isNameValid = checkName(nome);
        boolean isEmailValid = checkEmail(email);
        if (!isNameValid || !isEmailValid) {
            System.out.println("Houve um problema ao inserir tentar cadastrar seu nome ou e-mail, verifique-os e tente novamente");
        } else {
            Cliente client = new Cliente(nome, email);
            clients.add(client);
            System.out.println("Cliente cadastrado com sucesso:");
            System.out.println("Nome: " + client.getNome());
            System.out.println("Email: " + client.getEmail());
            System.out.println("---------------------------");
        }
    }

    public List<Cliente> getClients() {
        if (clients.isEmpty()) {
            System.out.println("Não há clientes cadastrados");
        } else {
            clients.forEach(client -> {
                System.out.println("Nome do cliente: " + client.getNome());
                System.out.println("E-mail: " + client.getEmail());
                System.out.println("---------------------------");
            });
        }
        return clients;
    }

    public Cliente findClientByEmail(String email) {
        Cliente foundedCliente = null;
        for (Cliente cliente : clients) {
            if (email.equals(cliente.getEmail())) {
                foundedCliente = cliente;
                break;
            }
        }
        return foundedCliente;
    }
}
