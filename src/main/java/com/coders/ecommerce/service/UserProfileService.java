package com.coders.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coders.ecommerce.entity.UserProfile;
import com.coders.ecommerce.repository.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;


    public UserProfile saveUser(UserProfile user) {
        return userProfileRepository.save(user);
    }

    public UserProfile getUser(Long userId) {
        UserProfile user = userProfileRepository.findByUserId(userId);
        return  user;
    }
    
    
}
