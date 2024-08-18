package org.example.pbooksapp001.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)// auto increment
    private Long id;
    private String title;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "publicationdate")
    private Date publicationDate;
    @Column(name = "authorname")
    private String authorName;

    public Book(String title, String isbn, Date publicationDate, String authorName) {
        this.title = title;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.authorName = authorName;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
