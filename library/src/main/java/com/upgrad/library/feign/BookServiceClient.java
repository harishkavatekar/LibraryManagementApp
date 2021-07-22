package com.upgrad.library.feign;

import com.upgrad.library.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "BOOK-SERVICE", url = "http://localhost:8081")
public interface BookServiceClient {

    @RequestMapping(value = "/book_app/v1/book/return/{bookId}", method = RequestMethod.GET)
    public Book returnBook(@PathVariable(value = "bookId") int bookId);
}
