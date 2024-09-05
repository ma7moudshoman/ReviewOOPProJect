package org.example;

public class NormalUser extends User {

public NormalUser(String username) {
    super(username);
}

public  NormalUser(String username, String email, String phoneNumber) {
    super(username, email, phoneNumber);
}
    @Override
    public void menu() {
        System.out.println("1. View Books ");
        System.out.println("2. Search Books ");
        System.out.println("1. Place Order ");
        System.out.println("1. Borrow Books ");
        System.out.println("1. Calculate fine ");
        System.out.println("1. Return Books ");
        System.out.println("1. Exit ");
    }
}
