package com.example.application.injection;

import com.example.application.ui.main.MainActivity;
import com.example.application.ui.main.injection.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 *
 * Add all the activity modules here.
 *
 * Create similar builders for Fragments/etc, or group them by function
 *
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}
