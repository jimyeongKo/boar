package com.laon.sms.domain.post.entity.application;


import com.laon.sms.domain.post.entity.HashTag;
import com.laon.sms.domain.post.entity.HashTagPost;
import com.laon.sms.domain.post.entity.Image;
import com.laon.sms.domain.post.entity.Post;
import com.laon.sms.domain.post.entity.dto.*;
import com.laon.sms.domain.post.entity.persistence.HashTagPostRepository;
import com.laon.sms.domain.post.entity.persistence.HashTagRepository;
import com.laon.sms.domain.post.entity.persistence.ImageRepository;
import com.laon.sms.domain.post.entity.persistence.PostJapRepository;
import com.laon.sms.domain.user.entity.User;
import com.laon.sms.domain.user.persistence.UserRepository;
import com.laon.sms.global.Utill.FIleUpload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final ImageRepository imageRepository;

    private final HashTagPostRepository hashTagRepository;

    private final HashTagRepository hashRepository;

    private final PostJapRepository postRepository;

    private final UserRepository userRepository;

    public PostResponse postWrite(List<MultipartFile> img, PostRequest dto) {

        //TODO: 얘 뺴기
        User user = userRepository.findByEmail(dto.getEmail()).orElseThrow(IllegalArgumentException::new);

        //TODO: 얘도 빼기
        Post post = Post.create(dto, user);

        post = postRepository.save(post);

        if (img.size() != 0) {

            imgUpload(img, post);
        }
        if (dto.getHashTags().size() != 0) {


            saveHashTagPost(dto.getHashTags(),post);


        }
        return new PostResponse(post);

    }


    public void imgUpload(List<MultipartFile> img,Post post) {


        img.forEach(file -> {
            String location = "/" + post.getId() + "/" + LocalDate.now() + "/" + file.getOriginalFilename();
            try {
                FIleUpload.upLoadImage(file, location);
            } catch (IOException e) {
                throw new IllegalArgumentException("파일저장에 실패");
            }

            imageRepository.save(Image.create(location,post));
        });
    }


    public void saveHashTagPost(List<String> hashTag, Post post) {

        hashTag.forEach(tag -> {

            HashTag hashtag = hashRepository.findByHashTagName(tag).orElseGet(() -> saveHashTag(tag));

            hashTagRepository.save(HashTagPost.create(hashtag, post));

        });

    }

    public HashTag saveHashTag(String tag) {

        return hashRepository.save(HashTag.create(tag));
    }

    public PagingResponse selectPost(int page) {

        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "id");

        //Page<Post>list = postRepository.findAll(pageable);

        //list.getContent().stream().map(e ->);

/*
return postRepository.findAll(pageable).getContent().stream().map(e -> new PostResponse(e)).collect(Collectors.toList());
*/

        return new PagingResponse(postRepository.findAll(pageable).getContent().stream().map(PostResponse:: new).collect(Collectors.toList()));
    }


    //해당 해시테그가 있는지 확인하는 메서드

    public HashTag  checkHashTag(String tag){




       return  hashRepository.findByHashTagName(tag).orElseThrow(IllegalArgumentException::new);


    }

    public  List<HashTagPostResponse> selectPostByTagNamed(String dto){


        log.info(dto);
        // 리퀘스트로 받아온 해쉬테그가 있는지 확인
       HashTag hashTag = checkHashTag(dto);
      List<HashTagPostResponse> tagPost = hashTagRepository.findAllByHashTagId(hashTag.getId()).stream().map(HashTagPostResponse::new).collect(Collectors.toList());


      return tagPost;
    }


    @Transactional
    public  List<HashTagPostResponse> selectPostByTagNameds(String dto){

        HashTag hashTag = checkHashTag(dto);

     hashTagRepository.findAllByHashTagId(hashTag.getId()).stream().map(HashTagPostResponse::new).collect(Collectors.toList());

        //log.info(post.getPost().getPostContents());

        return  hashTagRepository.findAllByHashTagId(hashTag.getId()).stream().map(HashTagPostResponse::new).collect(Collectors.toList());

    }

    public OnePostResponse selectPost(Long postNum){

        return new OnePostResponse(postRepository.findById(postNum).get());
    }



}
