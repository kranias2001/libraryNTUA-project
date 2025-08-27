package com.example.Library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.ArrayList;

public class BookDatabase {
    private static final String BOOK_FILE = "medialab/Books.txt";
    private static ObservableList<Book> bookslist = FXCollections.observableArrayList();
    public static ObservableList<Book> getBooksList() {
        return bookslist;
    }
    public static Book clickedbook;
    public static Book getBook(){
        return clickedbook;
    }

    public static void setBook(Book clickedbook){
        BookDatabase.clickedbook=clickedbook;
    }
    public static void saveBook() throws IOException {
        FileOutputStream fileOutputStream =new FileOutputStream(BOOK_FILE);
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new ArrayList<>(bookslist));
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static void loadBook() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream =new FileInputStream(BOOK_FILE);
        ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);
        bookslist = FXCollections.observableArrayList((ArrayList<Book>) objectInputStream.readObject());
        objectInputStream.close();
    }
    public static void addBook(Book book) {
        bookslist.add(book);
    }
    public static void removeBook(Book book) {
        bookslist.remove(book);
    }
    public static void editBook(Book oldBook,String newTitle,String newAuthor,String newCategory,String newISBN,
                                Integer newPublicationYear,Integer newNumberOfCopies,String newPublisher) {
     if(!newTitle.isEmpty())                                      oldBook.setTitle(newTitle);
     if(!newAuthor.isEmpty())                                     oldBook.setAuthor(newAuthor);
     if(!newCategory.isEmpty())                                   oldBook.setCategory(newCategory);
     if(!newISBN.isEmpty())                                       oldBook.setIsbn(newISBN);
     if(newPublicationYear != null)                         oldBook.setPublicationYear(newPublicationYear);
     if(newNumberOfCopies != null)                          oldBook.setNumberOfCopies(newNumberOfCopies);
     if(!newISBN.isEmpty())                                       oldBook.setPublisher(newPublisher);
    }
    public static Book searchBook(String isbn) {
        return bookslist.stream().filter(Book -> Book.getIsbn().equals(isbn)).findAny().orElse(null);
    }
}