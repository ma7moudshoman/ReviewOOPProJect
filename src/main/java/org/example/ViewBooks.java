package org.example;

public class ViewBooks  implements  IOOperation{

    @Override
    public void operation(Database database,User user) {
        System.out.println("View books");

    }
}
