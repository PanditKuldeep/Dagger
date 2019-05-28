package com.example.daggerexample.component;

import android.app.Application;

import com.example.daggerexample.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(Application application);
}
