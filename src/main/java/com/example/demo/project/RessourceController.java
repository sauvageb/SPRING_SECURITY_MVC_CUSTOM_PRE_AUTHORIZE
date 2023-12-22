package com.example.demo.project;

import com.example.demo.authentication.AuthenticationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RessourceController {

    private AuthenticationService authenticationService;

    public RessourceController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/prepareSignin")
    public String displayHome() {
        authenticationService.prepareSignIn();
        return "home";
    }

    @GetMapping("/protectedAAA")
    @PreAuthorize("@authenticationService.hasCodeAction('AAA')")
    public String aaaAccess() {
        System.out.println("OK");
        return "protected";
    }

    @GetMapping("/protectedBBB")
    @PreAuthorize("@authenticationService.hasCodeAction('BBB')")
    public String bbbAccess() {
        System.out.println("OK");
        return "protected";
    }


    // TODO : en cours
    @GetMapping("/organizations/{id}")
    @PreAuthorize("isMember(#id)")
    public String nextAccess(@PathVariable Long id) {
        System.out.println("OK");
        return "protected";
    }

}
