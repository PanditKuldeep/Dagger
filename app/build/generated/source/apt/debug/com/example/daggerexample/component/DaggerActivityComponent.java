// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.daggerexample.component;

import com.example.daggerexample.activity.MainActivity;
import com.example.daggerexample.activity.MainActivity_MembersInjector;
import com.example.daggerexample.module.ActivityModule;
import com.example.daggerexample.module.ActivityModule_CredentialViewModelFactory;
import com.example.daggerexample.module.ActivityModule_LoginViewModelFactory;
import com.example.daggerexample.viewModel.CredentialModel;
import com.example.daggerexample.viewModel.LoginModel;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<LoginModel> loginViewModelProvider;

  private Provider<CredentialModel> credentialViewModelProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.loginViewModelProvider =
        DoubleCheck.provider(ActivityModule_LoginViewModelFactory.create(builder.activityModule));

    this.credentialViewModelProvider =
        DoubleCheck.provider(
            ActivityModule_CredentialViewModelFactory.create(builder.activityModule));

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(loginViewModelProvider, credentialViewModelProvider);
  }

  @Override
  public void inject(MainActivity mainActivity) {
    mainActivityMembersInjector.injectMembers(mainActivity);
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }
  }
}
