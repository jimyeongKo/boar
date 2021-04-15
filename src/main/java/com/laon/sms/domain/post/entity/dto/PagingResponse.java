package com.laon.sms.domain.post.entity.dto;


import com.laon.sms.domain.post.entity.HashTagPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PagingResponse<T>{
    private int currentPage;
    private int totalPage;
    private Long totalCount;
    private List<PostResponse>list;
    private List<HashTagPost>hashList;

    public <R> PagingResponse(R collect) {

    }


        public PagingResponse(List<PostResponse>postList){


this.list = postList;

    }





/*
    public PagingResponse<T>(List<T>postList,Comment comment){

        super();


    }*/

}
