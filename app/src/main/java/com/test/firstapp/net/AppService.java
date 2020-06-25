package com.test.firstapp.net;

import com.test.net.bean.Result;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Description:AppService
 **/
public interface AppService {
    @Headers({Constants.DOMAIN_ALI_HEADR})
    @POST("/api/login")
    Observable<Result<LoginSuccess>> login(@Body LoginModel loginModel);
}
