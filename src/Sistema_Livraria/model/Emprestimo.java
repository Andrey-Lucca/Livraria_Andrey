package Sistema_Livraria.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Emprestimo {
    private UUID id;
    private Livro livro;
    private Autor autor;
    private Cliente cliente;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucaoPrevista;
    private LocalDateTime dataDevolucaoEfetiva;

    public Emprestimo(Livro livro, Cliente cliente, LocalDateTime dataDevolucaoPrevista) {
        this.id = UUID.randomUUID();
        this.livro = livro;
        this.autor = livro.getAutor();
        this.cliente = cliente;
        this.dataEmprestimo = LocalDateTime.now();
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDateTime getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva;
    }

    public void setDataDevolucaoEfetiva(LocalDateTime dataDevolucaoEfetiva) {
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }
}
