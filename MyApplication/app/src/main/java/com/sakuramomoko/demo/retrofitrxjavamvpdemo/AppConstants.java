package com.sakuramomoko.demo.retrofitrxjavamvpdemo;

/**
 * Created by yangtian on 15/10/14.
 */
public enum AppConstants {

    APP_SERVER("http://news-at.zhihu.com/api/4/");

    private final Object value;

    AppConstants(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return asString();
    }

    public String asString() {
        final Object obj = value;
        if (obj instanceof String) {
            return (String) obj;
        }
        return "";
    }

}
