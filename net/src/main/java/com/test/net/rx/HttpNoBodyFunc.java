package com.test.net.rx;


import com.test.net.bean.Result;
import com.test.net.exception.ExceptionEngine;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * 没有返回body
 */
public class HttpNoBodyFunc implements Function<Throwable, Observable<Result>> {
    HttpNoBodyFunc() {
    }

    public Observable<Result> apply(Throwable throwable) {
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
