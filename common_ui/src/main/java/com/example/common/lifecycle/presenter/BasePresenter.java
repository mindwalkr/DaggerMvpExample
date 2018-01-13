package com.example.common.lifecycle.presenter;

import com.example.common.lifecycle.interfaces.presenter.IPresenter;

/**
 *
 */

public abstract class BasePresenter<VIEW> implements IPresenter<VIEW> {
    private VIEW view;

    protected VIEW getView() {
        return view;
    }

    @Override
    public void subscribe(VIEW view) {
        this.view = view;
    }
}
