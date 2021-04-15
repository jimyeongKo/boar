package com.laon.sms.domain.user.exception;

import com.laon.sms.global.api.Error.ErrorCode;
import com.laon.sms.global.api.Error.InvalidValueException;

public class EmailNotMatchedException extends InvalidValueException {
    public EmailNotMatchedException(String value) {
        super(value, ErrorCode.EMAIL_INPUT_INVALID);
    }

}
