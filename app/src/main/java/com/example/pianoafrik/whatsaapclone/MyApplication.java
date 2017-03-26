package com.example.pianoafrik.whatsaapclone;

import android.app.Application;

import com.example.pianoafrik.whatsaapclone.greendao.DaoMaster;
import com.example.pianoafrik.whatsaapclone.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;


/**
 * Created by pianoafrik on 3/26/17.
 */

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
