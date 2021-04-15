package com.laon.sms.domain.follow.entity;

import com.laon.sms.domain.follow.dto.FollowRequest;
import com.laon.sms.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User followUser;

    @ManyToOne(fetch = FetchType.LAZY)
    private User followerUser;


    public static Follow create(User follow, User follower){

        return Follow.builder().followUser(follow).followerUser(follower).build();
    }

}
