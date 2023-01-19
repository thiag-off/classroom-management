package com.api.classroom_management.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("EMAIL:" + email +" NOT FOUND"));
    }


    public String signUpUser(UserModel user){

        Boolean emailExists = userRepository
                .findByEmail(user.getEmail()).isPresent();

        if (emailExists){
            throw new IllegalStateException("EMAIL TAKEN");
        }

        userRepository.save(user);

        return "registered";
    }
}
