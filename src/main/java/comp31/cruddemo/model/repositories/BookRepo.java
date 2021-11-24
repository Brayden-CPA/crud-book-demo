package comp31.cruddemo.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List; 
import comp31.cruddemo.model.entities.Author;
import comp31.cruddemo.model.entities.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Long>{
    List<Book> findByAuthor(Author author);
    // give you a list of of books by that author
}
