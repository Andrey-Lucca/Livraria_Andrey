package Sistema_Livraria.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Livro {
    private UUID id;
    private String title;
    private Autor autor;
    private boolean available;
    private LocalDateTime registrationDate;
    private LocalDateTime modificationDate;

    public Livro(String title, Autor autor) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.autor = autor;
        this.available = true;
        this.registrationDate = LocalDateTime.now();
        this.modificationDate = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }
}
