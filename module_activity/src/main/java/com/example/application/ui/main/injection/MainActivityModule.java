package com.example.application.ui.main.injection;



import com.example.application.ui.main.MainActivity;
import com.example.application.ui.main.MainPresenter;
import com.example.application.ui.main.contract.MainActivityContract;

import dagger.Module;
import dagger.Provides;

/**
 *
 */

@Module
public class MainActivityModule {

    @Provides
    public MainActivityContract.View provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    public MainActivityContract.Presenter provideMainPresenter() {
        return new MainPresenter();
    }
}