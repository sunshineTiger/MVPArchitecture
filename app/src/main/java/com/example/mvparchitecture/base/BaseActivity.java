package com.example.mvparchitecture.base;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.baselib.mvp.BaseMVPActivity;
import com.example.baselib.mvp.BasePresenter;
import com.example.baselib.mvp.BaseUI;
import com.example.baselib.utils.KeyBoardUtil;
import com.example.mvparchitecture.MainActivity;
import com.example.mvparchitecture.R;
import com.example.mvparchitecture.app.AppStatusConstant;
import com.example.mvparchitecture.app.AppStatusManager;

import butterknife.ButterKnife;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.mvparchitecture.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 16:12
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 16:12
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseActivity<P extends BasePresenter<V>, V extends AppUI & BaseUI> extends BaseMVPActivity<P, V> implements AppUI {
    private Dialog dialog;
    private int dialogRef;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switchAppStatus(AppStatusManager.getInstance().getAppStatus());
        dialogRef = 0;
        ButterKnife.bind(this);
    }

    @Override
    public void showProgressDialog() {
        showProgressDialog("", "");
    }

    @Override
    protected void setContentViewExt() {
        int view = getContentView();
        if (view != -1) {//启动activity不需要setContentView，所以在此加上临时判断
            setContentView(view);
            initView();
            addEvent();
        }
    }


    protected abstract int getContentView();

    protected void initView() {
    }

    protected void addEvent() {
    }

    @Override
    public void showProgressDialog(String title, String hint) {
        if (!isAlive()) {

            return;
        }

        dialogRef++;

        if (dialog != null && dialog.isShowing()) {

            return;
        }


        if (dialog == null) {
            dialog = new Dialog(this, R.style.dialogLoading);
            dialog.setContentView(R.layout.loading_waiting_layout);
            progressBar = dialog.findViewById(R.id.bar_loading);

        }


        if (!TextUtils.isEmpty(title)) {

            dialog.setTitle(title);
        }
        if (!TextUtils.isEmpty(hint)) {

            ((TextView) dialog.findViewById(R.id.loading_hint_text)).setText(hint);
        }

        dialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (isAlive() && dialog != null && --dialogRef <= 0) {
            dialog.dismiss();
        }
    }

    public void switchAppStatus(int appStatus) {
        switch (appStatus){
            case AppStatusConstant.STATUS_FORCE_KILLED:
                restartApp();
                break;
            case AppStatusConstant.STATUS_NORMAL:
//                setUpViewAndData();
                break;
        }
    }

    protected void restartApp() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(AppStatusConstant.KEY_HOME_ACTION,AppStatusConstant.ACTION_RESTART_APP);
        startActivity(intent);
    }
}
