package org.example;

import java.util.Scanner;

public class Exit implements IOOperation{


    @Override
    public void oper(Database database,User user) {

        System.out.println("\nAre you sure you want to Quit ?\n"
                +"1. yes\n2.Main Menu");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        if (i == 1) {
        s.close();
        }
        else {
            user.menu(database,user);
        }

    }
}
