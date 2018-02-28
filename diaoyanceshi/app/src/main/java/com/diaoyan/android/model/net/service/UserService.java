package com.diaoyan.android.model.net.service;

import com.diaoyan.android.model.bean.UserBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by chenshaolong on 2018/2/28.
 */

public interface UserService {

    @POST("api/user/login")
    Observable<Response<UserBean>> login(@QueryMap Map<String, String> common);

}
