package com.example.daggerexample.component;

import com.example.daggerexample.activity.MainActivity;
import com.example.daggerexample.module.ActivityModule;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
