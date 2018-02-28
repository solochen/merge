package com.diaoyan.android.model.net.rest;

import com.diaoyan.android.model.bean.BaseBean;
import com.diaoyan.android.model.net.interceptor.BaseInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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

    protected Func1<Response<? extends BaseBean>, BaseBean> parseFun = new Func1<Response<? extends BaseBean>, BaseBean>() {
        @Override
        public BaseBean call(Response<? extends BaseBean> initEntityResponse) {
            try {
                return parseEntity(initEntityResponse);
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


    protected Observable.Transformer schedulersTransformer() {
        return new Observable.Transformer() {
            @Override
            public Object call(Object observable) {
                return ((Observable) observable).subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }



}
