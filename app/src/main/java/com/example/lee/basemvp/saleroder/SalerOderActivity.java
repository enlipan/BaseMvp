package com.example.lee.basemvp.saleroder;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lee on 16/8/25.
 */

public class SalerOderActivity extends Activity implements SalerOderContract.View{

    private SalerOderContract.Presenter  mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(this);
    }


    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public SalerOderContract.Presenter createPresenter() {
        return SalerOrderPresenter.newInstance();
    }
}
