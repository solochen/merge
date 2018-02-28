package com.diaoyan.android.model.net;

import android.util.ArrayMap;

/**
 * Created by chenshaolong on 2018/2/28.
 */

public class CommonParams {

    /**
     * 公共头部
     * @return
     */
    public static ArrayMap<String, String> getHeaders(){
        ArrayMap<String, String> headers = new ArrayMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("client_type", "android");
        return headers;
    }


    /**
     * 公共参数
     * @return
     */
    public static ArrayMap<String, String> getCommonParams(){
        ArrayMap<String, String> params = new ArrayMap<>();
        params.put("sid", "ale12ccv893ddfe1");
        return params;
    }

    /**
     * 获取所有参数
     * @param params
     * @return
     */
    public static ArrayMap<String, String> getParams(ArrayMap<String, String> params) {
        ArrayMap<String, String> map = getCommonParams();
        if (params != null) {
            map.putAll(params);
        }
        for (String key : map.keySet()) {
            Object value = map.get(key);
            if (value == null) {
                map.put(key, "");
            }
        }

        return map;
    }

}
