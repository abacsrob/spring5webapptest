package guru.springframework.spring5webapptest.repository;

import guru.springframework.spring5webapptest.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
