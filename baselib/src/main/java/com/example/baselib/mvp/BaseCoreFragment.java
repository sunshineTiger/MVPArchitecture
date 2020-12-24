package com.example.baselib.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.baselib.utils.LogUtil;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.lang.reflect.Method;
import java.util.List;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.baselib.mvp
 * @ClassName: BaseCoreFragment
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 11:44
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 11:44
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseCoreFragment extends Fragment {

    protected View rootView;

    public BaseCoreFragment() {
        super();
        setArguments(new Bundle());
    }

    /**
     * 这个不会由Fragment自身的生命周期发起 而是由 {@link android.support.v4.app.FragmentPagerAdapter}
     * 和 {@link android.support.v4.app.FragmentStatePagerAdapter} 来调用，所以一般情况下，只有在ViewPager
     * 中才会有
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------  userVisible:" + isVisibleToUser);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");

        if (rootView == null) {
            setRootView(createView(inflater, container, savedInstanceState));
            //createView(getLayoutId(),container,false)
            executeOnceAfterCreateView();
        }

        if (rootView.getParent() != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }

        return rootView;
    }

    /**
     * 在Fragment show hide 的时候被调用，但是第一次不会调用，可以查看{@link android.support.v4.app.FragmentManager}
     * 源码，了解调用时机
     *
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        List<Fragment> frgs = getChildFragmentManager().getFragments();
        if (frgs != null) {

            for (Fragment item : frgs) {
                if (item != null && item.isAdded()) {
                    //两个有一个为隐藏 则认为是隐藏模式的
                    item.onHiddenChanged(hidden || item.isHidden());
                }
            }
        }

        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------ hidden:" + hidden);
    }

    /**
     * 只执行一次
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    protected abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void executeOnceAfterCreateView();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    @Override
    public void onResume() {
        super.onResume();

//        List<Fragment> frgs = getChildFragmentManager().getFragments();
//        if (frgs != null)
//            for (Fragment item : frgs) {
//                if (item != null) {
//                    item.onResume();
//                }
//            }

        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    @Override
    public void onPause() {
        super.onPause();

//        List<Fragment> frgs = getChildFragmentManager().getFragments();
//        if (frgs != null)
//            for (Fragment item : frgs) {
//                if (item != null) {
//                    item.onPause();
//                }
//            }

//        deliverCall2Child("onPause");
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    protected void deliverCall2Child(String methodName, Object... params) {
        List<Fragment> frgs = getChildFragmentManager().getFragments();
        if (frgs == null) {

            return;
        }

        for (Fragment item : frgs) {
            if (item == null) {
                return;
            }
            try {
                Class clazz = Class.forName(item.getClass().getName());
                Method method = clazz.getMethod(methodName);
                method.invoke(item, params);
            } catch (Exception e) {
                LogUtil.getInstance().d(e.getMessage());
            }

            item.onPause();
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.getInstance().d(getClass().getSimpleName() + "------enter------");
    }

    protected void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public View getRootView() {
        return rootView;
    }
}
