package com.laon.sms.domain.post.entity.persistence;

import com.laon.sms.domain.post.entity.HashTag;
import com.laon.sms.domain.post.entity.HashTagPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HashTagRepository extends JpaRepository<HashTag,Long> {

    Optional<HashTag> findByHashTagName(String hashTagName);

    //Optional<HashTag>  findByHashTagId(Long hashTagId);
}
