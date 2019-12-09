package com.security.security.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class jdbcSecurityConfig  extends  WebSecurityConfigurerAdapter{

    /**
     * H2 database- Spring boot automatically create a datasource for embedded databases
     */

    @Autowired
    DataSource dataSource;


    /**
     *
     * @param auth
     * @throws Exception
     *
     * Not a real world application since User Details are not to be mentioned like this.
     * Thus Commenting it to make it a real life fervid.
     */
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()    //default schema in H2 database
//                .withUser(
//                        User.withUsername("user")
//                        .password("1234")
//                        .roles("USER")
//                )
//                .withUser(
//                        User.withUsername("admin")
//                                .password("pass")
//                                .roles("ADMIN")
//                );
//
//
//    }

    /**
     *
     * @param auth
     * @throws Exception
     * Custom Data from H2 database to filter the User Credentials and get the Principal data from Authentication Manager and Authorization Provider.
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username , password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username,authority from authorities where username = ?");




    }


    /**
     *
     * @param http
     * @throws Exception
     * Admin login session can access both user and admin.
     * But User Login session can access only User session.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")

                .antMatchers("/").permitAll()
                .and().formLogin();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
