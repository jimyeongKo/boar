package com.laon.sms.domain.post.entity.application;


import com.laon.sms.domain.post.entity.Comment;
import com.laon.sms.domain.post.entity.HashTag;
import com.laon.sms.domain.post.entity.HashTagPost;
import com.laon.sms.domain.post.entity.Post;
import com.laon.sms.domain.post.entity.dto.CommentChildrenResponse;
import com.laon.sms.domain.post.entity.dto.CommentCreateRequest;
import com.laon.sms.domain.post.entity.dto.CommentRequest;
import com.laon.sms.domain.post.entity.dto.CommentResponse;
import com.laon.sms.domain.post.entity.persistence.CommentRepository;
import com.laon.sms.domain.post.entity.persistence.PostJapRepository;
import com.laon.sms.domain.user.entity.User;
import com.laon.sms.domain.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostJapRepository postRepository;
    public CommentResponse writeComment(CommentRequest dto) {

        Long parentId = null;

        parentId =dto.getParent_id();

        User user = findUser(dto.getEmail());

        Post post = findPost(dto.getPost_id());

        Comment parentComment = null;

        log.info("게시글 아이디"+dto.getPost_id());
        //TODO: dto.parentId 를 통해서 상위 댓글의 존재여부를 체크하는 메서드 필요 null -> 에러
        if (parentId != null) {
            log.info("댓글입니다.");
            //TODO: checkParentId 필요한 메서드인지 잘 모르겠습니다.
            checkParentId(parentId);

            parentComment = findParentComment(dto.getParent_id());
        }

        CommentCreateRequest vo = new CommentCreateRequest(user,post,parentComment);

        Comment comment = Comment.create(vo,dto);

        return new CommentResponse(commentRepository.save(comment));
    }

    public void checkParentId(Long parentId) {

        //TODO: 예외처리 만들어서 해주기

        commentRepository.findById(parentId).orElseThrow(IllegalArgumentException::new);

    }
    public User findUser(String email){

        //TODO: 예외처리 만들어서 해주기

        return userRepository.findByEmail(email).get();
    }
    public Post findPost(Long Id){

        //TODO: 예외처리 만들어서 해주기

        return  postRepository.findById(Id).get();
    }

    public Comment findParentComment(Long id){

        //TODO: 예외처리 만들어서 해주기

        return  commentRepository.findById(id).orElseGet(null);
    }

    public List<CommentResponse> selectComment(int page, Long postId){

        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.ASC, "id");

        return commentRepository.findAllByPostIdAndParentIdIsNull(postId,pageable).getContent().stream().map(CommentChildrenResponse::new).collect(Collectors.toList());

    }

}
