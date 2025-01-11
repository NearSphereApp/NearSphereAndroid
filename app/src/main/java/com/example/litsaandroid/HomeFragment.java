package com.example.litsaandroid;

import static com.example.litsaandroid.R.id.CheckBoxArt;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TableLayout;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.dynamic.SupportFragmentWrapper;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private CheckBox booksCheck;
    private CheckBox nightlifeCheck;
    private CheckBox natureCheck;
    private CheckBox religionCheck;
    private CheckBox foodCheck;
    private CheckBox spaCheck;
    private CheckBox footballCheck;
    private CheckBox allCheck;
    private List<String> keyWord;

    public HomeFragment() {
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        CheckBox artCheck = view.findViewById(R.id.CheckBoxArt);
        booksCheck = view.findViewById(R.id.CheckBoxBooks);
        nightlifeCheck=view.findViewById(R.id.CheckBoxNight);
        natureCheck=view.findViewById(R.id.CheckBoxNature);
        religionCheck=view.findViewById(R.id.CheckBoxReligion);
        foodCheck=view.findViewById(R.id.CheckBoxFood);
        spaCheck=view.findViewById(R.id.CheckBoxSpa);
        footballCheck=view.findViewById(R.id.CheckBoxFootball);
        allCheck=view.findViewById(R.id.CheckBoxALL);

        TableLayout checkTable = view.findViewById(R.id.check_table);

        keyWord = new ArrayList<>();

        artCheck.setOnCheckedChangeListener((buttonView, isChecked) ->
                keyWord.add("art"));
        booksCheck.setOnCheckedChangeListener((buttonView, isChecked) ->
                keyWord.add("books"));
        nightlifeCheck.setOnCheckedChangeListener((buttonView, isChecked) ->
                keyWord.add("nightlife"));
        natureCheck.setOnCheckedChangeListener((buttonView, isChecked) ->
                keyWord.add("nature"));
        religionCheck.setOnCheckedChangeListener((buttonView, isChecked) ->
                keyWord.add("religion"));
        foodCheck.setOnCheckedChangeListener((buttonView, isChecked) ->
                keyWord.add("food"));
        spaCheck.setOnCheckedChangeListener((buttonView, isChecked) ->
                keyWord.add("spa"));
        footballCheck.setOnCheckedChangeListener((buttonView, isChecked) ->
                keyWord.add("football"));
        allCheck.setOnCheckedChangeListener((buttonView, isChecked) ->
                {
                    for (int i = 0; i < checkTable.getChildCount(); i++) {
                        if(checkTable.getChildAt(i) instanceof CheckBox){
                            ((CheckBox) checkTable.getChildAt(i)).setChecked(isChecked);
                        }
                    }
                }
        );


        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = FragmentManager.findFragment(view.findViewById(R.id.autocomplete_fragment));
        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(List.of(Place.Field.ADDRESS_COMPONENTS));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO: Get info about the selected place.
                Log.i("TAG", "Place: " + place.getAddressComponents());
            }


            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                Log.i("TAG", "An error occurred: " + status);
            }
        });


    }
}