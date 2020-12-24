package com.example.baselib.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.baselib.mvp
 * @ClassName: BaseMVPFragment
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 11:48
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 11:48
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseMVPFragment<P extends BaseFragmentPresenter<V>, V extends BaseUI> extends LazyLoadFragment {

    private P presenter;


    protected abstract V getUI();

    protected abstract P createPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (savedInstanceState != null) {
//            presenter = (P) savedInstanceState.getSerializable("presenter");
//        }
        presenter.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putSerializable("presenter", (Serializable) presenter);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //会不会导致多个Presenter，从而丢失了自己原有的数据
        if (presenter == null)
            presenter = createPresenter();

        presenter.onAttach(context, this);
    }

    @Override
    protected void setRootView(View rootView) {
        super.setRootView(rootView);

    }

    @Override
    protected void executeOnceAfterCreateView() {
//        if (getActivity() instanceof BaseCoreActivity) {
//            Throwable new Exception("请继承BaseCoreActivity");
//        }
        presenter.onUIReady((BaseCoreActivity) getActivity(), getUI());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        presenter.onHiddenChanged(hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (presenter != null)
            presenter.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    protected void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        if (presenter != null)
            presenter.onVisibleChanged(visible);
    }

    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        if (presenter != null)
            presenter.lazyLoadData();
    }

    public P getPresenter() {
        return presenter;
    }

    public boolean isAlive() {
        return this.isAdded() && ((BaseCoreActivity) getActivity()).isAlive();
    }
}
