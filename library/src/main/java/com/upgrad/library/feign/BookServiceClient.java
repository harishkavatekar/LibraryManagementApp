package com.upgrad.library.feign;

import com.upgrad.library.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "API-GATEWAY")
public interface BookServiceClient {

    @RequestMapping(value = "${bookManagement.path}", method = RequestMethod.GET)
    public Book returnBook(@PathVariable(value = "bookId") int bookId);
}
