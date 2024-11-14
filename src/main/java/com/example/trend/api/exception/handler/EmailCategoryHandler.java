package com.example.trend.api.exception.handler;

import com.example.trend.api.code.BaseErrorCode;
import com.example.trend.api.exception.GeneralException;

public class EmailCategoryHandler extends GeneralException {

    public EmailCategoryHandler(BaseErrorCode baseErrorCode) {

        super(baseErrorCode);
    }
}
