package com.shambhu.SpringSecurity.service;

import com.shambhu.SpringSecurity.dto.Users;
import com.shambhu.SpringSecurity.repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private MyUserRepo myUserRepo;
    @Autowired
    AuthenticationManager authManager;

    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public Users register(Users user){
        user.setPasword(encoder.encode(user.getPasword()));
        return myUserRepo.save(user);
    }
    public String verify(Users user) {
        Authentication authentication= authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPasword()));
        if(authentication.isAuthenticated())
            return "success";
        return "false";
    }
}
