package com.sololibrary.library.http

import android.app.Application
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheEntity
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.model.HttpHeaders
import com.lzy.okgo.model.HttpParams
import java.util.logging.Level

/**
 * Created by chenshaolong on 2018/1/4.
 */
object OkGoHttp {

    fun initOkGo(app: Application) {
        OkGo.init(app)
        initConfiguration()
    }

    private fun initConfiguration(){
        OkGo.getInstance()
                .debug("OkGo", Level.INFO, true)
                .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS.toLong())  //全局的连接超时时间
                .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS.toLong())     //全局的读取超时时间
                .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS.toLong())    //全局的写入超时时间
                .setCacheMode(CacheMode.NO_CACHE)  //缓存模式
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)  //缓存时间
                .setRetryCount(3)   //超时重连次数
                .setCertificates()   //https 证书，详细见OkGo github
                .addCommonHeaders(getGlobalHttpHeaders())
                .addCommonParams(getGlobalHttpParams())
    }

    private fun getGlobalHttpHeaders(): HttpHeaders {
        val _headers = HttpHeaders()
        _headers.put("Content-Type", "application/json")
        return _headers
    }

    private fun getGlobalHttpParams(): HttpParams {
        val _params = HttpParams()
        _params.put("language", "cn")
        return _params
    }

}