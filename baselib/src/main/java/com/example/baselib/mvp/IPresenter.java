package com.example.baselib.mvp;

import android.content.Intent;
import android.os.Bundle;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.baselib.mvp
 * @ClassName: IPresenter
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 11:40
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 11:40
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public interface IPresenter<V> {

    String getString(int resId);

    V getUI();

    void onUIReady(BaseCoreActivity activity, V ui);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);

    void onRestoreInstanceState(Bundle savedInstanceState);

    void onSaveInstanceState(Bundle outState);

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
