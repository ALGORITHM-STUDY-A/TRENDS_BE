package com.example.trend.api.exception.handler;

import com.example.trend.api.code.BaseErrorCode;
import com.example.trend.api.exception.GeneralException;

public class TokenCategoryHandler extends GeneralException {

    public TokenCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
