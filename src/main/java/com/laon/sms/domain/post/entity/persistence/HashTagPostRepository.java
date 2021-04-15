package com.laon.sms.domain.post.entity.persistence;

import com.laon.sms.domain.post.entity.HashTag;
import com.laon.sms.domain.post.entity.HashTagPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HashTagPostRepository extends JpaRepository<HashTagPost,Long> {

    List<HashTagPost>findAllByHashTagId(Long tag);

    Optional<HashTagPost> findByHashTagId(Long id);
}




