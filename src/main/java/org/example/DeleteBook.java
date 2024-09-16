package org.example;

import java.util.Scanner;

public class DeleteBook implements IOOperation{



    @Override
    public void oper(Database database,User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the book name: ");
       String bookName = s.nextLine();
       System.out.println("Enter the author name: ");
       String authorName = s.nextLine();
       System.out.println("Enter the isbn number: ");
       String isbn = s.nextLine();
        System.out.println("Enter the number of pages: ");
        int pages = s.nextInt();


        int i = database.getBook(bookName);
        if (i>-1){
        database.deleteBook(i);
        System.out.println("Book deleted successfully");
        }
        else{
            System.out.println("Book does not exist");
        }
s.close();
        user.menu(database, user);
    }



}
