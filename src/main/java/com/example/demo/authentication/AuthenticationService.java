package com.example.demo.authentication;

import org.springframework.stereotype.Service;


public interface AuthenticationService {

    boolean prepareSignIn();

    boolean hasCodeAction(String value);
}
