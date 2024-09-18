package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewOrders implements IOOperation{


    @Override
    public void oper(Database database,User user) {

        System.out.println("\nEnter book name: ");
        Scanner s = new Scanner(System.in);
        String bookname = s.next();
        int i =database.getBook(bookname);
        if (i>-1){
            System.out.println("Book\t\tUser\t\tPrice\t\tQty");
           // ArrayList<Order> orders = new ArrayList<Order>() ;
            for (Order order: database.getAllOrders()){
                if (order.getBook().getName().matches(bookname)){
                    System.out.println(order.getBook().getName()+"\t\t"
                    +order.getPrice()+"\t\t"+order.getQty()+"\t\t"
                            +order.getUser().getName());
                }
                System.out.println();
            }

        }else {
            System.out.println("Book not found");
        }
        user.menu(database ,user);

    }
}
