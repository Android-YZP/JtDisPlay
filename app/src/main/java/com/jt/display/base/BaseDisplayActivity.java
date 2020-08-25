package com.jt.display.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseDisplayActivity extends AppCompatActivity implements IBaseView {


    protected Context mContext;


    Handler handler = new Handler();
    private int widthPixels;
    int pager = 1;
    public AnimatorSet translationAnimatorSet;
    private List<View> viewList = new ArrayList<>();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            nextPager(pager, 10000);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        widthPixels = displayMetrics.widthPixels;

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(this.getLayoutId());
        mContext = BaseDisplayActivity.this;
        initView();
        initData();
        initListener();
    }

    /**
     * 设置布局
     */
    public abstract int getLayoutId();

    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化监听
     */
    public abstract void initListener();

    public void addView(View view) {
        viewList.add(view);
    }

    public void startAnim() {
        nextPager(pager, 10000);
    }


    @Override
    protected void onDestroy() {
        if (translationAnimatorSet != null) {
            translationAnimatorSet.cancel();
            translationAnimatorSet = null;
            handler.removeCallbacks(runnable);
            pager = 0;
        }
        super.onDestroy();
    }

    /**
     * 绑定生命周期 防止MVP内存泄漏
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }


    private void nextPager(final View view1, final View view2, final int delayTime) {

        translationAnimatorSet = new AnimatorSet();
        translationAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(view1, "translationX", -view1.getWidth(), 0)
                        .setDuration(2000),
                ObjectAnimator.ofFloat(view2, "translationX", 0, view1.getWidth())
                        .setDuration(2000),

                ObjectAnimator.ofFloat(view1, "alpha", 0f, 1)
                        .setDuration(2000),
                ObjectAnimator.ofFloat(view2, "alpha", 1, 0f)
                        .setDuration(2000)
        );
        translationAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                handler.postDelayed(runnable, delayTime);
                view2.setVisibility(View.GONE);
                onPageSelected(pager);
                pager++;
                if (pager == viewList.size()) pager = 0;
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        translationAnimatorSet.start();
    }


    public void zoomAnim(final View view) {

        AnimatorSet translationAnimatorSet = new AnimatorSet();
        translationAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "ScaleX", 1.0f, 1.1f, 1.05f)
                        .setDuration(400),
                ObjectAnimator.ofFloat(view, "ScaleY", 1.0f, 1.1f, 1.05f)
                        .setDuration(400)
        );
        translationAnimatorSet.start();
    }

    public void unZoomAnim(final View view) {

        AnimatorSet translationAnimatorSet = new AnimatorSet();
        translationAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "ScaleX", 1.05f, 1f)
                        .setDuration(300),
                ObjectAnimator.ofFloat(view, "ScaleY", 1.05f, 1f)
                        .setDuration(300)
        );
        translationAnimatorSet.start();
    }


    protected abstract void onPageSelected(int pager);


    private void nextPager(int postion, int delayTime) {
        nextPager(viewList.get(postion), viewList.get(postion == 0 ? viewList.size() - 1 : postion - 1), delayTime);
    }

    public void show(String msg) {
        Toast.makeText(mContext, msg + "", Toast.LENGTH_SHORT).show();
    }


}
