package Sistema_Livraria.controller;

import Sistema_Livraria.model.Cliente;
import Sistema_Livraria.model.Emprestimo;
import Sistema_Livraria.model.Livro;
import Sistema_Livraria.service.EmprestimoService;

import java.util.List;
import java.util.Scanner;

public class EmprestimoController {
    EmprestimoService emprestimoService = new EmprestimoService();

    public Livro rentBook(List<Livro> books, Cliente client) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do livro");
            String nomeLivro = scanner.nextLine();
            Livro wantedBook = emprestimoService.rentBook(books, nomeLivro, client);
            if(wantedBook != null){
                return wantedBook;
            }
        } catch (IllegalArgumentException error) {
            System.out.println("Ocorreu um erro ao realizar empréstimo");
        }
        return null;
    }

    public void getLendings() {
        System.out.println("Mostrando empréstimos:");
        List<Emprestimo> lendings = emprestimoService.getLendings();
        for (Emprestimo lending : lendings) {
            System.out.println("Livro: " + lending.getLivro().getTitle());
            System.out.println("Cliente: " + lending.getCliente().getNome());
            System.out.println("Data de devolução: " + lending.getDataDevolucaoPrevista());
            String devolucao = lending.getDataDevolucaoEfetiva() != null
                    ? lending.getDataDevolucaoEfetiva().toString()
                    : "Ainda não houve devolução";
            System.out.println("Data de devolução efetivada: " + devolucao);
            System.out.println("------------------------------");
        }
    }

    public Emprestimo returnLoan(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do livro emprestado:");
        String bookName = scanner.nextLine();
        System.out.println("Digite seu e-mail:");
        String email = scanner.nextLine();
        Emprestimo lending = emprestimoService.returnLoan(bookName, email);
        return lending;
    }

    public void getClientLending(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu e-mail para ver seus empréstimos");
        String email = scanner.nextLine();
        emprestimoService.getClientLending(email);
    }
}
