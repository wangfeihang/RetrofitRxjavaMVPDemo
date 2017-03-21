package com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.model;

import com.sakuramomoko.demo.retrofitrxjavamvpdemo.entity.ThemeList;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.RxService;

import java.util.List;

import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by wangfeihang on 2017/3/20.
 */
public class ThemeModel implements ThemeApi {

    private ThemeApi themeApi;

    public ThemeModel() {
        themeApi = RxService.createApi(ThemeApi.class);
    }

    @Override
    public Observable<ThemeList> getThemes() {
        return themeApi.getThemes();
    }

    @Override
    public Observable<List<ThemeList.Theme>> getStories(@Path("themeId") int themeId) {
        return themeApi.getStories(themeId);
    }


}
