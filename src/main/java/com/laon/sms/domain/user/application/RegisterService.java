package com.laon.sms.domain.user.application;

import com.laon.sms.domain.user.dto.UserRequest;
import com.laon.sms.domain.user.dto.UserResponse;
import com.laon.sms.domain.user.entity.User;
import com.laon.sms.domain.user.exception.EmailDuplicateException;
import com.laon.sms.domain.user.exception.NickDuplicateException;
import com.laon.sms.domain.user.persistence.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
@Transactional
public class RegisterService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserResponse create(UserRequest request) {
        duplicateEmail(request.getEmail()); //이메일이 있는지 확인
        duplicateNickName(request.getNickName()); //닉네임이 존재하는지 확인

        User user = User.create(request, passwordEncoder.encode(request.getPassword())); //유저 회원가입

        userRepository.save(user); //저장

        return new UserResponse(user);
    }

    //이메일이 있는지 확인 해주는 로직(있으면 존재한다는 에러 던져줌)
    private void duplicateEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) throw new EmailDuplicateException(email);
    }

    //이메일이 있는지 확인 해주는 로직(있으면 존재한다는 에러 던지기)
    private void duplicateNickName(String nickName) {
        Optional<User> user = userRepository.findByNickName(nickName);
        if (user.isPresent()) throw new NickDuplicateException(nickName);

    }
}
