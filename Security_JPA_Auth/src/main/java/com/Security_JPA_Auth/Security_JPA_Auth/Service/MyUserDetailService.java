package com.Security_JPA_Auth.Security_JPA_Auth.Service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    /**
     * Principal<----||||Authentication Manager <--> Authentication Provider<--->UserDetails Service <---> JPA Service <---->DB
     *
     * Customized User Detail Service implement UserDetail Service Interface and return User Details Object using User name.
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return null;
    }
}
