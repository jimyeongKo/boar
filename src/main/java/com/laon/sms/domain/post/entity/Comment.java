package com.laon.sms.domain.post.entity;

import com.laon.sms.domain.post.entity.dto.CommentCreateRequest;
import com.laon.sms.domain.post.entity.dto.CommentRequest;
import com.laon.sms.domain.user.entity.User;
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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parent;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "parent",orphanRemoval = true)
    private List<Comment> children = new ArrayList<Comment>();

    private String commentContents;

    public static Comment create(CommentCreateRequest dto,CommentRequest ddto){


        return Comment.builder().user(dto.getUser()).post(dto.getPost()).parent(dto.getParent()).commentContents(ddto.getContent()).build();

    }

}
