package com.vladimirt.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.vladimirt.model.MyUser;
import com.vladimirt.repository.MyUserRepository;

import static com.vladimirt.service.TestData.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MyUserServiceTest {

    @Mock
    private MyUserRepository repository;

    @InjectMocks
    private MyUserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll_ReturnUsers() {
        List<MyUser> list = getUserList();
        when(repository.getAll()).thenReturn(list);

        assertEquals(userService.getAllUsers(), list);
    }

    @Test
    public void testCreate_ValidUser_VerifyInvocationsNumber() {
        MyUser user = getUser();
        userService.createNewUser(user);

        verify(repository, times(1)).createUser(user);
    }


    @Test
    public void testFindById_ValidId_VerifyInvocationsNumber() {
        MyUser user = getUser();
        String id = user.getId();
        userService.deleteUserById(id);

        verify(repository, times(1)).findById(id);
    }


    @Test
    public void testDelete_ValidUser_VerifyInvocationsNumber() {
        MyUser user = getUser();
        userService.deleteUser(user);

        verify(repository, times(1)).deleteUser(user);
    }
}