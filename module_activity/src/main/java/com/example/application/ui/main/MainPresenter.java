package com.example.application.ui.main;


import com.example.application.ui.main.contract.MainActivityContract;
import com.example.common.lifecycle.presenter.BasePresenter;

import javax.inject.Inject;

/**
 *
 */

public class MainPresenter extends BasePresenter<MainActivityContract.View> implements MainActivityContract.Presenter {

    private boolean state = false;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void subscribe(MainActivityContract.View view) {
        super.subscribe(view);

        getView().setCheckBoxState(state);
    }

    @Override
    public void unSubscribe() {

    }


    @Override
    public void onDestroyed() {

    }

    @Override
    public void buttonClicked() {
        state = !state;
        getView().setCheckBoxState(state);
    }
}
