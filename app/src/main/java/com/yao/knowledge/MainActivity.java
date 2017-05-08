package com.yao.knowledge;

import android.os.Bundle;
import android.widget.TextView;

import com.yao.knowledge.base.BaseActivity;
import com.yao.knowledge.base.entity.MessageEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initLogic() {
        tv.setText("nihao");
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {

    }

}
