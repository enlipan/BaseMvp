package com.example.lee.basemvp.basemvp;

/**
 * Created by lee on 16/8/25.
 */

public interface MvpPresenter<V extends MvpView,K extends MvpRepository> extends RepositoryFactory<K>  {


    void attachView(V view);


    void detachView();


    interface OnDestroyListener {

        void onDestroy();

    }

}
