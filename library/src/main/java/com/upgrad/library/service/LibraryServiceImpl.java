package com.upgrad.library.service;

import com.upgrad.library.entity.Book;
import com.upgrad.library.feign.BookServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LibraryServiceImpl implements LibraryService{

    /*autowire RestTemplate*/
    @Autowired
    private RestTemplate restTemplate;

    /* Fetch URI from application.properties using @Value */

    @Value("${bookManagement.url}")
    private String bookManagementUrl;

    @Autowired
    private BookServiceClient bookServiceClient;

    @Override
    public Book requestBook(Book book) {

        //Issue a book if it is available
        /* Write your code here */
        Map<String,String> bookMap = new HashMap<>();
        bookMap.put("bookId", String.valueOf(book.getBookId()));
        Book requestBook = restTemplate.getForObject(bookManagementUrl, Book.class, bookMap);

        if(requestBook != null){
            return requestBook;
        }else {
            return null;
        }

    }

    @Override
    public Book returnBook(Book book){
        Map<String, String> bookMap = new HashMap<>();
        bookMap.put("bookId", String.valueOf(book.getBookId()));

        Book returnBook = bookServiceClient.returnBook(book.getBookId());
        if(returnBook != null){
            return returnBook;
        }
        return null;
    }
}
