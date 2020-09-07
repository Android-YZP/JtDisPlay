package com.jt.display.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

    protected int mSecretCode = 0;
    protected Context mContext;
    public Handler handler = new Handler();
    private int mAnimPager = 1;
    public int mDelayTime = 10000;
    public int mDelaAnimTime = 60000;
    public AnimatorSet mTranslationAnimatorSet;
    private List<View> mViewList = new ArrayList<>();
    private long mLoopTimes = 0;
    protected boolean mAnimDataLoading = false;

    private Runnable mLoopRunnable = new Runnable() {
        @Override
        public void run() {
            mLoopTimes++;
            if (mLoopTimes == 50000000000L) {
                mLoopTimes = 0;
            }
            loopTimesListener(mLoopTimes);
            handler.postDelayed(mLoopRunnable, mDelayTime);//10秒一次循环
        }
    };

    private Runnable mAnimRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mAnimDataLoading)
                nextPager(mAnimPager, mDelaAnimTime);
            handler.postDelayed(mAnimRunnable, mDelaAnimTime);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
     * 轮播动画回调
     */
    protected abstract void onPageSelected(int pager);

    /**
     * 轮播动画回调
     */
    protected abstract void loopTimesListener(long loopTimes);
    protected abstract void animStart(int mAnimPager);

    /**
     * 初始化监听
     */
    public abstract void initListener();

    public void addAnimView(View view) {
        mViewList.add(view);
    }

    public void startAnim() {
        if (mTranslationAnimatorSet == null) {
            nextPager(mAnimPager, mDelaAnimTime);
            handler.postDelayed(mAnimRunnable, mDelaAnimTime);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.postDelayed(mLoopRunnable, mDelayTime);//10秒一次循环
        if (mTranslationAnimatorSet != null) {
            mTranslationAnimatorSet.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mTranslationAnimatorSet != null) {
            mTranslationAnimatorSet.pause();
        }
        if (handler != null) {
            handler.removeCallbacks(mAnimRunnable);
            handler.removeCallbacks(mLoopRunnable);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler = null;
        mTranslationAnimatorSet = null;
        mAnimPager = 0;
        mLoopTimes = 0;
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


    private void nextPager(int p, int delayTime) {
        nextPager(mViewList.get(p), mViewList.get(p == 0 ? mViewList.size() - 1 : p - 1), delayTime);
    }

    private void nextPager(final View view1, final View view2, final int delayTime) {

        mTranslationAnimatorSet = new AnimatorSet();
        mTranslationAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(view1, "translationX", -view1.getWidth(), 0)
                        .setDuration(2000),
                ObjectAnimator.ofFloat(view2, "translationX", 0, view1.getWidth())
                        .setDuration(2000),

                ObjectAnimator.ofFloat(view1, "alpha", 0f, 1)
                        .setDuration(2000),
                ObjectAnimator.ofFloat(view2, "alpha", 1, 0f)
                        .setDuration(2000)
        );
        mTranslationAnimatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.VISIBLE);
                animStart(mAnimPager);
            }

            @Override
            public void onAnimationEnd(Animator animator) {

                view2.setVisibility(View.GONE);
                onPageSelected(mAnimPager);
                mAnimPager++;
                if (mAnimPager == mViewList.size()) mAnimPager = 0;
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                view1.clearAnimation();
                view2.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        mTranslationAnimatorSet.start();
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

    public void show(String msg) {
        Toast.makeText(mContext, msg + "", Toast.LENGTH_SHORT).show();
    }


}
