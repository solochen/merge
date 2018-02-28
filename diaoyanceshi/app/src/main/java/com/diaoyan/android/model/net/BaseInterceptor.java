package com.diaoyan.android.model.net;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chenshaolong on 2018/2/28.
 */

public class BaseInterceptor implements Interceptor {
    private static final String TAG = BaseInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Map<String, String> headers = CommonParams.getHeaders();
        builder.addHeader("Connection","keep-alive");
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String headerKey : keys) {
                builder.addHeader(headerKey, headers.get(headerKey));
            }
        }
        return chain.proceed(builder.build());
    }
}
