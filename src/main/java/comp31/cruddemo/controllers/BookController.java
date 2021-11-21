package comp31.cruddemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.cruddemo.services.BookService;


@Controller
public class BookController {
    
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    Logger logger = LoggerFactory.getLogger(BookController.class);
    
    @GetMapping("/")  //Root mapping returns to the index file
    
    public String getIndex()
    {
            return "index";
    }

    @GetMapping("/books")
    public String getBooks(
        @RequestParam(required=false) String firstName, 
        @RequestParam(required=false) String lastName, 
        Model model)
    {
        boolean authorNameInvalid = 
            firstName == null || firstName.isEmpty() || 
            lastName  == null || lastName.isEmpty();
        
        if (authorNameInvalid)
        {   model.addAttribute("books", bookService.findBooks());
        }
        else
        {   logger.info("Author Name: ", firstName + " " + lastName);
            model.addAttribute("books", bookService.findBooksByAuthor(firstName,lastName));
        }
        return "books";
    }

    @GetMapping("/authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("authors" , bookService.findAuthors());
        return "authors";
    }

}
