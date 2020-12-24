package com.example.baselib.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.baselib.utils.LogUtil;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.baselib.mvp
 * @ClassName: LazyLoadFragment
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 11:48
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 11:48
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
abstract class LazyLoadFragment extends BaseCoreFragment {
    private boolean isViewCreated;

    private boolean isLoadDataCompleted;

    private boolean isVisibleToUser = false; //所有的Fragment最开始都是不可见状态

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isViewCreated && !isLoadDataCompleted) {
            lazyLoadData();
        }

//        DebugLog.e("XXXXX", this.toString() + "    isVisibleToUser  " + isVisibleToUser);
        if (isViewCreated && isAdded()) {
            setVisibleChanged(isVisibleToUser && !realHidden());
        }
    }

    /**
     * 要同时对他的parent进行计算
     *
     * @return
     */
    public boolean realHidden() {
        if (getParentFragment() == null) {
            return isHidden();
        } else if (getParentFragment() instanceof LazyLoadFragment) {
            return ((LazyLoadFragment) getParentFragment()).realHidden() || isHidden();
        } else {
            return isHidden() && getParentFragment().isHidden();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isViewCreated = true;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getUserVisibleHint() && !isLoadDataCompleted) {
            lazyLoadData();
        }
    }

    protected void lazyLoadData() {
        isLoadDataCompleted = true;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        setVisibleChanged(!hidden);
    }

    /**
     * {@link #isVisible()}
     */
    @Override
    public void onResume() {
        super.onResume();

        if (isAdded()) {

            setVisibleChanged(!realHidden() && getUserVisibleHint());
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (isAdded()) {

            setVisibleChanged(false);
        }
    }

    /**
     * 没有使用 {@link #setUserVisibleHint(boolean)} 是因为它会公布到Fragment外部调用，混在一起太混乱了
     *
     * @param visible
     */
    private void setVisibleChanged(boolean visible) {
        if (isVisibleToUser == visible) // 解决重复调用问题
        {

            return;
        }

//        //如果是嵌套的Fragment，需要在parent可见的情况下 讨论自身的可见性 TODO 太过复杂，先不讨论这种情况了
//        if (getParentFragment() != null
//                && getParentFragment() instanceof LazyLoadFragment
//                && !((LazyLoadFragment) getParentFragment()).isVisibleToUser) {
//            return;
//        }


        isVisibleToUser = visible;
        onVisibleChanged(visible);
    }

    /**
     * Fragment的可见性变化回调
     *
     * @param visible
     */
    protected void onVisibleChanged(boolean visible) {
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------  visible:" + visible);
    }
}
