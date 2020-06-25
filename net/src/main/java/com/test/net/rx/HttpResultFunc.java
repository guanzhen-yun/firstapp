package com.test.net.rx;

import com.test.net.exception.ExceptionEngine;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 */
public class HttpResultFunc<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(Throwable throwable) {
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
