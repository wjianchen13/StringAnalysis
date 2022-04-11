package com.example.stringanalysis.manager;

import com.example.stringanalysis.bean.AdUserBean;

import java.util.HashMap;
import java.util.Map;

/***
 * 发言广告过滤
 */
public class LiveStudioAdFilterManager {

    private static LiveStudioAdFilterManager INSTANCE = null;

    /**
     * uid -> bean
     */
    private Map<Integer, AdUserBean> mDatas = new HashMap<>();


    /********************************************************************************
     * Methods
     *******************************************************************************/
    public static synchronized LiveStudioAdFilterManager getInstance() {

        if (INSTANCE == null) {
            synchronized (LiveStudioAdFilterManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LiveStudioAdFilterManager();
                }
            }
        }
        return INSTANCE;
    }

    private LiveStudioAdFilterManager() {

    }

    /**
     * 添加一个元素
     */
    public void addChat(AdUserBean adUserBean) {
        if(adUserBean != null) {
            int uid = adUserBean.getUid();
            if (mDatas != null) {
                if(mDatas.get(uid) != null) {

                } else {
                    mDatas.put(uid, adUserBean);
                }
            }
        }
    }

    /**
     * 删除一个元素
     */

    /**
     * 判断是否是广告，根据规则
     */

    /**
     * 判断是否满足条件，后台返回
     */

    /**
     * 判断列表是否达到阀值，如果是插入的时候删除最开始的元素
     */

    /**
     *
     */

}
