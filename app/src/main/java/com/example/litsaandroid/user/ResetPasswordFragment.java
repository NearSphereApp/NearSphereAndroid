package com.example.litsaandroid.user;

import android.content.Intent;
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
import com.example.litsaandroid.ui.mainActivity.Splash;


public class ResetPasswordFragment extends Fragment {

    User user = new User();
    UserViewModel viewModel;


    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reset_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        EditText emailbox = view.findViewById(R.id.email);
        String email = emailbox.getText().toString();
        Button button = view.findViewById(R.id.reset_password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.resetPassword(email);

                Intent intent = new Intent(getContext(), LogActivity.class);
                startActivity(intent);
            }
        });

    }
}