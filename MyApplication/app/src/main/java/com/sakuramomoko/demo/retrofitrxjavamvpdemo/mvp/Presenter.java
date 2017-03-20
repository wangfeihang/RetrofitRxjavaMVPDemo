package com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp;

/**
 * Created by ZZB on 2016/10/13.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();

    boolean isViewAttached();

    V getMvpView();
}
