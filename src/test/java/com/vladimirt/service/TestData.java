package com.vladimirt.service;

import com.vladimirt.model.MyUser;
import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static MyUser getUser() {
        MyUser user = new MyUser();
        user.setName("Vladimir");
        user.setSurname("Tikaev");
        return user;
    }

    public static List<MyUser> getUserList() {
        MyUser user = new MyUser();
        user.setName("Vladimir");
        user.setSurname("Tikaev");

        MyUser secondUser = new MyUser();
        secondUser.setName("Yan");
        secondUser.setSurname("Tasheiko");


        MyUser thirdUser = new MyUser();
        thirdUser.setName("Nik");
        thirdUser.setSurname("Bogdan");

        List<MyUser> list = new ArrayList<>();
        list.add(user);
        list.add(secondUser);
        list.add(thirdUser);

        return list;
    }
}