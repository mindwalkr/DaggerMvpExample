package com.example.application.ui.main.contract;

import com.example.common.lifecycle.interfaces.presenter.IPresenter;
import com.example.common.lifecycle.interfaces.view.BaseView;

/**
 *
 */

public interface MainActivityContract {

    interface View extends BaseView<Presenter> {
        void setCheckBoxState(boolean state);
    }

    interface Presenter extends IPresenter<View> {
        void buttonClicked();

    }

}
