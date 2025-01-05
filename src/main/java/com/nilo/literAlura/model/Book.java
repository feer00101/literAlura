package com.nilo.literAlura.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String title;

    String author;

    Integer birthYear;

    Integer deathYear;

    String idioma;

    Integer numeroDownloads;

    @ManyToAny
    private List<Author> authors = new ArrayList<>();

    public Book() {

    }

    public Book(DataBook dataBook) {

        this.title = dataBook.title();
        this.idioma = dataBook.idioma();
        this.numeroDownloads = dataBook.numeroDownload();
    }

    public Book(DataAuthor dataAuthor) {
        this.author = dataAuthor.name();
        this.birthYear = dataAuthor.birthYear();
        this.deathYear = dataAuthor.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "book [title=" + title + ", idioma=" + idioma + ", numeroDownloads="
                + numeroDownloads + "]";
    }
}
