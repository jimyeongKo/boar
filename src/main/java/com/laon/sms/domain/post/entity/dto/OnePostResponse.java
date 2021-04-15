package com.laon.sms.domain.post.entity.dto;


import com.laon.sms.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class OnePostResponse {

    private String postContent;
    private Long postNum;
    private String userEmail;
    private List<HashTagPostResponse> tagList;
    private List<CommentChildrenResponse> commentList;



    public OnePostResponse(Post post){

        this.postContent = post.getPostContents();
        this.postNum =post.getId();
        this.userEmail = post.getUser().getEmail();
        this.tagList = post.getHashTagPosts().stream().map(HashTagPostResponse::new).collect(Collectors.toList());
        this.commentList =post.getComments().stream().map(CommentChildrenResponse::new).collect(Collectors.toList());
    }

}
