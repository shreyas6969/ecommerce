package com.coders.ecommerce.contoller;

import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coders.ecommerce.entity.UserProfile;
import com.coders.ecommerce.exception.ResourceNotFoundException;
import com.coders.ecommerce.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/user/profile")
@Slf4j
public class UserProfileController {

	@Autowired
    private UserProfileService userProfileService;

    @PostMapping("/")
    public UserProfile saveUserProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.saveUser(userProfile);
    }

    @GetMapping("/{id}")
    public UserProfile getUserProfile(@PathVariable("id") Long userId) {
        return userProfileService.getUser(userId);
    }
    
    @PutMapping(path="/{id}")
    public ResponseEntity<UserProfile> updateUser(@PathVariable("id") Long userId,@Valid @RequestBody UserProfile userProfile) throws 
    URISyntaxException {
    	if (userProfileService.getUser(userId) == null) {
            throw new ResourceNotFoundException("User id should not be null");
        }
        UserProfile updateUser=userProfileService.getUser(userId);
    	updateUser.setUserImageUrl(userProfile.getUserImageUrl());
    	updateUser.setFirstName(userProfile.getFirstName());
    	updateUser.setLastName(userProfile.getLastName());
    	updateUser.setPrimaryAddress(userProfile.getPrimaryAddress());
    	updateUser.setSecondaryAddress(userProfile.getSecondaryAddress());
    	updateUser.setPhoneNumber(userProfile.getPhoneNumber());
    	updateUser.setEmail(userProfile.getEmail());
        UserProfile result = userProfileService.saveUser(updateUser);
        return ResponseEntity.ok().body(result);
    }
    
    
}