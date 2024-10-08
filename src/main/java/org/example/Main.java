package org.example;

import java.util.Scanner;

public class Main {
    static Scanner input;
    static Database database;

    public static void main(String[] args) {

        database = new Database();

        System.out.println("Welcome to the library management system!");

        int num;
 // do {
        System.out.println("0.Exit\n1.login\n2.new User");
        input = new Scanner(System.in);
        num = input.nextInt();

        switch (num) {
            case 1: login();
            case 2: newUser(); break;

        }
        //  }      while (num!=0);
    }

    private static void login() {
        System.out.println("Enter Phone: ");
        String phone = input.next();
        System.out.println("Enter email: ");
        String email = input.next();

        int flag = database.login(phone, email);
        if (flag != -1) {

            User user = database.getUser(flag);
            user.menu(database, user);
        } else {
            System.out.println("User don't exist");
        }
    }

    private static void newUser() {

        System.out.println("Enter name: ");
        String name = input.next();
        System.out.println("Enter phone number: ");
        String emailNumber = input.next();
        System.out.println("Enter email: ");
        String email = input.next();
        System.out.println("1.Admin\n2. Normal User");
        int n2 = input.nextInt();

        User user;
        if (n2 == 1) {
            user = new Admin(name, email, emailNumber);

        } else {
            user = new NormalUser(name, email, emailNumber);

        }
        database.AddUser(user);
        user.menu(database, user);

    }
}