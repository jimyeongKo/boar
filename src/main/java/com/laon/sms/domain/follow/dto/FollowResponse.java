package com.laon.sms.domain.follow.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FollowResponse {

    private Long fid;
    private Long fwid;


    public FollowResponse(Long fid,Long fwid){

        this.fid =fid;
        this.fwid = fwid;
    }

}