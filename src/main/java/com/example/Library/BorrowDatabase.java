package com.example.Library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowDatabase {
        private static final String BORROW_FILE = "medialab/Borrows.txt";
        private static ObservableList<Borrow> borrowingslist = FXCollections.observableArrayList();
        public static ObservableList<Borrow> getBorrowingsList() {
            return borrowingslist;
        }
        public static void saveBorrow() throws IOException {
            FileOutputStream fileOutputStream =new FileOutputStream(BORROW_FILE);
            ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(new ArrayList<>(borrowingslist));
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        public static void loadBorrow() throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream =new FileInputStream(BORROW_FILE);
            ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);
            borrowingslist = FXCollections.observableArrayList((ArrayList<Borrow>) objectInputStream.readObject());
            objectInputStream.close();

        }

       public static void addBorrowing(Borrow borrow) {
               borrowingslist.add(borrow);
            }

        public static void removeBorrowing(Borrow borrow) {
                borrowingslist.remove(borrow);
        }

    public static List<Borrow> searchUserBorrowing(User user) {
        return borrowingslist.stream().toList();
    }
    public static List<Borrow> searchBookBorrowing(Book book) {
        return borrowingslist.stream().toList();
    }

    }

