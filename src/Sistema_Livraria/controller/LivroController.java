package Sistema_Livraria.controller;

import Sistema_Livraria.model.Autor;
import Sistema_Livraria.model.Livro;
import Sistema_Livraria.service.AutorService;
import Sistema_Livraria.service.LivroService;

import java.util.List;
import java.util.Scanner;

public class LivroController {
    private LivroService livroService = new LivroService();

    public void registerBook(Autor autor) {
        try {
            if (autor != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o nome do livro");
                String bookName = scanner.nextLine();
                Livro book = livroService.registerBook(bookName, autor);
                System.out.println("Livro adicionado com sucesso");
                System.out.println("Nome livro: " + book.getTitle());
                System.out.println("Autor do livro: " + book.getAutor().getNome());
                System.out.println("Data de cadastro: " + book.getRegistrationDate());
            } else {
                System.out.println("Autor não encontrado");
            }

        } catch (IllegalArgumentException error) {
            System.out.println("Ocorreu um erro ao adicionar o livro");
        }
    }

    public void findBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do livro que deseja consultar");
        String bookName = scanner.nextLine();
        livroService.findBook(bookName);
    }

    public List<Livro> getAllAvaliableBook() {
        List<Livro> books = livroService.getAllAvaliableBook();
        for (Livro book : books) {
            System.out.println("Nome do Livro: " + book.getTitle() + " Autor: " + book.getAutor().getNome());
            System.out.println("------------------------");
        }
        return books;
    }

    public void setBookRent(Livro bookToRemove) {
        livroService.setBookRent(bookToRemove);
    }

    public void bookDevolution(Livro bookToDevolution) {
        livroService.bookDevolution(bookToDevolution);
    }
}
