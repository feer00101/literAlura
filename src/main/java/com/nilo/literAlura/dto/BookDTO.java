package com.nilo.literAlura.dto;

public record BookDTO(
        String title,
        String author,
        String idioma,
        Integer numeroDownloads,
        Integer birthYear,
        Integer deathYear) {

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;

    }

    public String getIdioma() {
        return idioma;
    }
}
