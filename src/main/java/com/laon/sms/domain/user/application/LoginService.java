package com.laon.sms.domain.user.application;

import com.laon.sms.domain.user.dto.LoginRequest;
import com.laon.sms.domain.user.dto.TokenResponse;
import com.laon.sms.domain.user.entity.User;
import com.laon.sms.domain.user.exception.AlreadyWithdrawUserException;
import com.laon.sms.domain.user.exception.PasswordNotMatchedException;
import com.laon.sms.domain.user.persistence.UserRepository;
import com.laon.sms.global.api.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public TokenResponse login(LoginRequest request) {

        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if (user.get().getStatus() == false)
            throw new AlreadyWithdrawUserException(request.getEmail()); //탈퇴 회원인지 확인

        matchPassword(user.get().getPassword(), request.getPassword());

        String token = jwtTokenProvider.createToken(String.valueOf(user.get().getEmail()), user.get().getRoles());

        return new TokenResponse(token, user.get());
    }
    public void matchPassword(String encodePassword, String password) {
        if (!passwordEncoder.matches(password, encodePassword)) throw new PasswordNotMatchedException(password);
    }

}
