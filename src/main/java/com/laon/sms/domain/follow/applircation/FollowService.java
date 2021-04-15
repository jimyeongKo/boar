package com.laon.sms.domain.follow.applircation;

import com.laon.sms.domain.follow.dto.FollowRequest;
import com.laon.sms.domain.follow.entity.Follow;
import com.laon.sms.domain.follow.persistance.FollowRepository;
import com.laon.sms.domain.user.entity.User;
import com.laon.sms.domain.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public Follow follow(FollowRequest followRequest) throws IllegalAccessException {

        User userFollow = userRepository.findByNickName(followRequest.getFollow()).orElseThrow(IllegalAccessError::new);
        User userFollower = userRepository.findByNickName(followRequest.getFollower()).orElseThrow(IllegalAccessError::new);

        Optional<Follow> follow = followRepository.findByFollowUserAndFollowerUser(userFollow, userFollower);

        if(follow.isPresent()) {
            throw new IllegalAccessException();
        }
            //unfollow(FollowRequest followRequest)

//        int followcheck = followRepository.countByFollowUserAndFollowerUser(follow,follower);
//        log.info(followcheck+ "여기는 중복체크입니다.");
//        if (followcheck>=1){
//            unfollow(followRequest.getFollow(),followRequest.getFollower());
//        }
//        Follow followline =  Follow.create(follow,follower);

        return followRepository.save(Follow.create(userFollow, userFollower));
    }

    public Follow unfollow(FollowRequest followRequest) throws IllegalAccessException {


        User follow = userRepository.findByNickName(followRequest.getFollow()).orElseThrow(IllegalAccessError::new);
        User follower = userRepository.findByNickName(followRequest.getFollower()).orElseThrow(IllegalAccessError::new);

        //Follow followline = followRepository.findByFollowUserAndFollowerUser(follow.getId(), follower.getId()).orElseThrow(IllegalAccessException::new);



        Follow followline = followRepository.findByFollowUserAndFollowerUser(follow,follower).orElseThrow(IllegalAccessException::new);




        followRepository.delete(followline);
        return followline;
    }
}
