package comp31.cruddemo.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List; 
import comp31.cruddemo.model.entities.Author;
import comp31.cruddemo.model.entities.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Long>{
    // give you a list of of books by that author
    List<Book> findByAuthor(Author author);
    // Get all Books and sort by price ascending
    List<Book> findAllByOrderByPriceAsc();
    // find books that contain two    
    List<Book> findByTitleContainingIgnoreCaseAndTitleContainingIgnoreCase(String word1, String word2);
    // Get all books not containing keyword
    List<Book> findByTitleNotContaining(String word1);
    //Get all books containing first keyword and not containing second keyword
    List<Book> findByTitleContainingAndTitleNotContaining(String word1, String word2);

}
