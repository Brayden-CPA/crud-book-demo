package comp31.cruddemo.model.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AUTHOR_ID")
    private Integer authorId;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
//making a change v2
    public Author()
    {
        authorId = 0;
        firstName = "";
        lastName = "";
        books = null;
    }

}
