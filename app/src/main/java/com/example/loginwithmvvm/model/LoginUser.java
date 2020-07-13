package com.example.loginwithmvvm.model;

import android.util.Patterns;



import com.example.loginwithmvvm.callback.loginCallbacks;

public class LoginUser implements loginCallbacks {
    private String email;
    private String password;

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Boolean isEmailValid() {
      return Patterns.EMAIL_ADDRESS.matcher(getEmail().trim()).matches();
    }

    @Override
    public Boolean isPassStrong() {
        return getPassword().trim().length()>5;
    }

    @Override
    public Boolean isValidCredentials() {
        return getEmail().equalsIgnoreCase("sagardevkota55@gmail.com")&&getPassword().equalsIgnoreCase("sagar123");
    }


}
