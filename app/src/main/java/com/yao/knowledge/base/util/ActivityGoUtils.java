package com.yao.knowledge.base.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

/**
 * Description: 跳转工具类
 * Date: 2017/4/22
 */

public class ActivityGoUtils {

    private static ActivityGoUtils activityUtils = new ActivityGoUtils();

    private ActivityGoUtils() {
    }

    /***
     * 获得AppManager的实例
     *
     * @return AppManager实例
     */
    public static ActivityGoUtils getInstance() {
        if (activityUtils == null) activityUtils = new ActivityGoUtils();
        return activityUtils;
    }

    /**
     * 界面跳转
     *
     * @param clazz 目标Activity
     */
    public void readyGo(Class<?> clazz) {
        readyGo(clazz, null);
    }

    /**
     * 跳转界面，  传参
     *
     * @param clazz  目标Activity
     * @param bundle 数据
     */
    public void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(ActivityStackManager.getInstance().getTopActivity(), clazz);
        if (null != bundle)
            intent.putExtras(bundle);
        ActivityStackManager.getInstance().getTopActivity().startActivity(intent);
    }

    /**
     * 跳转界面并关闭当前界面
     *
     * @param clazz 目标Activity
     */
    public void readyGoThenKill(Class<?> clazz) {
        readyGoThenKill(clazz, null);
    }

    /**
     * @param clazz  目标Activity
     * @param bundle 数据
     */
    public void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        readyGo(clazz, bundle);
        ActivityStackManager.getInstance().getTopActivity().finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     */
    public void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(ActivityStackManager.getInstance().getTopActivity(), clazz);
        ActivityStackManager.getInstance().getTopActivity().startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     * @param bundle      数据
     */
    public void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(ActivityStackManager.getInstance().getTopActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        ActivityStackManager.getInstance().getTopActivity().startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult( fragment要返回值的方法)
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     */
    public void readyGoForResult(WeakReference<Fragment> fragment, Class<?> clazz, int requestCode) {
        Intent intent = new Intent(ActivityStackManager.getInstance().getTopActivity(), clazz);
        fragment.get().startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle ( fragment要返回值的方法)
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     * @param bundle      数据
     */
    public void readyGoForResult(WeakReference<Fragment> fragment, Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(ActivityStackManager.getInstance().getTopActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        fragment.get().startActivityForResult(intent, requestCode);
    }


}
