package com.example.litsaandroid.ui.mainActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.litsaandroid.FavouritesFragment;
import com.example.litsaandroid.HomeFragment;
import com.example.litsaandroid.PlacesFragment;
import com.example.litsaandroid.R;
import com.example.litsaandroid.UserInfoFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private NavigationBarView bottomNavigationView;
    private HomeFragment homeFragment = new HomeFragment();
    private FavouritesFragment favouritesFragment = new FavouritesFragment();
    private UserInfoFragment userInfoFragment = new UserInfoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main, homeFragment)
                    .commit();
            return true;
        }
        if (item.getItemId() == R.id.favourites) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main, favouritesFragment)
                    .commit();
            return true;
        }
        if (item.getItemId() == R.id.user) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main, userInfoFragment)
                    .commit();
            return true;
        }
        return false;
    }
}