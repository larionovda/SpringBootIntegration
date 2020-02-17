package com.larionov.epam.service.rest.impl;

import com.larionov.epam.dao.DataUser;
import com.larionov.epam.service.rest.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private DataUser dataUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return dataUser.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void addNewUser(String username, String password) {
        dataUser.addUser(username, password);
    }
}
