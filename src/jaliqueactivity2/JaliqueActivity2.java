/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaliqueactivity2;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author User
 */
class Bookdata{
    private String title;
    private String author;
    private String isbn;
    
    public Bookdata(String title, String author, String isbn){
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    }
    public String getTitle(){
        return title;
        
    }
    public String getAuthor(){
        return author;
    }
    public String getIsbn(){
        return isbn;
    }
    
    public String toString(){
        return "Title: "+ title+", Author: "+ author + ", ISBN: " + isbn;
    }
}

public class JaliqueActivity2 {
private LinkedList<Bookdata> books = new LinkedList<>();

public void insertBookData(String title, String author, String isbn) {
    Bookdata addBook = new Bookdata(title, author, isbn);
    books.add(addBook);
}

public void delBook(String isbn){
    for (int i = 0; i < books.size(); i++) {
        Bookdata book = books.get(i);
        if (book.getIsbn() .equals(isbn)) {
            books.remove(i);
            System.out.println("The book with ISBN " + isbn + " is deleted");
        }     
    }
    System.out.println("Book with ISBN " + isbn + " not found.");
}

public void searchBook(String isbn){
    for(Bookdata book : books){
        if (book.getIsbn().equals(isbn)){
            System.out.println("Book found: "+book);
            return;
        }
    }
    System.out.println("Book with ISBN " + isbn + " not found.");
}

public void sortBookByIsbn(){
    for (int i = 0; i < books.size(); i++) {
       int minIndex = i;
        for (int j = i + 1; j < books.size(); j++) {
            if(books.get(j).getIsbn().compareTo(books.get(minIndex).getIsbn())< 0){
                minIndex = j;
            }       
        }
        if (minIndex != i) {
            Bookdata temp = books.get(i);
            books.set(i,books.get(minIndex));
            books.set(minIndex, temp);
        }
    }
}
public void displayBooks(){
    for(Bookdata book : books){
        System.out.println(book);
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    JaliqueActivity2 myStash = new JaliqueActivity2();
    Scanner scanner = new Scanner(System.in);
    
        while (true) {            
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display Books");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            
            System.out.println("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                case 1:
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    
                    myStash.insertBookData(title,author,isbn);
                    break;
                case 2:
                    System.out.println("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    
                    myStash.searchBook(isbn);
                    break;
                case 3:
                    System.out.println("\nBooks in my Stash: ");
                    
                    myStash.displayBooks();
                    break;
                case 4:
                    System.out.println("Enter Book ISBN: ");
                    isbn = scanner.nextLine();
                    myStash.delBook(isbn);
                    break;
                case 5:
                    System.out.println("Good day and Goodbye Mrs. Mary Christmas Aguinaldo");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Option. Try Again");
            }
        }
    }
}
