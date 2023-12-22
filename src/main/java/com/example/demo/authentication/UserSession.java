package com.example.demo.authentication;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
class UserSession implements Serializable {

    private List<String> codeActions = new ArrayList<>();

    public boolean hasCodeAction(String codeAction) {
        return codeActions.contains(codeAction);
    }

    public void addCodeAction(String codeAction) {
        this.codeActions.add(codeAction);
    }
}

