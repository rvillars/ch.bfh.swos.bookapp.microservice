package ch.bfh.swos.bookapp.microservice.controller;

import ch.bfh.swos.bookapp.microservice.client.AuthorClient;
import ch.bfh.swos.bookapp.microservice.client.BookClient;
import ch.bfh.swos.bookapp.microservice.model.Author;
import ch.bfh.swos.bookapp.microservice.model.Book;
import ch.bfh.swos.bookapp.microservice.model.BookWithAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rovi on 11.01.17.
 */
@RestController
public class BookWithAuthorController {

    @Autowired
    private BookClient bookClient;

    @Autowired
    private AuthorClient authorClient;

    @RequestMapping(value = "/booksWithAuthor", method = RequestMethod.GET, produces = "application/hal+json")
    @ResponseBody
    public Resources<Resource<BookWithAuthor>> booksWithAuthor() {
        List<Resource<BookWithAuthor>> bookWithAuthorList = new ArrayList<>();
        Resources<Resource<Book>> bookList = bookClient.getBooks();
        for (Resource<Book> bookResource : bookList) {
            Book book = bookResource.getContent();
            BookWithAuthor bookWithAuthor = new BookWithAuthor();
            bookWithAuthor.setTitle(book.getTitle());
            bookWithAuthor.setReleaseDate(book.getReleaseDate());
            Author author = authorClient.getAuthor(book.getAuthor()).getContent();
            bookWithAuthor.setAuthor(author);
            Resource<BookWithAuthor> bookWithAuthorResource = new Resource<>(bookWithAuthor);
            bookWithAuthorList.add(bookWithAuthorResource);
        }
        return new Resources<>(bookWithAuthorList);
    }
}
