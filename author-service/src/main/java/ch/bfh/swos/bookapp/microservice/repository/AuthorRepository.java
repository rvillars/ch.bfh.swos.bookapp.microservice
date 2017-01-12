package ch.bfh.swos.bookapp.microservice.repository;

import ch.bfh.swos.bookapp.microservice.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by rovi on 10.11.16.
 */
@RepositoryRestResource(path = "authors")
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
