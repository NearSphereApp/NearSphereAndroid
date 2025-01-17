package com.example.litsaandroid.user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.litsaandroid.R;
import com.example.litsaandroid.model.User;

public class LogFragment extends Fragment {

    private UserViewModel viewModel;

    public User user = new User();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.log_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText email = view.findViewById(R.id.email);
        EditText password = view.findViewById(R.id.password);
        viewModel= new ViewModelProvider(this).get(UserViewModel.class);
        Button button = view.findViewById(R.id.LogIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setEmail(String.valueOf(email));
                user.setPassword(String.valueOf(password));
                viewModel.logUser(user.getEmail(),user.getPassword());
            }
        });
    }
}