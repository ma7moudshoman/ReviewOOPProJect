package org.example;

import java.util.Scanner;

public class Admin  extends  User {

    User user;

    public Admin(String name) {
        super(name);
        this.operation = new IOOperation[]{
                new ViewBooks(),
                new DeleteBook(),
                new AddBook(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit(),
                new Search()
        };
    }

    public Admin(String name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
        this.operation = new IOOperation[]{
                new ViewBooks(),
                new DeleteBook(),
                new AddBook(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit(),
                new Search()
        };

    }

    @Override
    public String toString() {
        return name + "<N/>" + email + "<N/>" + phoneNumber + "<N/>" + "Normal";

    }

    @Override
    public void menu(Database database, User user) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. View Book");
            System.out.println("2. Add Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book");
            System.out.println("5. Delete All Books");
            System.out.println("6. View Order");
            System.out.println("7. Exit Program");

            System.out.println("Choose an option:");

            try {
                int flag = scanner.nextInt();

                if (flag >= 1 && flag <= 7) {
                    this.operation[flag - 1].oper(database, user);  // تنفيذ العملية بناءً على اختيار المستخدم

                    if (flag == 7) {
                        exit = true;
                        System.out.println("Exiting program...");
                    }
                } else {
                    System.out.println("Invalid option, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // تنظيف المدخلات الخاطئة
            }
        }
    }
}