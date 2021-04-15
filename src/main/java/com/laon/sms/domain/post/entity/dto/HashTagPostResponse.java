package com.laon.sms.domain.post.entity.dto;

import com.laon.sms.domain.post.entity.HashTagPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HashTagPostResponse {

    private String email;
    private String postContent;
    private String tagName;

   // private SubPostResponse post;

   // private HashTagResponse tagname;
    public HashTagPostResponse(HashTagPost hashTagPost) {
       /* this.post = new SubPostResponse(hashTagPost.getPost());
        this.tagname = new HashTagResponse(hashTagPost.getHashTag());*/

        this.postContent = hashTagPost.getPost().getPostContents();
        this.tagName = hashTagPost.getHashTag().getHashTagName();
        this.email = hashTagPost.getPost().getUser().getEmail();
    }
}
