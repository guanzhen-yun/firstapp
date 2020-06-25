package com.test.net.rx;


import android.text.TextUtils;


import com.test.net.bean.Result;
import com.test.net.exception.ServerException;

import io.reactivex.functions.Function;


/**
 */

class ServerResultFunc<T> implements Function<Result<T>, T> {
    @Override
    public T apply(Result<T> httpResult) throws Exception {

        if (!TextUtils.isEmpty(httpResult.getErrcode())) {
            if ("0".equals(httpResult.getErrcode()) || "0.0".equals(httpResult.getErrcode()) || "1000".equals(httpResult.getErrcode())) {
                return httpResult.getData();
            } else {
                throw new ServerException(Integer.parseInt(httpResult.getErrcode()),
                        Integer.parseInt(httpResult.getErrcode()), httpResult.getErrmsg());
            }
        } else {
            if (httpResult.getError() == 0 && (httpResult.getCode() == 1000 || httpResult.getCode() == 0|| httpResult.getCode() == 200)) {
                return httpResult.getData();
            }
        }
        throw new ServerException(httpResult.getCode(), httpResult.getError(), httpResult.getMessage());
    }
}
