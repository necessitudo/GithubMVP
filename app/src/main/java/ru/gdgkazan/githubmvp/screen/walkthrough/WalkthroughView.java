package ru.gdgkazan.githubmvp.screen.walkthrough;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface WalkthroughView extends MvpView {

 /*   void onActionButtonClick();

    void startAuthActivity();

    void showBenefit(int index, boolean isLastBenefit);*/
}
