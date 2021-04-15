package com.laon.sms.domain.user.exception;

import com.laon.sms.global.api.Error.ErrorCode;
import com.laon.sms.global.api.Error.InvalidValueException;

public class CheckUserNotFoundException extends InvalidValueException {
    public CheckUserNotFoundException (String value) {
        super(value, ErrorCode.CHECK_USER_INVALID);
    }
}
