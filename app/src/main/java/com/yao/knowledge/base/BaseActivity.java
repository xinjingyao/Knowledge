package com.yao.knowledge.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yao.knowledge.R;
import com.yao.knowledge.base.entity.MessageEvent;
import com.yao.knowledge.base.util.ActivityStackManager;
import com.yao.knowledge.base.view.statusbar.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;

/**
 * Created by yao on 2017/5/6.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStackManager.getInstance().addActivity(new WeakReference<Activity>(this));
        // 设置透明状态栏
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary),0);
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            getBundleExtras(bundle);
        }
        EventBus.getDefault().register(this);
        setContentView(initContentView());
        ButterKnife.bind(this);
        initLogic();
    }

    /**从intent中得到bundle*/
    protected abstract void getBundleExtras(Bundle bundle);

    /**设置布局文件*/
    protected abstract int initContentView();

    /**初始化控件后，初始化业务逻辑*/
    protected abstract void initLogic();

    /**
     * EventBus接收消息
     * @param event 接收到的消息
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public abstract void onMessageEvent(MessageEvent event);

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        ActivityStackManager.getInstance().removeActivity(new WeakReference<Activity>(this));
        super.onDestroy();

    }
}
