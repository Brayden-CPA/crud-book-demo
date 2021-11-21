package comp31.cruddemo.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.cruddemo.model.entities.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author,Long>
{
    List<Author> findByLastNameIgnoreCase(String lastName);
    List<Author> findByFirstNameAndLastName(String firstName,String lastName);
    List<Author> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName,String lastName);
}
