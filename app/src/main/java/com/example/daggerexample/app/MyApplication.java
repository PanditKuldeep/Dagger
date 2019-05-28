package com.example.daggerexample.app;

import android.app.Application;

import com.example.daggerexample.component.AppComponent;
import com.example.daggerexample.component.DaggerAppComponent;
import com.example.daggerexample.module.AppModule;

public class MyApplication extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

}
