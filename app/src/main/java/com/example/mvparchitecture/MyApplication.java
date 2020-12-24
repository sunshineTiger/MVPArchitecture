package com.example.mvparchitecture;

import android.app.Application;
import android.content.Context;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.mvparchitecture
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 16:46
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 16:46
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MyApplication  extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }
}
