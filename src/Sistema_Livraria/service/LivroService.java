package Sistema_Livraria.service;

import Sistema_Livraria.controller.AutorController;
import Sistema_Livraria.model.Autor;
import Sistema_Livraria.model.Livro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LivroService {

    private List<Livro> books = new ArrayList<>();

    public Livro registerBook(String title, Autor autor) {
        Livro book = new Livro(title, autor);
        books.add(book);
        return book;
    }

    public void findBook(String title){
        Livro wishedBook = null;
        for (Livro book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                wishedBook = book;
            }
        }
        if(wishedBook == null){
            System.out.println("Não foi possível encontrar esse livro");
        }else{
            System.out.println("Livro: " + wishedBook.getTitle());
            System.out.println("Autor: " + wishedBook.getAutor().getNome());
        }
    }

    public List<Livro> getAllAvaliableBook() {
        List<Livro> avaliableBooks = new ArrayList<>();
        for (Livro book : books) {
            if (book.isAvailable()) {
                avaliableBooks.add(book);
            }
        }
        if(avaliableBooks.isEmpty()){
            System.out.println("Não existem mais livros disponíveis para alugar");
        }
        return avaliableBooks;
    }

    public void setBookRent(Livro bookToRent) {
        for (Livro book : books) {
            if (book.getId().equals(bookToRent.getId())) {
                book.setAvailable(false);
                book.setModificationDate(LocalDateTime.now());
                System.out.println("O livro: " + book.getTitle() + " agora está indisponível para alugar.");
                return;
            }
        }
        System.out.println("Erro: Livro não encontrado na lista.");
    }

    public void bookDevolution(Livro bookToDevolution){
        for(Livro book : books){
            if(book.getId().equals(bookToDevolution.getId())){
                book.setAvailable(true);
                book.setModificationDate(LocalDateTime.now());
                System.out.println("O livro " + book.getTitle() + " agora está disponível para aluguel");
                return;
            }
        }
        System.out.println("Erro: Livro não encontrado na lista.");
    }

}
