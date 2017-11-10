package ru.gdgkazan.githubmvp.screen.walkthrough;

import com.arellomobile.mvp.MvpView;



public interface WalkthroughView extends MvpView {

    void onActionButtonClick();

    void startAuthActivity();

    void showBenefit(int index, boolean isLastBenefit);
}
