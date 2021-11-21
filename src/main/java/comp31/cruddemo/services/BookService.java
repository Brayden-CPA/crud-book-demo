package comp31.cruddemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.cruddemo.model.entities.Author;
import comp31.cruddemo.model.entities.Book;
import comp31.cruddemo.model.repositories.AuthorRepo;
import comp31.cruddemo.model.repositories.BookRepo;

@Service
public class BookService {
    
    BookRepo bookRepo;
    AuthorRepo authorRepo;
    //both repos available to the service
    @Autowired
    public BookService (BookRepo bookRepo, AuthorRepo authorRepo) {
        super();
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }


    public Iterable<Author> findAuthors()
    {
        return authorRepo.findAll();
    }

    public Iterable<Book> findBooks()
    {
        return bookRepo.findAll();
    }

    public Iterable<Book> findBooksByAuthor(String firstName, String lastName)
    {        
        List <Book> bookList = new ArrayList<>();
        List<Author> authorList = authorRepo.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName,lastName);
        // Find author by first and last name
        if (!authorList.isEmpty()) //if we find a match
        {
            Author author = authorList.get(0); //return the one author
            bookList = author.getBooks(); //get the books for that author     
        }
        return bookList;
    }

}
