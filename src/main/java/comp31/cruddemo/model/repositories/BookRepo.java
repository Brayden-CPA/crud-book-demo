package comp31.cruddemo.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.cruddemo.model.entities.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Long>{
<<<<<<< HEAD
    List<Book> findByAuthor(Author author);
    // give you a list of of books by that author
=======
>>>>>>> 7df2986445b912a1a6a76594a9cb3f13810fd24a
}
