package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> username = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> booknames = new ArrayList<>();

    private File usersfile;
    private File booksfile;

    public Database() {
        // الحصول على المسار من الموارد
        URL usersURL = Main.class.getClassLoader().getResource("Users");
        URL booksURL = Main.class.getClassLoader().getResource("Books");

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
        } else {
            System.err.println("Error: 'Books' resource not found.");
        }
    }

    // إضافة مستخدم إلى قاعدة البيانات
    public void addUser(User user) {
        users.add(user);
        username.add(user.getName());
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
        if (flag >= 0 && flag < users.size()) {
            return users.get(flag);
        } else {
            return null;  // تجنب الاستثناءات الناتجة عن مؤشر غير صالح
        }
    }

    // إضافة كتاب إلى قاعدة البيانات
    public void addBook(Book book) {
        books.add(book);
        booknames.add(book.getName());
    }
    private void saveUsers(){
        String text1="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(usersfile));
        }catch (Exception e){
            System.err.println(e.toString());
        }
    }
    private void saveBooks(){
        String text1="";
        for (User user : users) {
            text1=text1+user.getName()+",";
        }
    }
}
