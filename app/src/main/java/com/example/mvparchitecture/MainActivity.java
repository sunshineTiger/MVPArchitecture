package com.example.mvparchitecture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvparchitecture.base.BaseActivity;
import com.example.baselib.mvp.BaseCoreActivity;
import com.example.baselib.mvp.BaseMVPActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<MainPresenter, MainPresenter.MainPresenterUI> implements MainPresenter.MainPresenterUI {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.TextView1)
    TextView TextView1;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected MainPresenter.MainPresenterUI getUI() {
        return this;
    }

    @Override
    public void showUserVerifyInfo() {

    }

    @Override
    public void showUserInfo() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.textView2,R.id.TextView1})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.textView2:
                getPresenter().test();
                break;
            case R.id.TextView1:
                getPresenter().test1();
                break;
            default:
                break;
        }
    }

    @Override
    protected void restartApp() {
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }
}