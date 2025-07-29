package arg.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa extends PanacheEntity {
    public String nome;
    public String email;
    public LocalDateTime createdAt;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, LocalDateTime createdAt) {
        this.nome = nome;
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
