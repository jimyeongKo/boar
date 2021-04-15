package com.laon.sms.domain.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HashTagPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private HashTag hashTag;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;


    public static HashTagPost create(HashTag tag,Post post){


        return HashTagPost.builder().hashTag(tag).post(post).build();
    }

}
