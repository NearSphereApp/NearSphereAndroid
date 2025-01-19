package com.example.litsaandroid.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.litsaandroid.R;
import com.example.litsaandroid.model.User;
import com.example.litsaandroid.ui.mainActivity.Splash;

public class CreateLogFragment extends Fragment {

    User user = new User();

    public CreateLogFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_createlog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText email = view.findViewById(R.id.email);
        EditText password = view.findViewById(R.id.password);
        EditText passwordRepeat = view.findViewById(R.id.passwordrepeat);
        EditText name = view.findViewById(R.id.username);
        Button button = view.findViewById(R.id.createAccount);
        UserViewModel viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password == passwordRepeat){
                    user.setEmail(String.valueOf(email));
                    user.setPassword(String.valueOf(password));
                    user.setName(String.valueOf(name));
                    viewModel.addUser(user.getEmail(),user.getPassword(),user.getPassword());
                    Toast.makeText(getContext(),"Account created, please Log in", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(),"Passwords do not match", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getContext(), LogActivity.class);
                startActivity(intent);
            }
        });
    }
}

