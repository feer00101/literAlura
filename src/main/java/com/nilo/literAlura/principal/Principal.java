package com.nilo.literAlura.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.nilo.literAlura.model.Book;
import com.nilo.literAlura.model.DataBook;
import com.nilo.literAlura.repository.BookRepository;
import com.nilo.literAlura.service.ApiConsumer;
import com.nilo.literAlura.service.ConvertData;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://gutendex.com/books";
    private List<DataBook> dadosBooks = new ArrayList<>();
    private ApiConsumer apiConsumer = new ApiConsumer();
    private ConvertData conversor = new ConvertData();
    private BookRepository repositoryBook;
    private List<Book> book = new ArrayList<>();

    private Optional<Book> livroBuscado;

    public Principal(BookRepository repositoryBook) {
        this.repositoryBook = repositoryBook;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
            1- Buscar Author
            2- Buscar Livro por titulo
            3- Autores vivo em determinado ano
            4- Lista livros por idioma
            4-""";

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao) {
                case 1:
                    buscarAuthor();
                    break;
                case 2:
                    buscarLivroTitulo();
                    break;
                case 3:
                    buscarAutoresVivosEmDeterminadoAno();
                    break;
                case 4:
                    listarLivrosPorIdioma();
                case 5:
                    buscarLivrosWeb();
                    break;
                case 0:
                    System.out.println("saindo......");
                    break;
                default:
                    System.out.println("opcao invalida");

            }
        }
    }

    public void listarLivrosPorIdioma() {
        System.out.println("Digite o idioma a ser buscado:");
        String idioma = leitura.nextLine();
        List<Book> idomaEncontrado = repositoryBook.findByIdioma(idioma);
        idomaEncontrado.forEach(b -> System.out.println("Idioma:" + b.getIdioma() + "Titulo: " + b.getTitle()));

    }

    public void buscarAutoresVivosEmDeterminadoAno() {
        buscarLivroTitulo();
        if (livroBuscado.isPresent()) {
            Book book = livroBuscado.get();
            System.out.println("Digite o ano que deseja visualizar:");
            var ano = leitura.nextLine();
            leitura.nextLine();

        }
    }

    private void buscarLivroTitulo() {
        System.out.println("Digite o nome do Livro");
        String nomeLivro = leitura.nextLine();
        List<Book> livroEncontrado = repositoryBook.findByTitleContainingIgnoreCase(nomeLivro);
        livroEncontrado.forEach(b -> System.err.println("Nome Livro:" + b.getTitle() + "Nome Author:" + b.getAuthor()));

    }

    private void buscarLivrosWeb() {
        DataBook dadosBook = getDadosBook();
        Book book = new Book(dadosBook);
        dadosBooks.add(dadosBook);
        repositoryBook.save(book);

        System.out.println(dadosBook);
    }

    private DataBook getDadosBook() {
        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine();
        var json = apiConsumer.gainData(ENDERECO + nomeLivro.replace(" ", "%"));
        DataBook dataBook = conversor.gainData(json, DataBook.class);
        return dataBook;

    }

    public void buscarAuthor() {
        System.out.println("Digite o nome do autor:");
        String author = leitura.nextLine();
        List<Book> authorEncontrado = repositoryBook.findByAuthorContainingIgnoreCase(author);
        authorEncontrado.forEach(b -> System.err.println("nome author" + b.getAuthor() + "nome Livro" + b.getTitle() + "data Nascimento:" + b.getBirthYear() + "Numero de Downloads:"));

    }
}
