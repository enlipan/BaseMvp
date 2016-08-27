package com.example.lee.basemvp.basemvp;

/**
 * Created by lee on 16/8/27.
 */

public interface RepositoryFactory<V extends MvpRepository> {

    V createRepository();

}
