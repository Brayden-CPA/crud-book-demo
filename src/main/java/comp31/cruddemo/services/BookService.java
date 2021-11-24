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
        // List<Author> authorList = authorRepo.findByLastNameIgnoreCase(lastName);
        if (!authorList.isEmpty())
        {
            Author author = authorList.get(0); //return the one author
            bookList = author.getBooks(); //get the books for that author     
        }
        return bookList;
    }
    // Query 1
    public Iterable<Author> findAuthorsStartingWith(String keyword)
    {
        List<Author> authorList = authorRepo.findByLastNameStartingWithIgnoreCase(keyword);
        return authorList;
    }
    // Query 3
    public Iterable<Book> getBooksByPriceAsc()
    {
        List<Book> bookList = bookRepo.findAllByOrderByPriceAsc();
        return bookList;
    }
    //Query 4
    public Iterable<Book> findBooksContainingTwoIterable(String word1, String word2)
    {
        List<Book> bookList = bookRepo.findByTitleContainingIgnoreCaseAndTitleContainingIgnoreCase(word1, word2);
        return bookList;
    }
    // Query 5
    public Iterable<Book> findBookNotContaining(String word1)
    {
        List<Book> bookList = bookRepo.findByTitleNotContaining(word1);
        return bookList;
    }
    // Query 6
    public Iterable<Book> findBookContainingAndNotContaining(String word1, String word2)
    {
        List<Book> bookList = bookRepo.findByTitleContainingAndTitleNotContaining(word1, word2);
        return bookList;
    }

    // public Object test()
    // {
    //     List<Book> bookList = bookRepo.findByTitleContainingIgnoreCaseAndTitleContainingIgnoreCase("Spring", "Boot");
    //     return bookList;
    // }
    


}
