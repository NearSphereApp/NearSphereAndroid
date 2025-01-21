package com.example.litsaandroid.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litsaandroid.R;
import com.example.litsaandroid.model.TokenStorage;
import com.example.litsaandroid.model.User;
import com.example.litsaandroid.model.UserResponse;
import com.example.litsaandroid.ui.mainActivity.Splash;

import java.util.Objects;

public class UserInfoFragment extends Fragment {

    EditText name;
    TextView email;
    Button updateButton;
    Button outButton;
    Button passwordResetButton;
    Button deleteAccountButton;
    TokenStorage tokenStorage;
    UserViewModel viewModel;
    UserResponse response;

    public UserInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            tokenStorage = new TokenStorage(getContext());
        } catch (Exception e) {
            Log.i("Tag", Objects.requireNonNull(e.getMessage()));

        }

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);


        //Displaying user name and email
       String token = response.getToken();
       name = view.findViewById(R.id.name);
       email = view.findViewById(R.id.email);
        String nameUser = name.getText().toString();
        String emailUser = name.getText().toString();
        User user = new User("Maria","mariasantos@hotmail.com");
//        try {
//            user = viewModel.getUser();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        assert user != null;
        name.setText(user.getName());
        email.setText(user.getEmail());


        //logic for update button
        updateButton = view.findViewById(R.id.update);

        User finalUser = user;
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewModel.editUser(finalUser);
            User newUser = new User(emailUser,nameUser);
            name.setText(newUser.getName());
            email.setText(newUser.getEmail());

                Intent intent = new Intent(getContext(), Splash.class);
                startActivity(intent);
            }
        });

        //logic for logout button
        outButton = view.findViewById(R.id.logOut);
        outButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tokenStorage.clearToken();
                Intent intent = new Intent(getContext(), LogActivity.class);
                startActivity(intent);
            }
        });

        //logic for delete button
        //might need an endpoint in the backend for deleting user
        deleteAccountButton = view.findViewById(R.id.deleteUser);
        deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tokenStorage.clearToken();
                Intent intent = new Intent(getContext(), Splash.class);
                startActivity(intent);
                Toast.makeText(getContext(),"Account deleted successfully",Toast.LENGTH_SHORT).show();
            }
        });

        //logic for passwordReset
        PasswordEditFragment passwordEditFragment = new PasswordEditFragment();
        passwordResetButton = view.findViewById(R.id.password);
        passwordResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.flHome, passwordEditFragment).addToBackStack(null).commit();
            }
        });
    }
}