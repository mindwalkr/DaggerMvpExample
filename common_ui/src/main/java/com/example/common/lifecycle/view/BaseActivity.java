package com.example.common.lifecycle.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.example.common.lifecycle.interfaces.presenter.IPresenter;
import com.example.common.lifecycle.view.loader.PresenterProvider;

import dagger.android.AndroidInjection;

/**
 *  https://github.com/czyrux/MvpLoaderSample
 *
 *  https://github.com/fossasia/open-event-orga-app
 */

public abstract class BaseActivity<PRESENTER extends IPresenter> extends AppCompatActivity implements PresenterProvider<PRESENTER> {

    private final LoaderHandler<PRESENTER> loaderHandler = new LoaderHandler<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        loaderHandler.load(this, getSupportLoaderManager(), getLoaderId(), getPresenterProvider());
    }

    @Override
    @CallSuper
    protected void onStop() {
        super.onStop();
        loaderHandler.presenter.unSubscribe();
    }

    @Override
    public PRESENTER getPresenter() {
        return loaderHandler.getPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().subscribe(this);
    }

    @Override
    public void onPause() {
        getPresenter().unSubscribe();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        getPresenter().onDestroyed();
        super.onDestroy();
    }


}
