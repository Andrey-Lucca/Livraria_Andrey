package Sistema_Livraria.controller;

import Sistema_Livraria.model.Cliente;
import Sistema_Livraria.service.ClienteService;

import java.util.List;
import java.util.Scanner;

public class ClienteController {

    ClienteService clienteService = new ClienteService();

    public void registerClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de cliente");
        System.out.println("Digite seu nome");
        String clientName = scanner.nextLine();
        System.out.println("Digite seu email. Exemplo: email@email.com");
        String email = scanner.nextLine();
        try {
            clienteService.registerClient(clientName, email);
        } catch (Exception error) {
            System.out.println("Não foi possível realizar o cadastro no sistema, ocorreu um erro inesperado");
        }
    }

    public List<Cliente> getClients() {
        List<Cliente> clients = clienteService.getClients();
        return clients;
    }

    public Cliente findClientByEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para alugar o livro, informe seu e-mail");
        String email = scanner.nextLine();
        try {
            Cliente client = clienteService.findClientByEmail(email);
            return client;
        } catch (Exception error) {
            System.out.println("Ocorreu algum erro ao buscar um cliente");
            return null;
        }
    }
}
