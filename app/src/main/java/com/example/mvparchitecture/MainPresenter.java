package com.example.mvparchitecture;

import android.widget.Toast;

import com.example.baselib.mvp.BasePresenter;
import com.example.mvparchitecture.base.AppUI;


/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.mvparchitecture
 * @ClassName: MainPresenter
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 16:09
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 16:09
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MainPresenter extends BasePresenter<MainPresenter.MainPresenterUI> {
    public interface MainPresenterUI extends AppUI {

        void showUserVerifyInfo();

        void showUserInfo();
    }


    public void test() {

        getUI().showUserVerifyInfo();
        Toast.makeText(MyApplication.mContext, "test", Toast.LENGTH_SHORT).show();
    }

    public void test1() {
        getUI().showUserInfo();
        Toast.makeText(MyApplication.mContext, "test1", Toast.LENGTH_SHORT).show();
    }

}
