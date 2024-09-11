package org.example;

import java.util.Scanner;

public class AddBook implements  IOOperation{


    @Override
    public void operation(Database database,User user) {

        Scanner s = new Scanner(System.in);
        Book book = new Book();

        System.out.println("Enter the  Book Name: ");
        book.setName(s.next());
        System.out.println("Enter the Author: ");
        book.setAuthor(s.next());
        System.out.println("Enter book publisher: ");
        book.setPublisher(s.next());
        System.out.println("Enter qty");
        book.setQty(s.nextInt());
        System.out.println("Enter price");
        book.setPrice(s.nextDouble());
        System.out.println("Enter collection address");
        book.setAddress(s.next());
        System.out.println("Enter title");
        book.setTitle(s.next());
        System.out.println("Enter borrower copies");
        book.setBrwCopies(s.nextInt());


        database.AddBook(book);
        System.out.println("Book Added successfully\n");
        user.menu(database,user);

        s.close();


    }
}
