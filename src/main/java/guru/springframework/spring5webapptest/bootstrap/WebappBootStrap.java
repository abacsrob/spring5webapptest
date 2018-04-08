package guru.springframework.spring5webapptest.bootstrap;

import guru.springframework.spring5webapptest.model.Author;
import guru.springframework.spring5webapptest.model.Book;
import guru.springframework.spring5webapptest.model.Publisher;
import guru.springframework.spring5webapptest.repository.AuthorRepository;
import guru.springframework.spring5webapptest.repository.BookRepository;
import guru.springframework.spring5webapptest.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class WebappBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepo;
    private BookRepository bookRepo;
    private PublisherRepository publisherRepo;

    public WebappBootStrap(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    private void initData() {
        System.out.println("in WebappBootStrap.initData()");

        Publisher publisher = new Publisher("publisher1", "publisher1 address");

        Author author = new Author("Eric", "Doe");
        Book book = new Book("Domain Driven Design", "1234", publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);

        publisherRepo.save(publisher);
        authorRepo.save(author);
        bookRepo.save(book);

        Publisher publisher2 = new Publisher("publisher2", "publisher2 address");

        Author author2 = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "2345", publisher2);
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        publisherRepo.save(publisher2);
        authorRepo.save(author2);
        bookRepo.save(book2);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
