package com.diaoyan.android.model.net.rest;

import com.diaoyan.android.model.bean.BaseBean;
import com.diaoyan.android.model.net.interceptor.BaseInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chenshaolong on 2018/2/28.
 */

public abstract class AbstractRest {

    protected Retrofit mRetrofit;

    protected void init(String host){
        initRetrofit(host);
        setService();
    }

    protected abstract void setService();

    protected void initRetrofit(String host){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        mRetrofit = new Retrofit.Builder()
                .client(getHttpClientBuilder().build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(host)
                .build();
    }

    protected OkHttpClient.Builder getHttpClientBuilder(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        builder.addInterceptor(new BaseInterceptor());
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        builder.retryOnConnectionFailure(true);
        return builder;
    }

    protected Function<Response<? extends BaseBean>, BaseBean> parseFun = new Function<Response<? extends BaseBean>, BaseBean>() {
        @Override
        public BaseBean apply(Response<? extends BaseBean> response) throws Exception {
            try {
                return parseEntity(response);
            } catch (Throwable throwable) {
                throw Exceptions.propagate(throwable);
            }
        }
    };


    protected BaseBean parseEntity(Response<? extends BaseBean> initEntityResponse) throws Throwable {
        if (initEntityResponse.body() == null && initEntityResponse.errorBody() != null) {
            throw new Throwable(initEntityResponse.message());
        }
        return initEntityResponse.body();
    }


}
