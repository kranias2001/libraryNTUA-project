package com.example.Library;

import java.io.Serializable;
import java.time.LocalDate;

public class Borrow implements Serializable {
    private User user;
    private Book book;
    private LocalDate date;
    public Borrow(User user,Book book,LocalDate date){
        this.user=user;
        this.book=book;
        this.date=date;
    }
    public User getuser() {return user;
    }
    public Book getbook(){return book;}

    public LocalDate getdate() {return date;
    }
    public void setuser(User user){ this.user=user;}
    public void setbook(Book book){ this.book=book;}

   public String toString() {
        return "User: " + user.getUsername() + "\n" +  "Τίτλος: " + book.getTitle() + '\n' + "ISBN: " + book.getIsbn() +
                '\n' + "Ημερομηνία δανεισμού: " + date +'\n'+ "Μέγιστη δυνατή ημέρα παράδοσης: " + date.plusDays(5);
    }
}
