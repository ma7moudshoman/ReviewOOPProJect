package org.example;

import java.util.Scanner;

public class Admin  extends  User{

    User user;
    public Admin(String name){
        super(name);
        this.operation =new IOOperation[]{
               new ViewBooks(),
                new DeleteBook(),
                new AddBook(),
                new DeleteAllBooks(),
                new ViewOrder(),
                new Exit(),
                new Search()
        };
    }
    public Admin(String name,String phoneNumber,String email) {
        super(name, phoneNumber, email);
        this.operation = new IOOperation[]{
                        new ViewBooks(),
                        new DeleteBook(),
                        new AddBook(),
                        new DeleteAllBooks(),
                        new ViewOrder(),
                        new Exit(),
                        new Search()
                };
    }

    @Override
    public String toString() {
        return name+"<N/>"+email+"<N/>"+phoneNumber+"<N/>"+"Normal";

    }

    @Override
    public void menu(Database database,User user) {
        System.out.println("1. view Book");
        System.out.println("2. add Book");
        System.out.println("3. Delete Book");
        System.out.println("4. Search Book");
        System.out.println("5. Delete All Books");
        System.out.println("6. View Order");
        System.out.println("7. Exit Program");

        System.out.println("Data Saved");

        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        this.operation[flag-1].operation(database,user);
    }



}
