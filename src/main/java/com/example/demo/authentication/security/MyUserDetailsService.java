package com.example.demo.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final User user = new User();
        // TODO : call API
        // init fake user below
        final Privilege privilege1 = new Privilege("FOO_READ_PRIVILEGE");
        user.setUsername("boris");
        user.setPassword(encoder.encode("boris"));
        user.setPrivileges(new HashSet<>(List.of(privilege1)));
        final Organization org1 = new Organization("FirstOrg");
        user.setOrganization(org1);

        return new MyUserPrincipal(user);
    }
}
