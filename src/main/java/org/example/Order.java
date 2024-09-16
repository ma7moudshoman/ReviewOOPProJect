package org.example;

public class Order {


    private  Book book;
    private  User user;
    private double price;
    private int qty;

    public Order() {}
    public  Order(Book book, User user, double price, int qty) {
        this.book = book;
        this.user = user;
        this.price = price;
        this.qty = qty;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public String toString() {
return "Book name"+ book.getName()+ "\n"
        + "User name"+ user.getName()+ "\n"
        + "Book price"+ String.valueOf(price)+ "\n"
        + "Book qty"+ String.valueOf(qty);
    }

    public String toString2(){
        return "Book name"+ book.getName()+
                "\n"+"User name"+ user.getName()+
                "\n"+"Book price"+ String.valueOf(price)+
                "\n"+"Book qty"+ String.valueOf(qty);
    }
}
