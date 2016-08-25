package com.example.lee.basemvp.saleroder;

import com.example.lee.basemvp.basemvp.MvpPresenter;
import com.example.lee.basemvp.basemvp.MvpRepository;
import com.example.lee.basemvp.basemvp.MvpView;

/**
 * Created by lee on 16/8/25.
 */

public class SalerOderContract {

    public interface View extends MvpView<Presenter> {

    }


    public interface Presenter extends MvpPresenter<View,Repository> {


    }


    public interface Repository extends MvpRepository {

    }
}
