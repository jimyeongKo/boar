package com.laon.sms.domain.post.entity.persistence;

import com.laon.sms.domain.post.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment,Long> {


    Page<Comment> findAllByPostIdAndParentIdIsNull(Long postId, Pageable pageable);

}
