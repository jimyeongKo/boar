package com.laon.sms.domain.user.exception;

import com.laon.sms.global.api.Error.ErrorCode;
import com.laon.sms.global.api.Error.InvalidValueException;

public class PasswordNotMatchedException extends InvalidValueException {
    public PasswordNotMatchedException(final String value) {
        super(value, ErrorCode.PASSWORD_INPUT_INVALID);
    }
}
