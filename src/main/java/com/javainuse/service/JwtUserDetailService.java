package com.javainuse.service;

import com.javainuse.model.Driver;
import com.javainuse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;

@Service
//@Qualifier("Thus is")
public class JwtUserDetailService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly= true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


       // Driver driver = new Driver("kk","kk","kk");
        Driver driver  = userRepository.findByUsername(username);
        if(driver  ==null){
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
// grantedAuthorities.add(new SimpleGrantedAuthority("user"));
        return new org.springframework.security.core.userdetails.User(driver.getUsername(), driver.getPassword(),grantedAuthorities) ;
    }


}
