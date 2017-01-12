package ch.bfh.swos.bookapp.microservice.client;

import ch.bfh.swos.bookapp.microservice.model.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by rovi on 11.01.17.
 */
@FeignClient("book-service")
public interface BookClient {
    @RequestMapping(method = RequestMethod.GET, value = "/books")
    Resources<Resource<Book>> getBooks();
}
