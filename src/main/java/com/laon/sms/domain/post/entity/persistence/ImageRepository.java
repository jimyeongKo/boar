package com.laon.sms.domain.post.entity.persistence;

import com.laon.sms.domain.post.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository <Image,Long> {
}
