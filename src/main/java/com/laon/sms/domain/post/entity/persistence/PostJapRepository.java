package com.laon.sms.domain.post.entity.persistence;

import com.laon.sms.domain.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostJapRepository extends JpaRepository<Post,Long> {


    Optional<Post> findByUserId(Long userId);

    Page<Post>findAll(Pageable pageable);
}
