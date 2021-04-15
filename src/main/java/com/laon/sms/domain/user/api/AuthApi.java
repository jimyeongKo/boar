package com.laon.sms.domain.user.api;

import com.laon.sms.domain.user.application.LoginService;
import com.laon.sms.domain.user.application.RegisterService;
import com.laon.sms.domain.user.dto.LoginRequest;
import com.laon.sms.domain.user.dto.TokenResponse;
import com.laon.sms.domain.user.dto.UserRequest;
import com.laon.sms.domain.user.dto.UserResponse;
import com.laon.sms.global.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class AuthApi {

    private final LoginService loginService;
    private final RegisterService registerService;

    // 회원가입
    @PostMapping("/join")
    public ApiResponse<UserResponse> register(@Valid @RequestBody UserRequest request) {
        return new ApiResponse<>(HttpStatus.OK, registerService.create(request));
    }

    @PostMapping("/login")
    public ApiResponse<TokenResponse> login(@Valid @RequestBody LoginRequest dto) {
        return new ApiResponse<>(HttpStatus.OK, loginService.login(dto));
    }

}
