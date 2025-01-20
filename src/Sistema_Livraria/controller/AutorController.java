package Sistema_Livraria.controller;

import Sistema_Livraria.model.Autor;
import Sistema_Livraria.service.AutorService;

import java.util.List;
import java.util.Scanner;

public class AutorController {
    private Scanner scanner = new Scanner(System.in);

    private AutorService autorService = new AutorService();
    private LivroController livroController;


    public void registerAutor() {
        System.out.println("Digite o nome do autor");
        String nome = scanner.nextLine();

        System.out.println("Digite a data de nascimento do autor (dd/MM/yyyy): ");
        String dataNascimento = scanner.nextLine();

        try {
            Autor autor = autorService.registerAutor(nome, dataNascimento);
            if(autor != null){
                System.out.println("Nome autor: " + autor.getNome());
                System.out.println("Data de nascimento autor :" + autor.getDataNascimento());
                System.out.println("Autor registrado com sucesso");
            }
        } catch (IllegalArgumentException error) {
            System.out.println("Erro ao registrar autor: " + error.getMessage());
        }
    }

    public void listAutors() {
        List<Autor> autors = autorService.listAutors();
        if (autors.isEmpty()) {
            System.out.println("Nenhum autor registrado ainda");
        } else {
            System.out.println("Autores registrados:");
            autors.forEach(autor -> {
                System.out.println("Id: " + autor.getId());
                System.out.println("Nome: " + autor.getNome());
                System.out.println("Data de Nascimento: " + autor.getDataNascimento());
                System.out.println("------------------");
            });
        }
    }

    public Autor findAutorByName(){
        System.out.println("Digite o nome do autor:");
        String autorName = scanner.nextLine();
        Autor autor = autorService.findAutorByName(autorName);
        return autor;
    }
}
