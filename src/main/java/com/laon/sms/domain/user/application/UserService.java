package com.laon.sms.domain.user.application;

import com.laon.sms.domain.user.dto.TokenResponse;
import com.laon.sms.domain.user.dto.UserResponse;
import com.laon.sms.domain.user.entity.User;
import com.laon.sms.domain.user.persistence.UserRepository;
import com.laon.sms.global.api.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse me(User user) {
        User my = userRepository.findById(user.getId()).orElseThrow();
        //토큰 발행
        String token = jwtTokenProvider.createToken(String.valueOf(user.getId()), user.getRoles());
        return new TokenResponse(token, my);
    }

    @Transactional
    public UserResponse withDraw(User user) {
        user.sessionUpdate();

        return new UserResponse(user);
    }

    @Transactional
    public UserResponse ChangeInfo(User user) {
        User member = userRepository.findByEmail(user.getEmail()).orElseThrow(IllegalArgumentException::new);
        member.InfoUpdate(user);

        return new UserResponse(member);
    }


}
