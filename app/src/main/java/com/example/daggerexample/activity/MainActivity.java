package com.example.daggerexample.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.daggerexample.R;
import com.example.daggerexample.component.ActivityComponent;
import com.example.daggerexample.component.DaggerActivityComponent;
import com.example.daggerexample.databinding.ActivityMainBinding;
import com.example.daggerexample.module.ActivityModule;
import com.example.daggerexample.model.CredentialModel;
import com.example.daggerexample.model.LoginModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public LoginModel loginModel;

    @Inject
    public CredentialModel credentialModel;

    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        ActivityComponent component = DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build();
        component.inject(this);



        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginModel.setStrUsername(binding.txtUsername.getText().toString().trim());
                loginModel.setStrPassword(binding.txtPassword.getText().toString().trim());

                String result = "Username: " + loginModel.getStrUsername()+ "\n\n"+ "Password : "+ loginModel.getStrPassword();
                binding.lblResult.setText(result);
                binding.lblCredential.setText(credentialModel.getLoginCreds());
            }
        });
    }
}
