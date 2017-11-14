package com.tb.mvc.security.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * TEST PURPOSE: Used to create password to test login form.
 * @author Tiago Brazão
 *
 */
public class QuickPasswordEncodingGenerator {
  
    public static void main(String[] args) {
            String password = "password";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.println(passwordEncoder.encode(password));
    }
  
}
