package com.coders.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coders.ecommerce.entity.UserProfile;

@Repository
public interface UserProfileRepository  extends JpaRepository<UserProfile,Long> {
    UserProfile findByUserId(Long userId);
}