package com.example.application.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.application.ui.main.contract.MainActivityContract;
import com.example.common.lifecycle.view.BaseActivity;

import javax.inject.Inject;

import dagger.Lazy;

/**
 *
 */

public class MainActivity extends BaseActivity<MainActivityContract.Presenter> implements MainActivityContract.View {

    @Inject
    Lazy<MainActivityContract.Presenter> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().buttonClicked();
            }
        });
    }


    @Override
    public Lazy<MainActivityContract.Presenter> getPresenterProvider() {
        return presenter;
    }

    @Override
    public int getLoaderId() {
        return R.layout.activity_main;
    }


    @Override
    public void setCheckBoxState(boolean state) {
        CheckBox cb = (CheckBox) findViewById(R.id.checkbox);
        cb.setChecked(state);
    }
}
