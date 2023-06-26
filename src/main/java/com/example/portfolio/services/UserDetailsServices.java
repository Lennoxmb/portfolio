package com.example.portfolio.services;


import com.example.portfolio.models.User;
import com.example.portfolio.models.UserDetail;
import com.example.portfolio.repositories.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServices implements UserDetailsService {
    public final UserRepo usersDao;

    public UserDetailsServices(UserRepo usersDao){
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User details not found for user: " + username);
        } else {
            return new UserDetail(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
        }
    }
}

