package com.laon.sms.domain.post.entity.dto;


import com.laon.sms.domain.post.entity.Comment;
import com.laon.sms.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {


private String content;
private Long userId;
private Long postId;


    public CommentResponse(Comment comment){

        this.content = comment.getCommentContents();
        this.userId = comment.getUser().getId();
        this.postId = comment.getPost().getId();

    }
}
