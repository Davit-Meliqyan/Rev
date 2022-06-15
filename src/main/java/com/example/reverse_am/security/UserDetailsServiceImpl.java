package com.example.reverse_am.security;

import com.example.reverse_am.entities.User;
import com.example.reverse_am.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

            User user = userRepository.getUserByEmail(email);

            if (user == null) {
                throw new UsernameNotFoundException("Could not find user");
            }

            return new MyUserDetails(user);
    }
}
