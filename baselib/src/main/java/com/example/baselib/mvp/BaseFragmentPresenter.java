package com.example.baselib.mvp;

import android.content.Context;
import android.os.Bundle;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.baselib.mvp
 * @ClassName: BaseFragmentPresenter
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 11:47
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 11:47
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseFragmentPresenter<V extends BaseUI> extends AbstractPresenter<V> {

    private BaseMVPFragment fragment;

    public void onAttach(Context context, BaseMVPFragment fragment) {
        this.fragment = fragment;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
    }

    public void onDestroyView() {
    }

    public void onDetach() {

    }

    public BaseMVPFragment getFragment() {
        return fragment;
    }


    public void onCreate(Bundle savedInstanceState) {

    }

    public void onHiddenChanged(boolean hidden) {

    }

    public void setUserVisibleHint(boolean userVisibleHint) {
    }

    public void onVisibleChanged(boolean visible) {

    }

    public void lazyLoadData() {

    }
}
