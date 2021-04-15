package com.laon.sms.domain.post.entity.dto;

import com.laon.sms.domain.post.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentChildrenResponse extends CommentResponse{



        private List<CommentChildrenResponse> children;

    public CommentChildrenResponse(Comment comment){

        super(comment);
        this.children = comment.getChildren().stream().map(CommentChildrenResponse::new).collect(Collectors.toList());

    }


}
