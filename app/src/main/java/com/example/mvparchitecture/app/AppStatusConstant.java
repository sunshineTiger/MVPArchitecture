package com.example.mvparchitecture.app;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.mvparchitecture.app
 * @ClassName: AppStatusConstant
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 16:15
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 16:15
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public class AppStatusConstant {
    //应用放在后台被强杀了
    public static final int STATUS_FORCE_KILLED = -1;
    //APP正常态 intent到MainActivity 区分跳转目的
    public static final int STATUS_NORMAL = 2;
    //返回到主页面
    public static final String KEY_HOME_ACTION = "key_home_action";
    //默认值
    public static final int ACTION_BACK_TO_HOME = 0;
    //被强杀
    public static final int ACTION_RESTART_APP = 1;
}
