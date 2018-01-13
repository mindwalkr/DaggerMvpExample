package com.example.common.lifecycle.interfaces.presenter;

/**
 *
 */

public interface IPresenter<VIEW> {

    void subscribe(VIEW v);
    void unSubscribe();

    void onDestroyed();
}
