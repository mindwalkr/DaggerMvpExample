package com.example.common.lifecycle.view.loader;

import android.content.Context;
import android.support.v4.content.Loader;

import com.example.common.lifecycle.interfaces.presenter.IPresenter;

/**
 *
 */

public class PresenterLoader <PRESENTER extends IPresenter> extends Loader<PRESENTER> {

    private final PRESENTER presenter;

    public PresenterLoader(Context context, PRESENTER presenter) {
        super(context);
        this.presenter = presenter;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        super.onReset();
        presenter.unSubscribe();
    }

    public PRESENTER getPresenter() {
        return presenter;
    }
}
