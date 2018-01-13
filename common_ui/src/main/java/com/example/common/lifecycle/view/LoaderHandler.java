package com.example.common.lifecycle.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.example.common.lifecycle.interfaces.presenter.IPresenter;
import com.example.common.lifecycle.view.loader.PresenterLoader;

import dagger.Lazy;

/**
 *
 */

class LoaderHandler<PRESENTER extends IPresenter> {
    protected PRESENTER presenter;

    void load(Context context, LoaderManager loaderManager, int loaderId, Lazy<PRESENTER> presenterProvider) {

        Loader<PRESENTER> loader = loaderManager.getLoader(loaderId);

        // if no cached PRESENTER is found, we go get the one from the View's injected version
        if (loader == null) {
            initLoader(context, loaderManager, loaderId, presenterProvider);
        } else {
            presenter = ((PresenterLoader<PRESENTER>) loader).getPresenter();
        }
    }

    private void initLoader(final Context context, LoaderManager loaderManager, final int loaderId, final Lazy<PRESENTER> presenterProvider) {
        loaderManager.initLoader(loaderId, null, new LoaderManager.LoaderCallbacks<PRESENTER>() {
            @Override
            public Loader<PRESENTER> onCreateLoader(int id, Bundle args) {
                // Get the PRESENTER from
                return new PresenterLoader<>(context, presenterProvider.get());
            }

            @Override
            public void onLoadFinished(Loader<PRESENTER> loader, PRESENTER presenter) {
                LoaderHandler.this.presenter = presenter;
            }

            @Override
            public void onLoaderReset(Loader<PRESENTER> loader) {
                // Do Nothing
            }
        });
    }

    protected PRESENTER getPresenter() {
        return presenter;
    }
}
