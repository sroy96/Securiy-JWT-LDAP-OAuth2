//package com.security.security.Configs;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfig  extends WebSecurityConfigurerAdapter {
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("Saurav")
//                .password("1234")
//                .roles("USER")
//                .and()
//                .withUser("foo")
//                .password("foo")
//                .roles("ADMIN");
//
//    }
//
//    @Bean
//   public  PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//
//    /**
//     *
//     * @param http
//     * @throws Exception
//     * Admin login session can access both user and admin.
//     * But User Login session can access only User session.
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("USER","ADMIN")
//
//                .antMatchers("/").permitAll()
//                .and().formLogin();
//    }
//}
