package org.example;

import java.util.ArrayList;

public class ViewBooks  implements  IOOperation{

    @Override
    public void oper(Database database,User user) {

         ArrayList<Book> books = database.getAllBooks();

        System.out.println("Name\tAuthor\tPublisher\tCLA\tStatus\tQty\tPrice"
                + "\tBrw cps");
        for (Book book : books) {
            System.out.println(book.getName() + "\t\t" + book.getAuthor() +  "\t\t" + book.getPublisher() +  "\t\t" + "\t\t"
                    + book.getAddress() + "\t" + book.getStatus() + "\t" + book.getQty() + "\t" + book.getPrice()+ book.getBrwCopies()
            );
        }
        System.out.println();
        user.menu(database,user );

    }

}
