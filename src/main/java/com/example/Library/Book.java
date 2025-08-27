package com.example.Library;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int publicationYear;
    private String category;
    private int numberOfCopies;
    private Double rating;
    private double sum;
    private int counter;
    public Book(String title, String author, String publisher, String isbn, int publicationYear, String category, int numberOfCopies, Double rating,int counter ) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.category = category;
        this.numberOfCopies = numberOfCopies;
        this.rating = rating;
        this.counter=counter;
    }

    public double getsum(){
        return sum;
    }
    public void setsum(double sum){
        this.sum=sum;
    }
    public int getcounter(){
        return counter;
    }
    public void setcounter(int counter){
        this.counter=counter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String toString(){
    return "Τίτλος: " + title + "\n" + "Συγγραφέας: " + author + "\n" +"Εκδοτικός οίκος: " + publisher + "\n"
            + "isbn: " + isbn + "\n" + "Έτος έκδοσης: " + publicationYear + "\n" + "Κατηγορία: " + category + "\n" + "Αριθμός αντιτύπων: " + numberOfCopies + "\n"
            +  "Μ.Ο βαθμολογίας: "  + rating+ "\n" +  "Πλήθος Αξιολογήσεων: "  + counter;
    }
}
