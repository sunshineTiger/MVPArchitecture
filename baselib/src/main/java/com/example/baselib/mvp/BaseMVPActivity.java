package com.example.baselib.mvp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.baselib.mvp
 * @ClassName: BaseMVPActivity
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 16:06
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 16:06
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseMVPActivity<P extends BasePresenter<V>, V extends BaseUI> extends BaseCoreActivity {

    private P presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        //設置view
        setContentViewExt();
        presenter.onUIReady(this, getUI());
    }

    protected P getPresenter(){
        return presenter;
    }

    protected abstract void setContentViewExt();

    protected abstract P createPresenter();

    protected abstract V getUI();

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        presenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        presenter.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }
}
