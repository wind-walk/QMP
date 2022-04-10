package com.example.qmpclient.controller;

import common.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;


@RestController
@RequestMapping("/client")
public class ClientController {

    @RequestMapping("/rpc/jsonBook")
    Book jsonBook(){

        RestTemplate restTemplate = new RestTemplate();
//        Book book = (Book)restTemplate.getForObject("http://localhost:8080/server/book", Book.class);
//        System.out.println(book);
        ResponseEntity entity = restTemplate.getForEntity("http://localhost:8080/server/jsonBook",Book.class);

        return (Book)entity.getBody();
    }

    @RequestMapping("/rpc/serBook")
    Book serializedBook(){

        RestTemplate restTemplate = new RestTemplate();
        byte[] buffer = (byte[])restTemplate.getForObject("http://localhost:8080/server/serBook",byte[].class);
        Book book = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
            book = (Book)ois.readObject();
            System.out.println(book);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    @RequestMapping("/rpc/serBooks")
    List<Book> serializedBooks(){

        RestTemplate restTemplate = new RestTemplate();
        byte[] buffer = (byte[])restTemplate.getForObject("http://localhost:8080/server/serBooks",byte[].class);
        List<Book> books= null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
            books = (List<Book>)ois.readObject();
            for( Book b : books) {
                System.out.println(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }


}
