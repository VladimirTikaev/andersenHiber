package com.vladimirt;

import com.vladimirt.model.MyUser;
import com.vladimirt.service.MyUserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyUser user = new MyUser("Vladimir", "Tikaev");
        MyUser user1 = new MyUser("Igor", "Vorobev");
        MyUserService service = new MyUserService();
        service.createNewUser(user);
        service.createNewUser(user1);

        List<MyUser>  users = service.getAllUsers();

        for ( MyUser u : users) {
            System.out.println(u.getName());
        }
    }
}
