package com.example.loginwithmvvm.viewmodel;


import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginwithmvvm.model.LoginUser;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> email=new MutableLiveData<>();
    public MutableLiveData<String> password=new MutableLiveData<>();
    public MutableLiveData<LoginUser> userMutableLiveData;

    public MutableLiveData<LoginUser> getUser()
    {
        if (userMutableLiveData==null)
        {
            userMutableLiveData=new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onClick(View view)
    {
        LoginUser loginUser=new LoginUser(email.getValue(),password.getValue());
        userMutableLiveData.setValue(loginUser);
    }
}
