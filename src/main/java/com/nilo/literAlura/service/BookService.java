package com.nilo.literAlura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilo.literAlura.dto.BookDTO;
import com.nilo.literAlura.model.Book;
import com.nilo.literAlura.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repositoryBook;

    private List<BookDTO> converteDados(List<Book> book) {
        return book.stream()
                .map(b -> new BookDTO(b.getTitle(), b.getAuthor(), b.getIdioma(), b.getNumeroDownloads(), b.getBirthYear(), b.getDeathYear()))
                .collect(Collectors.toList());
    }

    public List<BookDTO> obterTodosOsLivros() {
        return converteDados(repositoryBook.findAll());
    }

    public List<BookDTO> obterPorTitulo(String title) {
        return converteDados(repositoryBook.findByTitleContainingIgnoreCase(title));
    }

    public List<BookDTO> obterPorIdioma(String idioma) {
        return converteDados(repositoryBook.findByIdioma(idioma));
    }

    public List<BookDTO> obterAutoresVivosEmDeterminadoAno(Integer dataNascimento, Integer dataFalecimento) {
        return converteDados(repositoryBook.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqualOrDeathYearIsNull(dataNascimento, dataFalecimento));

    }
}
