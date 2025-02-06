package com.shambhu.SpringSecurity.service;

import com.shambhu.SpringSecurity.dto.UserDetailsImplementation;
import com.shambhu.SpringSecurity.dto.Users;
import com.shambhu.SpringSecurity.repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
   @Autowired
   private MyUserRepo myUserRepo;
   BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=myUserRepo.findByUsername(username);
        if (user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserDetailsImplementation(user);
    }

    public Users register(Users user){
        user.setPasword(encoder.encode(user.getPasword()));
        return myUserRepo.save(user);
    }
}
