package org.example.pbooksapp001.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)// auto increment
    private Long id;
    private String title;
    private String ISBN;
    @Column(name = "publicationdate")
    private Date publicationDate;
    @Column(name = "authorname")
    private String authorName;

    public Book(String title, String ISBN, Date publicationDate, String authorName) {
        this.title = title;
        this.ISBN = ISBN;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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
                ", ISBN='" + ISBN + '\'' +
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
