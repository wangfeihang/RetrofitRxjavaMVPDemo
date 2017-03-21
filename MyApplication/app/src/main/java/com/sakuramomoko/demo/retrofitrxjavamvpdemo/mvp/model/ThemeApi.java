package com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.model;

import com.sakuramomoko.demo.retrofitrxjavamvpdemo.entity.ThemeList;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by wangfeihang on 2017/3/21.
 */
public interface ThemeApi {

    /**
     * 主题列表
     */
    @GET("themes")
    Observable<ThemeList> getThemes();

    @GET("theme/{themeId}")
    Observable<List<ThemeList.Theme>> getStories(@Path("themeId") int themeId);
}
