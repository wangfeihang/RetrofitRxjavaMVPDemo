package com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.presenter;

import com.sakuramomoko.demo.retrofitrxjavamvpdemo.entity.ThemeList;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.BasePresenter;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.model.ThemeModel;
import com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp.view.ThemesMvpView;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ThemeListPresenter extends BasePresenter<ThemesMvpView> {

    private ThemeModel themeModel;

    public ThemeListPresenter() {
        themeModel = new ThemeModel();
    }

    public void getThemes() {
        Subscription subscription = themeModel.getThemes()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ThemeList>() {
                    @Override
                    public void call(ThemeList themes) {
                        if (themes != null) {
                            getMvpView().loadThemes(themes.getOthers());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getMvpView().showGetThemesFailedMsg(throwable.getMessage());
                    }
                });
        addSubscribe(subscription);
    }
}
