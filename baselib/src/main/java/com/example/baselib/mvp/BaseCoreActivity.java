package com.example.baselib.mvp;


import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.baselib.utils.LogUtil;

import java.util.List;


/**
 * 最基础的Activity类，所有原生Activity，都应继承他
 * ================================================
 *
 * @ProjectName: MVPArchitecture
 * @Package: com.example.baselib
 * @ClassName: BaseCoreActivity
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/21 16:29
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/21 16:29
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseCoreActivity extends AppCompatActivity {

    protected boolean isAlive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.getInstance().d(getClass().getSimpleName() + "---onCreate---enter------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.getInstance().d(getClass().getSimpleName() + "---onRestart---enter------");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.getInstance().d(getClass().getSimpleName() + "---onRestoreInstanceState---enter------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.getInstance().d(getClass().getSimpleName() + "---onStart---enter------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.getInstance().d(getClass().getSimpleName() + "---onResume---enter------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.getInstance().d(getClass().getSimpleName() + "----onPause--enter------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.getInstance().d(getClass().getSimpleName() + "---onStop---enter------");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtil.getInstance().d(getClass().getSimpleName() + "---onConfigurationChanged---enter------");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.getInstance().d(getClass().getSimpleName() + "---onSaveInstanceState---enter------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.getInstance().d(getClass().getSimpleName() + "---onSaveInstanceState---enter------");

        isAlive = false;
    }

    /**
     * Activity 是否还可用
     *
     * @return
     */
    public boolean isAlive() {
        return isAlive && !isFinishing();
    }

    public Fragment instanceFragment(String fName, Bundle bundle, String tag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            if (fragment.getArguments() != null) {
                fragment.getArguments().putAll(bundle);
            }
            return fragment;
        }

        List<Fragment> frgs = getSupportFragmentManager().getFragments();
        if (frgs != null) {
            for (Fragment item : frgs) {
                //这里有可能会有问题，因为多个相同的fragment到这里就会出错
                if (item == null || !item.getClass().getName().equals(fName)) {

                    continue;
                }

                if (item.getArguments() != null) {

                    item.getArguments().putAll(bundle);
                }
                return item;
            }
        }

        fragment = Fragment.instantiate(this, fName, bundle);

        return fragment;
    }

    public Fragment instanceFragment(String fName, Bundle bundle) {
        return instanceFragment(fName, bundle, fName);
    }
}

