package ru.gdgkazan.githubmvp.screen.walkthrough;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.gdgkazan.githubmvp.R;
import ru.gdgkazan.githubmvp.content.Benefit;
import ru.gdgkazan.githubmvp.screen.auth.AuthActivity;
import ru.gdgkazan.githubmvp.utils.PreferenceUtils;
import ru.gdgkazan.githubmvp.widget.PageChangeViewPager;

/**
 * @author Artur Vasilov
 */
public class Walkthrough extends MvpAppCompatActivity implements
        PageChangeViewPager.PagerStateListener, WalkthroughView, MainView {

    @InjectPresenter
    WalkthroughPresenter mWalkthroughPresenter;

    @InjectPresenter
    TestPresenter mTestPresenter;

   // private static final int PAGES_COUNT = 3;

    @BindView(R.id.pager)
    PageChangeViewPager mPager;

    @BindView(R.id.btn_walkthrough)
    Button mActionButton;

    //private int mCurrentItem = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        ButterKnife.bind(this);

        mPager.setAdapter(new WalkthroughAdapter(getFragmentManager(), getBenefits()));
        mPager.setOnPageChangedListener(this);

        mActionButton.setText(R.string.next_uppercase);

        if (PreferenceUtils.isWalkthroughPassed()) {
            startAuthActivity();
        }

        /**
         * TODO : task
         *
         * Refactor this screen using MVP pattern
         *
         * Hint: there are no requests on this screen, so it's good place to start
         *
         * You can simply go through each line of code and decide if it should be in View or in Presenter
         */
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_walkthrough)
    public void onActionButtonClick() {

        Toast.makeText(this, "Ready to you go!", Toast.LENGTH_SHORT).show();

       //mWalkthroughPresenter.goToNextBenefit();

        /* if (isLastBenefit()) {
            PreferenceUtils.saveWalkthroughPassed();
            startAuthActivity();
        } else {
            mCurrentItem++;
            showBenefit(mCurrentItem, isLastBenefit());
        }*/
    }

    @Override
    public void onPageChanged(int selectedPage, boolean fromUser) {
        Toast.makeText(this, "Ready to you go!", Toast.LENGTH_SHORT).show();
        //mWalkthroughPresenter.PageChanged(selectedPage, fromUser);
        /*   if (fromUser) {
            mCurrentItem = selectedPage;
            showBenefit(mCurrentItem, isLastBenefit());
        }*/
    }

  /*  private boolean isLastBenefit() {
        return mCurrentItem == PAGES_COUNT - 1;
    }*/

  //@Override
    public void showBenefit(int index, boolean isLastBenefit) {
        mActionButton.setText(isLastBenefit ? R.string.finish_uppercase : R.string.next_uppercase);
        if (index == mPager.getCurrentItem()) {
            return;
        }
        mPager.smoothScrollNext(getResources().getInteger(android.R.integer.config_mediumAnimTime));
    }

   // @Override
    public void startAuthActivity() {
        AuthActivity.start(this);
        finish();
    }

   @NonNull
    private List<Benefit> getBenefits() {
        return new ArrayList<Benefit>() {
            {
                add(Benefit.WORK_TOGETHER);
                add(Benefit.CODE_HISTORY);
                add(Benefit.PUBLISH_SOURCE);
            }
        };
    }


    @Override
    public void itsAlive() {

    }
}
