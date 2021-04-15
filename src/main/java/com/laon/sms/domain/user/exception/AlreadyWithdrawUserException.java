package com.laon.sms.domain.user.exception;

import com.laon.sms.global.api.Error.ErrorCode;
import com.laon.sms.global.api.Error.InvalidValueException;

public class AlreadyWithdrawUserException extends InvalidValueException {
    public AlreadyWithdrawUserException(String value) {
        super(value, ErrorCode.ALREADY_WITHDRAW_USER);
    }
}
