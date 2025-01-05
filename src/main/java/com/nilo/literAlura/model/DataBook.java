package com.nilo.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
        @JsonAlias("title")
        String title,
        @JsonAlias("idioma")
        String idioma,
        @JsonAlias("download_count")
        Integer numeroDownload) {

}
