package Sistema_Livraria.service;

import Sistema_Livraria.model.Autor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static Sistema_Livraria.utils.Utils.convertDate;
import static Sistema_Livraria.utils.Utils.checkName;


public class AutorService {
    private List<Autor> autors = new ArrayList<>();

    {
        Autor autor1 = new Autor("Andrey Lucca", LocalDate.of(2003, 3, 30));
        Autor autor2 = new Autor("Fernanda Montenegro", LocalDate.of(2003, 4, 23));
        Autor autor3 = new Autor("José Aldo", LocalDate.of(2001, 4, 25));

        autors.add(autor1);
        autors.add(autor2);
        autors.add(autor3);
    }


    public Autor registerAutor(String nome, String dataNascimento) {
        boolean isValidName = checkName(nome);
        if (!isValidName) {
            System.out.println("Input inválido, impossível prosseguir");
            return null;
        } else {
            LocalDate dataNascimentoFormatada = convertDate(dataNascimento);
            Autor autor = new Autor(nome, dataNascimentoFormatada);
            autors.add(autor);
            return autor;
        }
    }

    public List<Autor> listAutors() {
        return autors;
    }

    public Autor findAutorByName(String autorName) {
        Autor findedAutor = null;
        if (autors.isEmpty()) {
            System.out.println("Não há autores registrados ainda");
        } else {
            for (Autor autor : autors) {
                if (autor.getNome().equalsIgnoreCase(autorName)) {
                    findedAutor = autor;
                    break;
                }
            }
            if (findedAutor == null) {
                System.out.println("Não foi possível encontrar o autor: " + autorName);
            }
        }
        return findedAutor;
    }
}
