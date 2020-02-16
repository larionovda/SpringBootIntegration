package com.larionov.epam.service;

import com.larionov.epam.dao.DataUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private DataUser dataUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return dataUser.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
