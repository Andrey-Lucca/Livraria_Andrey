package Sistema_Livraria.view;

import Sistema_Livraria.controller.AutorController;
import Sistema_Livraria.controller.ClienteController;
import Sistema_Livraria.controller.EmprestimoController;
import Sistema_Livraria.controller.LivroController;
import Sistema_Livraria.model.Autor;
import Sistema_Livraria.model.Cliente;
import Sistema_Livraria.model.Emprestimo;
import Sistema_Livraria.model.Livro;

import java.util.List;
import java.util.Scanner;

public class MainLivraria {
    public static void main(String[] args) {
        AutorController autorController = new AutorController();
        LivroController livroController = new LivroController();
        EmprestimoController emprestimoController = new EmprestimoController();
        ClienteController clienteController = new ClienteController();
        int clientDecision = -1;
        while (clientDecision != 0) {
            System.out.println("Bem vindo ao sistema de livraria, escolha uma das opções abaixo");
            System.out.println("1 - Adicionar um autor");
            System.out.println("2 - Listar autores");
            System.out.println("3 - Adicionar um livro");
            System.out.println("4 - Alugar um livro");
            System.out.println("5 - Mostrar livros disponíveis");
            System.out.println("6 - Mostrar empréstimos");
            System.out.println("7 - Registrar cliente");
            System.out.println("8 - Mostrar clientes");
            System.out.println("9 - Ver meus empréstimos");
            System.out.println("10 - Devolver um livro");
            System.out.println("11 - Consultar um livro");
            
            Scanner scanner = new Scanner(System.in);
            clientDecision = scanner.nextInt();
            switch (clientDecision) {
                case 1:
                    autorController.registerAutor();
                    break;
                case 2:
                    autorController.listAutors();
                    break;
                case 3:
                    Autor autor = autorController.findAutorByName();
                    livroController.registerBook(autor);
                    break;
                case 4:
                    List<Livro> books = livroController.getAllAvaliableBook();
                    Cliente client = clienteController.findClientByEmail();
                    if (client != null) {
                        Livro bookToRemove = emprestimoController.rentBook(books, client);
                        if (bookToRemove != null && client != null) {
                            livroController.setBookRent(bookToRemove);
                        } else {
                            System.out.println("Não foi possível adicionar o livro desejado");
                        }
                    }else{
                        System.out.println("CLiente não encontrado");
                    }
                    break;
                case 5:
                    livroController.getAllAvaliableBook();
                    break;
                case 6:
                    emprestimoController.getLendings();
                    break;
                case 7:
                    clienteController.registerClient();
                    break;
                case 8:
                    clienteController.getClients();
                    break;
                case 9:
                    emprestimoController.getClientLending();
                    break;
                case 10:
                    Emprestimo lending = emprestimoController.returnLoan();
                    if(lending != null){
                        Livro book = lending.getLivro();
                        livroController.bookDevolution(book);
                    }
                    break;
                case 11:
                    livroController.findBook();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
            }

        }
    }
}
