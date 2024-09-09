package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

public class Database {

/*

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> username = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> booknames = new ArrayList<>();

    private File usersfile;
    private File booksfile;
*/
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> username = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> booknames = new ArrayList<String>();

private File usersfile =new File("D:\\projects\\OOPNewProject\\src\\main\\java\\Data\\Users.txt");
private File booksfile =new File("D:\\projects\\OOPNewProject\\src\\main\\java\\Data\\Books.text");
private File file=new File("D:\\projects\\OOPNewProject\\src\\main\\java\\Data");

    public Database() {
        // الحصول على المسار من الموارد
        URL usersURL = Main.class.getClassLoader().getResource("Users");
        URL booksURL = Main.class.getClassLoader().getResource("Books");
if (!file.exists()) {
    file.mkdir();
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
            saveUsers();
        } else {
            System.err.println("Error: 'Books' resource not found.");
        }
    }

    // إضافة مستخدم إلى قاعدة البيانات
    public void addUser(User user) {
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
        }
        return flag;
    }

    // الحصول على مستخدم بناءً على المؤشر
    public User getUser(int flag) {
        return users.get(flag);
    }

    // إضافة كتاب إلى قاعدة البيانات
    public void addBook(Book book) {
        books.add(book);
        booknames.add(book.getName());
        saveBooks();
    }

    private void getUsers(){
        String text1="";

        try {
            BufferedReader br = new BufferedReader(new FileReader(usersfile));
       String s1;
       while ((s1 = br.readLine()) != null) {
           text1 += s1;
       }
       br.close();

        }catch (Exception e){
            System.err.println(e.toString());
        }

        if (!text1.matches(" ") || !text1.isEmpty() ){
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
    }


    private void saveUsers(){
        String text1="";
        for (Book book : books) {
            text1=text1+book.toString()+"<NewBook/>\n";
        }
        try {
            PrintWriter pw=new PrintWriter(booksfile);
            pw.print(text1);
            pw.close();
            System.err.println("Data Saved");
                    }catch (Exception e){
            System.err.println(e.toString());
        }

    }
    private void saveBooks(){
        String text1="";
        for (Book book : books) {
            text1=text1+book.toString()+"<NewBook/>\n";
        }
        try {
            PrintWriter pw=new PrintWriter(booksfile);
            pw.print(text1);
            pw.close();
            System.err.println("Data Saved");
        }catch (Exception e){
            System.err.println(e.toString());
        }

    }

    private void getBooks(){
        String text1="";

        try {
            BufferedReader br = new BufferedReader(new FileReader(usersfile));
            String s1;
            while ((s1 = br.readLine()) != null) {
                text1 += s1;
            }
            br.close();

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


}
