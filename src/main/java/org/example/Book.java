package org.example;

public class Book {

    private String name;
    private String title;
    private String author;
    private int Qty;
    private String Publisher;
    private String Address;
    private String status;
    private  double price;
    private int BrwCopies;


    public Book() {

    }

    public Book(String name,String title,String author, int Qty, String Publisher, String Address, double price, int Brwcopies) {
      this.name = name;
        this.title = title;
        this.author = author;
        this.Qty = Qty;
        this.Publisher = Publisher;
        this.Address = Address;
        this.price = price;
        this.BrwCopies = Brwcopies;

    }
public String  toString(){
       String text =" Book Name: " + name+
               "Book Author: " +author+
               "Book Publisher: " + Publisher+
               "Book Collection address: "+ Address +
               "Qty: " +String.valueOf(Qty) +
               "price: " +String.valueOf(price)+
               "BrwCopies: " +String.valueOf(BrwCopies);
       return text;


}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBrwCopies() {
        return BrwCopies;
    }

    public void setBrwCopies(int brwCopies) {
        BrwCopies = brwCopies;
    }
    public String getName(){
         return name;
    }
    public void setName(String name){
        this.name = name;
    }


    public String toString2(){
        String text =  name+"<n/>"+
                "<n/>" +author+
                "<n/>"+ Publisher+
                "<n/>"+ Address +
                "<n/>" +String.valueOf(Qty) +
                "<n/>" +String.valueOf(price)+
                "<n/>"+String.valueOf(BrwCopies);
        return text;
    }
    public Book parseBook(String s){
        String[] parts = s.split("<n/>");
        Book book = new Book();
        book.setName(parts[0]);
        book.setAuthor(parts[1]);
        book.setPublisher(parts[2]);
        book.setAddress(parts[3]);
        book.setQty(Integer.parseInt(parts[4]));
        book.setPrice(Double.parseDouble(parts[5]));
        book.setBrwCopies(Integer.parseInt(parts[6]));
        return book;

    }
}
