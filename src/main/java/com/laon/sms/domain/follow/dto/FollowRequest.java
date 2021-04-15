package com.laon.sms.domain.follow.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FollowRequest {

    private String follow;
    private String follower;

}
