package com.laon.sms.domain.follow.Api;

import com.laon.sms.domain.follow.applircation.FollowService;
import com.laon.sms.domain.follow.dto.ApiResponse;
import com.laon.sms.domain.follow.dto.FollowRequest;
import com.laon.sms.domain.follow.entity.Follow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowApi {

    private final FollowService followService;

    @PostMapping
    public ApiResponse followSave(@Valid @RequestBody FollowRequest FollowDTO) throws IllegalAccessException{


        log.info("여기는  FollowApi");
        System.out.print("여기는  FollowApi");

        return new ApiResponse(HttpStatus.OK,followService.follow(FollowDTO));
    }


    @DeleteMapping("/unfollow")
    public ApiResponse followDelete(@RequestBody FollowRequest FollowDTO) throws IllegalAccessException {


        log.info("여기는  unFollowApi");
        System.out.print("여기는  FollowApi");


  return new ApiResponse(HttpStatus.OK,followService.unfollow(FollowDTO));
    }



}

