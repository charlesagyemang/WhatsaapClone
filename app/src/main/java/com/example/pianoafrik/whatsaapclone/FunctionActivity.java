package com.example.pianoafrik.whatsaapclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pianoafrik.whatsaapclone.fakemodel.DaoSession;


public class FunctionActivity extends AppCompatActivity {

    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        myApplication = (MyApplication) getApplication();
    }


    public DaoSession getAppDaoSession () {
       return  myApplication.getDaoSession();
    }

}
