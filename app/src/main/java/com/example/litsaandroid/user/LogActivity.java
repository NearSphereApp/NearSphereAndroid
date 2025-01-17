package com.example.litsaandroid.user;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.litsaandroid.R;
import com.example.litsaandroid.model.User;
import com.example.litsaandroid.ui.mainActivity.HomeFragment;

public class LogActivity extends AppCompatActivity {

    private UserViewModel viewModel;

    public User user = new User();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.log_in);


        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        viewModel= new ViewModelProvider(this).get(UserViewModel.class);

        //logic for log in button
        Button button = findViewById(R.id.LogIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment home = new HomeFragment();
                user.setEmail(String.valueOf(email));
                user.setPassword(String.valueOf(password));
                try {
                  if(viewModel.isLoginValid(viewModel.logUser(user.getEmail(),user.getPassword()))){
                    //if login is successful we move to the HomeFragment
                      getSupportFragmentManager()
                              .beginTransaction()
                              .replace(R.id.fllogin, home)
                              .commit();
                  } else {
                      Toast.makeText(getApplicationContext(),"Log in not successful, try again",Toast.LENGTH_SHORT).show();
                  }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //logic for create button

        Button createButton = findViewById(R.id.createAccount);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateLogFragment create = new CreateLogFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fllogin, create)
                        .commit();
            }
        });

        //logic for forgetting password button
        Button passwordreset = findViewById(R.id.reset_password);
        passwordreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetPasswordFragment reset = new ResetPasswordFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fllogin, reset)
                        .commit();
            }
        });


    }
}