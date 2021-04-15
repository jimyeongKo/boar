package com.laon.sms.domain.post.entity.dto;

import com.laon.sms.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SubPostResponse {

private String post;

   public SubPostResponse(Post post){

       this.post = post.getPostContents();

   }
}
