package com.example.qmpserver.controller;

import common.entity.Book;
import common.entity.Publisher;
import common.utils.QMPUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerController {

    @RequestMapping("/jsonBook")
    Book book() {
        return new Book("《史记》",10,"司马迁","中华书局",new Publisher("中华书局","北京"));
    }

    @RequestMapping("/serBook")
    byte[] serializationBook() {
        Book book = new Book("《史记》",10,"司马迁","中华书局",new Publisher("中华书局","北京"));
        System.out.println("before ser :"+book);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(buffer);
            oos.writeObject(book);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }

    @RequestMapping("serBooks")
    byte[] serializationBooks() {
        Book book1 = new Book("《史记》",10,"司马迁","中华书局",new Publisher("中华书局","北京"));
        Book book2 = new Book("《汉书》",10,"班固","中华书局",new Publisher("中华书局","北京"));
        Book book3 = new Book("《后汉书》",10,"范晔","中华书局",new Publisher("中华书局","北京"));
        Book book4 = new Book("《三国志》",10,"陈寿","中华书局",new Publisher("中华书局","北京"));
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(buffer);
            oos.writeObject(books);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }
}
