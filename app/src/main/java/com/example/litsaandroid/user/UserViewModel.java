package com.example.litsaandroid.user;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.litsaandroid.model.User;
import com.example.litsaandroid.repositories.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) throws Exception {
        super(application);
        this.userRepository = new UserRepository(application);
    }

    public User getUser() throws Exception {
        return userRepository.getUser();
    }
    public void addUser (User user){
    userRepository.addUser(user);
    }
    public void logUser(User user) throws Exception {
        userRepository.logUser(user);

    }
//    public Boolean isLoginValid (UserResponse userResponse){
//        return userResponse.getToken() != null;
//    }

    public User editUser(User user){
        return userRepository.editUser(user);
    }
}


