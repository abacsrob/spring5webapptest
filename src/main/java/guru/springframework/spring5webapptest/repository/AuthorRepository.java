package guru.springframework.spring5webapptest.repository;

import guru.springframework.spring5webapptest.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
