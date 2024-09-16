package org.example;

import java.util.Scanner;

public class NormalUser extends User {

public NormalUser(String username) {
    super(username);
    this.operation=new IOOperation[]{

                    new ViewBooks(),
                    new Search(),
                    new ReturnBook(),
                    new PlaceOrder(),
                    new CalculateFine(),
                    new BorrowBook (),
                    new Exit()

            };

}

public  NormalUser(String username, String email, String phoneNumber) {
    super(username, email, phoneNumber);

    this.operation=new IOOperation[]{

            new ViewBooks(),
            new Search(),
            new ReturnBook(),
            new PlaceOrder(),
            new CalculateFine(),
            new BorrowBook (),
            new Exit()

    };

}
    @Override
    public void menu(Database database,User user) {
        System.out.println("1. View Books ");
        System.out.println("2. Search Books ");
        System.out.println("3. Place Order ");
        System.out.println("4. Borrow Books ");
        System.out.println("5. Calculate fine ");
        System.out.println("6. Return Books ");
        System.out.println("7. Exit ");

        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        this.operation[flag-1].oper(database,user);
        scanner.close();
    }

    public String toString() {
        return name+"<N/>"+email+"<N/>"+phoneNumber+"<N/>"+"Normal";

    }
}
