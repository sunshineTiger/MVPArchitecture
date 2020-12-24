package com.example.baselib.mvp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.baselib.mvp
 * @ClassName: AbstractPresenter
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 11:41
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 11:41
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class AbstractPresenter<V extends BaseUI> implements IPresenter<V> {

    protected BaseCoreActivity activity;

    private WeakReference<V> mUI;

    protected BaseCoreActivity getActivity() {
        return activity;
    }

    @Override
    public V getUI() {
        return mUI == null ? null : mUI.get();
    }

    public Resources getResources() {
        return activity.getResources();
    }

    @Override
    public String getString(int resId) {
        return getResources().getString(resId);
    }

    @Override
    public void onUIReady(BaseCoreActivity activity, V ui) {
        this.activity = activity;
        this.mUI = new WeakReference<V>(ui);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
