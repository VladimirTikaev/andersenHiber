package com.vladimirt.service;

import com.vladimirt.repository.MyUserRepository;
import com.vladimirt.model.MyUser;

import java.util.List;

public class MyUserService {

    private MyUserRepository repository = new MyUserRepository();

    public void createNewUser(MyUser user){

        repository.createUser(user);
    }

    public List<MyUser> getAllUsers(){
         return repository.getAll();
    }

    public void deleteUser(MyUser user) {
        repository.deleteUser(user);
    }

    public void deleteUserById(String id) {

       deleteUser(repository.findById(id));


    }
}
