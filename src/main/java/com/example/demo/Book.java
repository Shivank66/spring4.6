package com.example.demo;

public class Book {
    String bookname;
    String author;
    int price;
    String subject;

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPrice() {
        return price;
    }

    public String getSubject() {
        return subject;
    }
    Book()
    {
        bookname="Default Name";
        subject="Default Subject";
        price=100;
        author="Myself";
    }
    Book(String bookname,String subject,String author,int price)
    {
        this.price=price;
        this.subject=subject;
        this.bookname=bookname;
        this.author=author;

    }
}
