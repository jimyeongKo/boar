package com.laon.sms.domain.user.exception;

import com.laon.sms.global.api.Error.ErrorCode;
import com.laon.sms.global.api.Error.InvalidValueException;

public class EmailDuplicateException extends InvalidValueException {
    public EmailDuplicateException(final String email) {
        super(email, ErrorCode.EMAIL_DUPLICATION);
    }
}
