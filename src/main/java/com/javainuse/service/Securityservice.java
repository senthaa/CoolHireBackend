package com.javainuse.service;



public interface Securityservice {
    String findLoggedInUsername();

     void autoLogin(String username, String password);
}
