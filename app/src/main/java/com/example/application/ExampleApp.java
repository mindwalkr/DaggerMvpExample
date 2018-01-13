package com.example.application;

import com.example.application.injection.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 *
 */

public class ExampleApp extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends ExampleApp> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }

}
