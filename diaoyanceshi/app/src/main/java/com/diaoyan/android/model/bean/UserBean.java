package com.diaoyan.android.model.bean;

/**
 * Created by chenshaolong on 2018/2/28.
 */

public class UserBean extends BaseBean {

    private String nickname;
    private String age;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
