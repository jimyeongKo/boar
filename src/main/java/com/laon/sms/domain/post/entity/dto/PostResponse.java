package com.laon.sms.domain.post.entity.dto;


import com.laon.sms.domain.post.entity.Comment;
import com.laon.sms.domain.post.entity.HashTagPost;
import com.laon.sms.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class PostResponse {


    private String email;

    private String content;

    //private List<CommentResponse> comments;
    private CommentResponse comments;

    public PostResponse(Post post){

       this.content = post.getPostContents();


       try{
           post.getComments().size();
           this.comments = post.getComments()
                   .stream().map(CommentResponse::new).collect(Collectors.toList())
                   .get(post.getComments().size()-1);

       }catch (Exception e){
           log.info("댓글이 존재하지 않습니다.");
       }
    }



}
