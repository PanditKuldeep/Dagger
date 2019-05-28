package com.example.daggerexample.module;

import android.content.Context;
import com.example.daggerexample.viewModel.CredentialModel;
import com.example.daggerexample.viewModel.LoginModel;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class ActivityModule {
    private Context context;

    public ActivityModule(Context context){
        this.context = context;
    }

    @Singleton @Provides
    public Context getContext(){
        return context;
    }

    @Singleton @Provides
    public LoginModel loginViewModel(){
        return new LoginModel();
    }

    @Singleton @Provides
    public CredentialModel credentialViewModel(){
        return new CredentialModel();
    }
}
