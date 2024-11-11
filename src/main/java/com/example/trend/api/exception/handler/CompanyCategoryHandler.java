package com.example.trend.api.exception.handler;

import com.example.trend.api.code.BaseErrorCode;
import com.example.trend.api.exception.GeneralException;

public class CompanyCategoryHandler extends GeneralException {


    public CompanyCategoryHandler(BaseErrorCode baseErrorCode) {

        super(baseErrorCode);
    }
}
