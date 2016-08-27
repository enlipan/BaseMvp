package com.example.lee.basemvp.basemvp;

import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by lee on 16/8/25.
 */

public abstract class MvpBasePresenter<V extends MvpView,K extends MvpRepository> implements MvpPresenter<V,K> {

    private final CopyOnWriteArrayList<OnDestroyListener> onDestroyListeners = new CopyOnWriteArrayList<>();

    private WeakReference<V> mViewRefernce;
    protected K  mRepository;

    @Override
    public void attachView(V view) {
        mViewRefernce = new WeakReference<>(view);
        mRepository = createRepository();
    }

    @Override
    public void detachView() {
        for (OnDestroyListener onDestroyListener : onDestroyListeners) {
            onDestroyListener.onDestroy();
        }
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

    /**
     * release something about Presenter
     * @param listener
     */
    public void addDestroyListener(OnDestroyListener listener){
        onDestroyListeners.add(listener);
    }




}
