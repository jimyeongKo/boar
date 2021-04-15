package com.laon.sms.domain.post.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    private String email;

    private String postContents;

    private List<String> hashTags;


}
