package com.diaoyan.android.model.net.reset;

import android.util.ArrayMap;

import com.diaoyan.android.model.bean.BaseBean;
import com.diaoyan.android.model.bean.UserBean;
import com.diaoyan.android.model.net.AbstractRest;
import com.diaoyan.android.model.net.CommonParams;
import com.diaoyan.android.model.net.Hosts;
import com.diaoyan.android.model.net.service.UserService;

import rx.Subscriber;
import rx.functions.Func1;

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

    public void loginByMobile(String phone, String verifycode, Subscriber subscriber) {
        ArrayMap<String, String> param = new ArrayMap();
        param.put("phone", phone);
        param.put("code", verifycode);
        mUserService.login(CommonParams.getParams(param))
                .compose(schedulersTransformer())
                .map(parseFun)
                .map(new Func1<BaseBean, UserBean>() {
                    @Override
                    public UserBean call(BaseBean entityBase) {
                        return (UserBean) entityBase;
                    }
                }).subscribe(subscriber);
    }


}
