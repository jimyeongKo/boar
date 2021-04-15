package com.laon.sms.domain.user.dto;

import com.laon.sms.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse {

    private Long id;

    private String email;

    private String nickName;

    private LocalDate birthday;

    private String name;

    private String image;

    private Boolean status;

    private List<String> role;



    public UserResponse (final User user) {
        this.id = user.getId();
        this.image = user.getImage();
        this.email = user.getEmail();
        this.nickName = user.getNickName();
        this.birthday = user.getBirthday();
        this.name = user.getName();
        this.role = user.getRoles();
        this.status = user.getStatus();
    }
}
