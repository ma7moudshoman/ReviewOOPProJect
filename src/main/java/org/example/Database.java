package org.example;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> username = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> booknames = new ArrayList<String>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    private File usersfile =new File("D:\\projects\\OOPNewProject\\src\\main\\java\\Data\\Users.txt");
    private File booksfile =new File("D:\\projects\\OOPNewProject\\src\\main\\java\\Data\\Books.text");
    private File file=new File("D:\\projects\\OOPNewProject\\src\\main\\java\\Data");
    private File ordersfile =new File("D:\\projects\\OOPNewProject\\src\\main\\java\\Data\\orders.text");


    public Database() {
        // الحصول على المسار من الموارد
        URL usersURL = Main.class.getClassLoader().getResource("Users");
        URL booksURL = Main.class.getClassLoader().getResource("Books");
if (!file.exists()) {
    file.mkdirs();
}
        if (usersURL != null) {
            usersfile = new File(usersURL.getFile());
            if (!usersfile.exists()) {
                usersfile.mkdirs();
            }
        } else {
            System.err.println("Error: 'Users' resource not found.");
        }

        if (booksURL != null) {
            booksfile = new File(booksURL.getFile());
            if (!booksfile.exists()) {
                booksfile.mkdirs();
            }
            if (!ordersfile.exists()) {
            }try {
                ordersfile.createNewFile();
            }catch (Exception e){}
            saveUsers();
            getBooks();
            getOrders();
        } else {
            System.err.println("Error: 'Books' resource not found.");
        }
    }
    /*
    public Database(){
    if(!file.exists()){
    file.mkdirs();
    }
    if(!usersfile.exists()){
    try{
    usersfile.createNewFile();
    }
    catch(Exception e){}
     }
     if(!booksfile.exists()){
     try{
     booksfile.createNewFile();
     }
     catch(exception e){}
     }
     getUsers();
     saveUsers();

    }
    * */

    // إضافة مستخدم إلى قاعدة البيانات
    public void AddUser(User user) {
        users.add(user);
        username.add(user.getName());
        saveUsers();
    }

    // التحقق من تسجيل الدخول بناءً على رقم الهاتف والبريد الإلكتروني
    public int login(String phoneNumber, String email) {
        int flag = -1;
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getEmail().equals(email)) {
                flag = users.indexOf(user);
                break;
            }
            saveBooks();
            saveUsers();
        }
        return flag;
    }

    // الحصول على مستخدم بناءً على المؤشر
    public User getUser(int flag)  {
        return users.get(flag);

    }

    // إضافة كتاب إلى قاعدة البيانات
    public void AddBook(Book book) {
        books.add(book);
        booknames.add(book.getName());
        saveBooks();
    }
/*
    private void getUsers(){
        String text1= "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(usersfile));
       String s1;
       while ((s1 = br.readLine()) != null) {
           text1 =text1 + s1;
       }
       br.close();
        }catch (Exception e){
            System.err.println(e.toString());
        }
        if (!text1.matches("") || !text1.isEmpty() ){
            String [] a1=text1.split("<NewUser/>");
            for (String s : a1) {
                String [] a2= s.split("<n/>");
                if (a2[3].matches("Admin")){
                    User user=new Admin(a2[0], a2[1], a2[2]);
                    users.add(user);
                    username.add(user.getName());
                }
                else {
                    User user=new NormalUser(a2[0], a2[1], a2[2]);
                    users.add(user);
                    username.add(user.getName());


                }
            }
        }
    }*/
private void getUsers() {
    try (BufferedReader br = new BufferedReader(new FileReader(usersfile))) {
        String line;
        StringBuilder text = new StringBuilder();
        while ((line = br.readLine()) != null) {
            text.append(line);
        }

        if (!text.toString().trim().isEmpty()) {
            String[] userEntries = text.toString().split("<NewUser/>");
            for (String entry : userEntries) {
                String[] fields = entry.split("<n/>");
                if (fields.length >= 4) {
                    User user;
                    if (fields[3].equals("Admin")) {
                        user = new Admin(fields[0], fields[1], fields[2]);
                    } else {
                        user = new NormalUser(fields[0], fields[1], fields[2]);
                    }
                    users.add(user);
                    username.add(user.getName());
                }
            }
        }
    } catch (IOException e) {
        System.err.println("Error while loading users: " + e.getMessage());
    }
}

    private void saveUsers() {
        StringBuilder text = new StringBuilder();
        for (User user : users) {
            text.append(user.toString()).append("<NewUser/>\n");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersfile))) {
            writer.write(text.toString());
            System.out.println("User data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error while saving user data: " + e.getMessage());
        }
    }


    /*
    private void saveUsers(){
        String text1="";
        for (User user : users) {
            text1=text1+user.toString()+"<NewUser/>\n";
        }
        try {
            PrintWriter pw=new PrintWriter(booksfile);
            pw.print(text1);
            pw.close();

            System.err.println("Data Saved");
                    }catch (Exception e){
            System.err.println(e.toString());
        }


    }*/
    private void saveBooks(){
        String text1="";
        for (Book book : books) {
            text1=text1+book.toString()+"<NewBook/>\n";
        }
        try {
            PrintWriter pw=new PrintWriter(booksfile);
            pw.print(text1);
            pw.close();
        }catch (Exception e){
            System.err.println(e.toString());
        }


    }
    private void getBooks(){
        String text1="";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(booksfile));
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text1 += s1;
            }
            br1.close();
        }catch (Exception e){
            System.err.println(e.toString());
        }

        if (!text1.matches(" ") || !text1.isEmpty() ){
            String [] a1=text1.split("<NewBook/>");
            for (String s : a1) {
                Book book=parseBook(s);
                books.add(book);
                booknames.add(book.getName());
            }
        }
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
    public ArrayList<Book> getAllBooks(){
        return books;
    }
          public int getBook(String booknams){
        int i=-1;
        for (Book book : books) {
            if(book.getName().matches(booknams));
            i=books.indexOf(book);
        }
        return i;
          }

          public void deleteBook(int i){
        books.remove(i);
        booknames.remove(i);

          }

    public void deleteAllData() {
        if (usersfile.exists()) {
            try {
                usersfile.delete();
            } catch (Exception e) {
            }
        }
        if (booksfile.exists()) {
            try {
                booksfile.delete();
            } catch (Exception e) {
            }
        }
        if (ordersfile.exists()) {
            try {
                ordersfile.delete();
            } catch (Exception e) {
            }
        }
    }


    private void saveOrders(){
        String text1="";
        for (Order order : orders) {
            text1=text1+order.toString()+"<NewOrder/>\n";
        }
        try {
            PrintWriter pw=new PrintWriter(ordersfile);
            pw.print(text1);
            pw.close();
        }catch (Exception e){
            System.err.println(e.toString());
        }


    }

    public  void addOrder(Order order,Book book, int bookundex) {
        orders.add(order);
        books.set(bookundex,book);
        saveOrders();
    }

    public void getOrders(){
    String text1="";
    try {
        BufferedReader br1 = new BufferedReader(new FileReader(ordersfile));
        String s1;
        while ((s1 = br1.readLine()) != null) {
            text1 += s1;
        }
        br1.close();
    }catch (Exception e){
        System.err.println(e.toString());
    }

    if (!text1.matches(" ") || !text1.isEmpty() ){
        String [] a1=text1.split("<NewOrder/>");
        for (String s : a1) {

            Order order=persOrder(s);
            orders.add(order);
          }
    }
}

private User getUserByName(String name){
        User u=new NormalUser("") ;
        for (User user : users) {
            if (user.getName().matches(name)) {
                u=user;
                break;
            }
        }
        return u;
}

        private Order persOrder(String s){

        String[] a = s.split("<n/>");
        Order order=new Order(books.get(getBook(a[0]))
                ,getUserByName(a[1]),Double.parseDouble(a[2])
                ,Integer.parseInt(a[3]));
        return order;


    }
    public ArrayList<Order> getAllOrders(){
        return orders;
    }
}
