package com.Security_JPA_Auth.Security_JPA_Auth.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * This class is an implementation of interface called UserDetails
 * UserDetails methods use the form login data and provide authorizations based on roles.
 * ->> Providing hard coded data.
 */
public class MyUserDetails  implements UserDetails {


    private String userName;

    public MyUserDetails() {}

    public MyUserDetails(String userName) {
        this.userName = userName;
    }


    /**
     * After the user gives the username it checks in the list what ROLE it is authorized.
     * MyUserDetailServices get the username entered and check if the user exist or not (OR ANY OTHER FUNCTIONALITY coded )
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    /**
     * PassWord of the User is hard coded ("pass" has to use to login)
     * @return
     */
    @Override
    public String getPassword() {
        return "pass";
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
