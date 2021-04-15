package com.laon.sms.domain.user.exception;

import com.laon.sms.global.api.Error.ErrorCode;
import com.laon.sms.global.api.Error.InvalidValueException;

public class NotMatchEmailException extends InvalidValueException {

    public NotMatchEmailException(String value) {
        super(value, ErrorCode.NOT_MATCH_EMAIL);
    }
}
