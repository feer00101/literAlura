package com.nilo.literAlura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nilo.literAlura.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findAll();

    List<Book> findByIdioma(String idioma);

    @Query("SELECT b FROM Book b WHERE b.birthYear <= :deathYear AND (b.deathYear >= :deathYear OR b.deathYear  IS NULL)")
    public List<Book> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqualOrDeathYearIsNull(Integer birthYear, Integer deathYear);

    List<Book> findByAuthorContainingIgnoreCase(String author);
}
