package com.example.trend.api.exception.handler;


import com.example.trend.api.code.BaseErrorCode;
import com.example.trend.api.exception.GeneralException;

public class MemberCategoryHandler extends GeneralException {

    public MemberCategoryHandler(BaseErrorCode baseErrorCode) {

        super(baseErrorCode);
    }
}
