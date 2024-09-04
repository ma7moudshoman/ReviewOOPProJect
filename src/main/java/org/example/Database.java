package org.example;

import java.util.ArrayList;

public class Database {

ArrayList<User> users=new ArrayList<User>();
ArrayList<String> username =new ArrayList<String>();

public void addUser(User user) {
    users.add(user);
    username.add(user.getName());
}

public int login(String phoneNumber , String email){
    int flag=-1;
    for(User user: users){
 if (user.getPhoneNumber().equals(phoneNumber) && user.getEmail().equals(email)){
     flag=users.indexOf(user);
break;
 }
    }
    return flag;
}


public User getUser(int flag) {
    return users.get(flag);
}

}

