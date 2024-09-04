package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner input;
    static Database database;
    public static void main(String[] args) {

         database = new Database();
        System.out.println("Welcome to the library management system!");

         int num;
   do {
       System.out.println("0.Exit\n1.login\n2.new User");
       input = new Scanner(System.in);
       num = input.nextInt();
       switch (num) {
           case 1:
               login();
           case 2:
               newUser();

       }
   }      while (num!=0);

    }

    private static void login() {

        System.out.println("Enter name : ");
        String name = input.next();
        System.out.println("Enter Phone number : ");
        String phone = input.next();
        System.out.println("Enter email address : ");
        String email = input.next();
        int flag= database.login(phone,email);
        if (flag!=-1){
            User admin=database.getUser(flag);
            System.out.println("Welcome " );

        }else {
         return;        }


    }

    private static void newUser() {

        System.out.println("Enter name : ");
        String name = input.next();
        System.out.println("Enter phone number : ");
        String emailNumber = input.next();
        System.out.println("Enter email  : ");
        String email = input.next();
        System.out.println("1.Admin\n2.normal User");

        int n2 = input.nextInt();
        if (n2 == 1){
            User admin = new User(name, email, emailNumber);
            database.addUser(admin);
        }else {
            User user = new User(name, email, emailNumber);
           database.addUser(user);
        }
        System.out.println("User created successfully!");
    }
}