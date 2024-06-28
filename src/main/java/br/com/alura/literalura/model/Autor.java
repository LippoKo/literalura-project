package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    private String nome;
    private int dataDeNascimento;
    private int dataDeObito;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();


    public Autor() {
    }

    public Autor(DadosAutor data) {
        this.nome = data.nomeDoAutor();
        this.dataDeNascimento = data.anoDeNascimento();
        this.dataDeObito = data.anoDeObito();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(int dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getDataDeObito() {
        return dataDeObito;
    }

    public void setDataDeObito(int dataDeObito) {
        this.dataDeObito = dataDeObito;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        livros.forEach(l -> l.setAutor(this));
        this.livros = livros;
    }


    @Override
    public String toString() {
        return "====================================   A U T O R   ================================================================" + "\nNome: " + nome + "\nData De Nascimento: " + dataDeNascimento + "\nData De Obito: " + dataDeObito + "\n===================================================================================================================";
    }
}