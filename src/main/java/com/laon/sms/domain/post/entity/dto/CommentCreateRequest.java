package com.laon.sms.domain.post.entity.dto;

import com.laon.sms.domain.post.entity.Comment;
import com.laon.sms.domain.post.entity.Post;
import com.laon.sms.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@Getter
@NoArgsConstructor
public class CommentCreateRequest extends CommentRequest {


    private User user;
    private Post post;
    private Comment parent;

    public CommentCreateRequest(User user,Post post,Comment comment){

        this.user =user;
        this.post =post;
        this.parent =comment;
    }

}
