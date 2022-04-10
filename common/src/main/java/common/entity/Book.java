package common.entity;

import java.io.Serializable;

public class Book implements Serializable {
    public Book() {
    }

    public Book(String name, int price, String author, String publisher) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
    }

    public Book(String name, int price, String author, String publisher, Publisher publisherDetail) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.publisherDetail = publisherDetail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publisherDetail=" + publisherDetail +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisherDetail() {
        return publisherDetail;
    }

    public void setPublisherDetail(Publisher publisherDetail) {
        this.publisherDetail = publisherDetail;
    }

    String name;
    transient int price;
    transient String author;
    String publisher;
    Publisher publisherDetail;
}
