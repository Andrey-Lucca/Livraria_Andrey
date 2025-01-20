package Sistema_Livraria.service;

import Sistema_Livraria.model.Cliente;
import Sistema_Livraria.model.Emprestimo;
import Sistema_Livraria.model.Livro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class EmprestimoService {
    List<Emprestimo> lendings = new ArrayList<>();

    public Livro rentBook(List<Livro> books, String bookName, Cliente client) {
        Livro wantedBook = null;
        for (Livro book : books) {
            if (bookName.equalsIgnoreCase(book.getTitle())) {
                wantedBook = book;
            }
        }
        if (wantedBook == null) {
            System.out.println("Livro não encontrado");
            return null;
        }
        System.out.println("Livro: + " + wantedBook.getTitle() + " emprestado ao cliente: " + client.getNome());
        LocalDateTime currentData = LocalDateTime.now();
        LocalDateTime devolutionDate = currentData.plusDays(7);

        Emprestimo lending = new Emprestimo(wantedBook, client, devolutionDate);
        //System.out.println("Livro: " + wantedBook.getTitle());
        //System.out.println("Cliente: " + clientName);
        //System.out.println("Data de devolução: " + devolutionDate);
        lendings.add(lending);
        return wantedBook;
    }

    public List<Emprestimo> getLendings() {
        if (lendings.isEmpty()) {
            System.out.println("Não existem empréstimos disponiveis");
        }
        return lendings;
    }

    public Emprestimo returnLoan(String bookName, String clientEmail) {
        Emprestimo lending = null;
        for (Emprestimo lendingSearch : lendings) {
            if (lendingSearch.getLivro().getTitle().equalsIgnoreCase(bookName) && lendingSearch.getCliente().getEmail().equals(clientEmail)) {
                lending = lendingSearch;
                break;
            }
        }
        if (lending == null) {
            System.out.println("Não foi possível encontrar o empréstimo em questão");
        } else {
            lending.setDataDevolucaoEfetiva(LocalDateTime.now());
            System.out.println("Devolução realizar");
        }
        return lending;
    }

    public void getClientLending(String email) {
        List<Emprestimo> clientLendings = lendings.stream().filter(lendings -> lendings.getCliente().getEmail().equals(email)).collect(Collectors.toList());
        clientLendings.forEach((lending) -> {
            String devolutionDate = lending.getDataDevolucaoEfetiva() != null ? lending.getDataDevolucaoEfetiva().toString() : "Não houve devolução";
            if (clientLendings.isEmpty()) {
                System.out.println("Não existem empréstimos vinculados a esse e-mail");
            } else {
                System.out.println("Livro: " + lending.getLivro().getTitle());
                System.out.println("Data de devolução prevista: " + lending.getDataDevolucaoPrevista());
                System.out.println("Data de devolução efetivada: " + devolutionDate);
            }
        });
    }
}
