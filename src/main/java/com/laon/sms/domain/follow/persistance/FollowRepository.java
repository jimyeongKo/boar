package com.laon.sms.domain.follow.persistance;

import com.laon.sms.domain.follow.entity.Follow;
import com.laon.sms.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {

  Optional<Follow> findByFollowUserAndFollowerUser(User followUser, User followerUser);


    int countByFollowUserAndFollowerUser(User followUser, User followerUser);
}

