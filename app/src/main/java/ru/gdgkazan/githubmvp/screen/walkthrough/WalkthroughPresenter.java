package ru.gdgkazan.githubmvp.screen.walkthrough;


import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import ru.gdgkazan.githubmvp.content.Benefit;
import ru.gdgkazan.githubmvp.utils.PreferenceUtils;

@InjectViewState
public class WalkthroughPresenter extends BasePresenter<WalkthroughView>  {

    private static final int PAGES_COUNT = 3;

    private int mCurrentItem = 0;

    public  void goToNextBenefit(){
        if (isLastBenefit()) {
            PreferenceUtils.saveWalkthroughPassed();
            getViewState().startAuthActivity();
        } else {
            mCurrentItem++;
            getViewState().showBenefit(mCurrentItem, isLastBenefit());
        }
    }

    private boolean isLastBenefit() {
        return mCurrentItem == PAGES_COUNT - 1;
    }

    @NonNull
    public List<Benefit> getBenefits() {
        return new ArrayList<Benefit>() {
            {
                add(Benefit.WORK_TOGETHER);
                add(Benefit.CODE_HISTORY);
                add(Benefit.PUBLISH_SOURCE);
            }
        };
    }

    public  void PageChanged(int selectedPage, boolean fromUser){

    }

}


