package com.onetwo.library_management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_t")
public class Book {
    @Id
    private String id;
    private String ISBN;
    private String name;
    private String author;

    private Integer totalNumber;    // 总共数量
    private Integer leftInStock;    // 图书馆目前有的数量

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", totalNumber=" + totalNumber +
                ", leftInStock=" + leftInStock +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getLeftInStock() {
        return leftInStock;
    }

    public void setLeftInStock(Integer leftInStock) {
        this.leftInStock = leftInStock;
    }
}
