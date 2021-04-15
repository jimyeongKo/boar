package com.laon.sms.domain.post.entity.api;


import com.laon.sms.domain.post.entity.application.PostService;
import com.laon.sms.domain.post.entity.dto.PagingResponse;
import com.laon.sms.domain.post.entity.dto.PostRequest;
import com.laon.sms.global.ApiListResponse;
import com.laon.sms.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("post")
public class PostApi {


    private final PostService postService;

    @PostMapping(value = "/write", consumes = {"multipart/form-data"})
    public ApiResponse write(@RequestPart("img") List<MultipartFile> img, @RequestPart(value = "post")PostRequest dto){

        return new ApiResponse(HttpStatus.OK,postService.postWrite(img,dto));


    }


    @GetMapping(value="/select")
    public PagingResponse selectPost(@RequestParam(name="page",defaultValue = "1")int page){


        //return new ApiPageResponse(HttpStatus.OK,postService.selectPost(page));

        return postService.selectPost(page);
    }
@GetMapping("/hashtag")
    public ApiListResponse selectPostByHashTag(@RequestParam String hashTag){

        return new ApiListResponse(postService.selectPostByTagNameds(hashTag));
}


    @GetMapping("/selectpost")

    public ApiResponse selectPost(@RequestParam Long postNum){

        return new ApiResponse(HttpStatus.OK,postService.selectPost(postNum));
    }
}
