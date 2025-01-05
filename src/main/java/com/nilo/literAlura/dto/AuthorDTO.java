package com.nilo.literAlura.dto;

public record AuthorDTO(
        String nome,
        String title,
        Integer dataNascimento,
        Integer dataFalecimento) {

}
