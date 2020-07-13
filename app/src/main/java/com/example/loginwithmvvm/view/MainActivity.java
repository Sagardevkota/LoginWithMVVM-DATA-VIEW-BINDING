package com.example.loginwithmvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.loginwithmvvm.databinding.ActivityMainBinding;
import com.example.loginwithmvvm.model.LoginUser;
import com.example.loginwithmvvm.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        viewModel= ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(viewModel);

        viewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(LoginUser loginUser) {
                if (TextUtils.isEmpty(loginUser.getEmail())) {
                    binding.etEmail.setError("Enter an email address");
                    binding.etEmail.requestFocus();
                }
                else if (!loginUser.isEmailValid()) {
                    binding.etEmail.setError("Enter valid email address");
                    binding.etEmail.requestFocus();
                }
                else if (TextUtils.isEmpty(loginUser.getPassword())) {
                    binding.etPassword.setError("Enter password");
                    binding.etPassword.requestFocus();
                }
                else if (!loginUser.isPassStrong()) {
                    binding.etPassword.setError("Enter more strong password");
                    binding.etPassword.requestFocus();
                }
                else {
                    binding.etEmail.setError(null);
                    binding.etPassword.setError(null);
                    if (loginUser.isValidCredentials()) Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                    else Toast.makeText(MainActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}