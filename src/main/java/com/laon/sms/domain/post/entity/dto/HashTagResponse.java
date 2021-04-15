package com.laon.sms.domain.post.entity.dto;

import com.laon.sms.domain.post.entity.HashTag;
import com.laon.sms.domain.post.entity.HashTagPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HashTagResponse {

    private String tagName;

    public HashTagResponse(HashTag tag){

        this.tagName =getTagName();
    }


}
