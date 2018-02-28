package com.diaoyan.android.model.net.rest;

import android.util.ArrayMap;

import com.diaoyan.android.model.bean.BaseBean;
import com.diaoyan.android.model.bean.UserBean;
import com.diaoyan.android.model.net.CommonParams;
import com.diaoyan.android.model.net.Hosts;
import com.diaoyan.android.model.net.service.UserService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenshaolong on 2018/2/28.
 */

public class LoginRest extends AbstractRest {

    public static LoginRest singleton;
    private UserService mUserService;

    public static LoginRest getInstance() {
        if (singleton == null) {
            synchronized (LoginRest.class) {
                if (singleton == null) {
                    singleton = new LoginRest();
                }
            }
        }
        return singleton;
    }

    public LoginRest() {
        init(Hosts.MAIN_HOST);
    }

    @Override
    protected void setService() {
        mUserService = mRetrofit.create(UserService.class);
    }

    public void loginByMobile(String phone, String verifycode, Observer observer) {
        ArrayMap<String, String> param = new ArrayMap();
        param.put("phone", phone);
        param.put("code", verifycode);
        mUserService.login(CommonParams.getParams(param))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(parseFun)
                .map(new Function<BaseBean, UserBean>() {

                    @Override
                    public UserBean apply(BaseBean baseBean) throws Exception {
                        return (UserBean) baseBean;
                    }
                }).subscribe(observer);


    }


}
