package com.laon.sms.domain.post.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {

    private Long parent_id;

    private String content;

    private Long post_id;

    private String email;



}
