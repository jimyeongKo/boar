package com.laon.sms.domain.user.exception;

import com.laon.sms.global.api.Error.BusinessException;
import com.laon.sms.global.api.Error.ErrorCode;

public class NickDuplicateException extends BusinessException {
    public NickDuplicateException(String value) {
        super(value, ErrorCode.NICK_NAME_DUPLICATION);
    }
}
