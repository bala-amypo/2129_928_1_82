package com.example.demo.Service;

import com.example.demo.Entity.UserAccount;

public interface UserAccountService {

    UserAccount registerUser(UserAccount user);

    UserAccount findByEmail(String email);
   
}