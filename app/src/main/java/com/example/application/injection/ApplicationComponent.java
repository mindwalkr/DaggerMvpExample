package com.example.application.injection;

import com.example.application.ExampleApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 *
 */

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                ActivityBuilder.class
        })

public interface ApplicationComponent extends AndroidInjector<ExampleApp> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<ExampleApp> {
    }
}