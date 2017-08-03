package edu.hfuu.nfc_reader;

import android.content.Context;

/**
 * 全局可用的context对象  单例模式
 * Created by mr.lgb
 * Date: 2017/8/6.
 * Time: 11:18
 */
public class NfcContext {
    private static NfcContext instance;

    private Context applicationContext;

    public static NfcContext getInstance() {
        if (instance == null){
            throw new RuntimeException(NfcContext.class.getSimpleName() + "has not been initialized!");
        }

        return instance;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public NfcContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 全局信息 只能调用一次
     */
    public static void init(Context applicationContext) {
        if (instance != null) {
            throw new RuntimeException(NfcContext.class.getSimpleName() + " can not be initialized multiple times!");
        }
        instance = new NfcContext(applicationContext);
    }

    public static boolean isInitialized() {
        return (instance != null);
    }
}
