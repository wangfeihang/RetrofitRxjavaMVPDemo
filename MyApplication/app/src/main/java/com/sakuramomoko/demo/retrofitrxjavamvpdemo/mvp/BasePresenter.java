package com.sakuramomoko.demo.retrofitrxjavamvpdemo.mvp;


import android.content.Context;
import android.util.Log;

import com.sakuramomoko.demo.retrofitrxjavamvpdemo.MyApplication;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ZZB on 2016/10/13.
 */

public class BasePresenter<V extends MvpView> implements Presenter<V> {

    private static final String TAG = "BasePresenter";

    protected Context mContext = MyApplication.APP_CONTEXT;
    private V mMvpView;
    private boolean mIsAttachViewMethodCalled = false;
    private CompositeSubscription mCompositeSubscription;

    public BasePresenter() {
    }

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        Log.i(TAG, "addSubscribe");
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void attachView(V mvpView) {
        mIsAttachViewMethodCalled = true;
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
        unSubscribe();
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            Log.i(TAG, "unSubscribe");
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public boolean isViewAttached() {
        return mMvpView != null;
    }

    @Override
    public V getMvpView() {
        if (!mIsAttachViewMethodCalled) {
            throw new RuntimeException("please call attachView first");
        }
        return mMvpView;
    }

    protected String getString(int strResId) {
        return mContext.getString(strResId);
    }
}
