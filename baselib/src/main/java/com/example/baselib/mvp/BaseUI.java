package com.example.baselib.mvp;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.baselib.mvp
 * @ClassName: BaseUI
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 11:39
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 11:39
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public interface BaseUI {
    void showProgressDialog(String title, String hint);
    void showProgressDialog();

    void dismissProgressDialog();

    boolean isAlive();
}
