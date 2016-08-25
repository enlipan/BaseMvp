package com.example.lee.basemvp.basemvp;

import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by lee on 16/8/25.
 */

public abstract class MvpBasePresenter<V extends MvpView,K extends MvpRepository> implements MvpPresenter<V,K> {

    private WeakReference<V> mViewRefernce;
    protected K  mRepository;

    @Override
    public void attachView(V view) {
        mViewRefernce = new WeakReference<>(view);
        mRepository = createRepository();
    }

    protected abstract  K createRepository();

    @Override
    public void detachView() {
        releaseViewInstance();
        releaseRepository();
    }

    private void releaseViewInstance(){
        if (mViewRefernce != null) {
            mViewRefernce.clear();
            mViewRefernce = null;
        }
    }

    private void releaseRepository(){
        if (mRepository != null) {
            mRepository.cancelWork();
            mRepository = null;
        }
    }


    public boolean  isViewAttached(){
        return mViewRefernce != null && mViewRefernce.get() != null;
    }

    @Nullable
    public V  getMvpView(){
        return mViewRefernce == null ? null : mViewRefernce.get();
    }



}
