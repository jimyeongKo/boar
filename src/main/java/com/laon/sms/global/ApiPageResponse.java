package com.laon.sms.global;


import com.laon.sms.domain.post.entity.Post;
import com.laon.sms.domain.post.entity.dto.PostResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@RequiredArgsConstructor

public class ApiPageResponse<T> {


    private long totalCount;

    private int currentPage;

    private int totalPage;

    private List<T>data;


    public ApiPageResponse(HttpStatus ok, Page<Post> selectPost) {
    }

    public ApiPageResponse(HttpStatus ok, List<PostResponse> selectPost) {
    }
}
