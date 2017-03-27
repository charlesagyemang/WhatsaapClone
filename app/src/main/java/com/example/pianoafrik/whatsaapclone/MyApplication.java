package com.example.pianoafrik.whatsaapclone;

import android.app.Application;


import com.example.pianoafrik.whatsaapclone.fakemodel.DaoMaster;
import com.example.pianoafrik.whatsaapclone.fakemodel.DaoSession;

import org.greenrobot.greendao.database.Database;


public class MyApplication extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "carservice-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
