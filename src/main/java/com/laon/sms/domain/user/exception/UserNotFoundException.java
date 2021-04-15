package com.laon.sms.domain.user.exception;

import com.laon.sms.global.api.Error.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(Long target) {
        super(target + "is not found");
    }
}
