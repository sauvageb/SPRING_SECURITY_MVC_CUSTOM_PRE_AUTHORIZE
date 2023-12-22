package com.example.demo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserSession userSession;

    public AuthenticationServiceImpl(@Autowired UserSession userSession) {
        this.userSession = userSession;
    }

    public boolean prepareSignIn() {
        // TODO : call API
        userSession.addCodeAction("AAA");
        return false;
    }

    @Override
    public boolean hasCodeAction(String value) {
        return userSession.hasCodeAction(value);
    }

}
