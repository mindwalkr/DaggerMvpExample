package com.example.common.lifecycle.view.loader;

import com.example.common.lifecycle.interfaces.presenter.IPresenter;

import dagger.Lazy;

/**
 *
 */

public interface PresenterProvider<PRESENTER extends IPresenter> {

        Lazy<PRESENTER> getPresenterProvider();

        int getLoaderId();

        PRESENTER getPresenter();
}
