package com.example.litsaandroid.user;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.litsaandroid.model.User;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        this.userRepository = new UserRepository(application);
    }

    public LiveData<User> getUser(String token) {
        return userRepository.getUser(token);
    }
    public void addUser (String email, String password, String username){
    userRepository.addUser(email, password, username);
    }
    public void logUser(String email, String password){
        userRepository.logUser(email,password);
    }
}


