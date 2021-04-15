package com.laon.sms.domain.user.api;

import com.laon.sms.domain.user.application.UserService;
import com.laon.sms.domain.user.dto.TokenResponse;
import com.laon.sms.domain.user.dto.UserResponse;
import com.laon.sms.domain.user.entity.User;
import com.laon.sms.global.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserApi {

    private final UserService userService;

    @PutMapping("/session")
    public ApiResponse<UserResponse> out(@AuthenticationPrincipal @RequestBody @Valid User user) {
        return new ApiResponse<>(HttpStatus.OK, userService.withDraw(user));
    }

    @GetMapping("/me")
    public ApiResponse<TokenResponse> me(@AuthenticationPrincipal User user) {
        return new ApiResponse<>(HttpStatus.OK, userService.me(user));
    }

    @PutMapping("/updateuser")
    public ApiResponse<UserResponse> UpdateUser(@Valid @RequestBody
                                                    @AuthenticationPrincipal User user) {
        return new ApiResponse<>(HttpStatus.OK, userService.ChangeInfo(user));
    }
}
