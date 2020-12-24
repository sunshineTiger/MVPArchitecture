package com.example.mvparchitecture.app;

/**
 * @ProjectName: MVPArchitecture
 * @Package: com.example.mvparchitecture.app
 * @ClassName: AppStatusManager
 * @Description: java类作用描述
 * @Author: zhanghong
 * @CreateDate: 2020/12/23 16:15
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/12/23 16:15
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public class AppStatusManager {

    public int appStatus = AppStatusConstant.STATUS_FORCE_KILLED; //APP状态 初始值为没启动 不在前台状态
    public static AppStatusManager appStatusManager;

    private AppStatusManager() {
    }

    public static AppStatusManager getInstance() {
        if (appStatusManager == null) {
            appStatusManager = new AppStatusManager();
        }
        return appStatusManager;
    }

    public int getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(int appStatus) {
        this.appStatus = appStatus;
    }
}
