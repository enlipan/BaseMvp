package com.example.lee.basemvp.saleroder;


import com.example.lee.basemvp.basemvp.MvpBasePresenter;

/**
 * Created by lee on 16/8/25.
 */

public class SalerOrderPresenter extends MvpBasePresenter<SalerOderContract.View,SalerOderContract.Repository> implements SalerOderContract.Presenter {


    public static SalerOrderPresenter newInstance() {
        return new SalerOrderPresenter();
    }


    @Override
    public SalerOderContract.Repository createRepository() {
        return null;
    }
}
