package com.laon.sms.domain.post.entity.api;


import com.laon.sms.domain.post.entity.application.CommentService;
import com.laon.sms.domain.post.entity.dto.CommentRequest;
import com.laon.sms.global.ApiListResponse;
import com.laon.sms.global.ApiPageResponse;
import com.laon.sms.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentApi {

    private final CommentService service;

    @PostMapping("/write")
    public ApiResponse commentWrite(@RequestBody CommentRequest dto){

        return new ApiResponse(HttpStatus.OK,service.writeComment(dto));

    }

    @GetMapping ("/select")
    public ApiListResponse selectComment(@RequestParam int commentPage,@RequestParam Long postId){

        return new ApiListResponse(service.selectComment(commentPage,postId));


    }





}
