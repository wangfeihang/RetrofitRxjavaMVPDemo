package com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.model;

import com.sakuramomoko.demo.retrofitrxjavamvpdemo.entity.ThemeList;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.RxService;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by wangfeihang on 2017/3/20.
 */
public class ThemeModel {

    public ThemeModel() {
    }

    public Observable<ThemeList> getThemes() {
        return RxService.create(ThemeApi.class).getThemes();
    }

    public Observable<List<ThemeList.Theme>> getStories(@Path("themeId") int themeId) {
        return RxService.create(ThemeApi.class).getStories(themeId);
    }

    public interface ThemeApi {

        @GET("themes")
        Observable<ThemeList> getThemes();

        @GET("theme/{themeId}")
        Observable<List<ThemeList.Theme>> getStories(@Path("themeId") int themeId);
    }


}
