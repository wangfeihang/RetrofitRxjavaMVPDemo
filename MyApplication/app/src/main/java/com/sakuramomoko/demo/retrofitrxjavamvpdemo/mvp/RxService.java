package com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp;


import com.sakuramomoko.demo.retrofitrxjavamvpdemo.AppConstants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hpw on 16/11/2.
 */

public class RxService {


    public static <T> T createApi(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.APP_SERVER.asString())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }
}

