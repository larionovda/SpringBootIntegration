package com.larionov.epam.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class User implements UserDetails {
    private List<Role> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean enabled;

    public User() {
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.enabled = true;
    }
}
