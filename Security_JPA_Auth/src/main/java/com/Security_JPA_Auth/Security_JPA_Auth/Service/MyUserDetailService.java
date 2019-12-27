package com.Security_JPA_Auth.Security_JPA_Auth.Service;


import com.Security_JPA_Auth.Security_JPA_Auth.Model.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailService implements UserDetailsService {
    /**
     * Principal<----||||Authentication Manager <--> Authentication Provider<--->UserDetails Service <---> JPA Service <---->DB
     *
     * After  getting clearance
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new MyUserDetails(s);
    }
}
