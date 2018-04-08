package guru.springframework.spring5webapptest.repository;

import guru.springframework.spring5webapptest.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
