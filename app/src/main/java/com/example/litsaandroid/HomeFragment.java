package com.example.litsaandroid;

import static com.example.litsaandroid.R.id.CheckBoxArt;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.dynamic.SupportFragmentWrapper;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private CheckBox booksCheck;
    private CheckBox nightlifeCheck;
    private CheckBox natureCheck;
    private CheckBox religionCheck;
    private CheckBox foodCheck;
    private CheckBox spaCheck;
    private CheckBox footballCheck;
    private CheckBox allCheck;
    public List<String> keyWord;
    public String address;
    public double radius;
    public Slider slider;

    final Slider.OnSliderTouchListener touchListener =
            new Slider.OnSliderTouchListener() {
                @Override
                public void onStartTrackingTouch(Slider slider) {
                }

                @Override
                public void onStopTrackingTouch(Slider slider) {
                    radius = slider.getValue();
                }
            };
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

        slider = view.findViewById(R.id.continuousSlider);
        slider.addOnSliderTouchListener(touchListener);


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

            artCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    keyWord.add("culture");
                    keyWord.add("entertainment");
                } else {
                    keyWord.remove("culture");
                    keyWord.remove("entertainment");
                }
                Log.i("keywords", keyWord.toString());

            });
            booksCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    keyWord.add("books");
                } else {
                    keyWord.remove("books");
                }
                Log.i("keywords", keyWord.toString());
            });
            nightlifeCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    keyWord.add("nightlife");
                } else {
                    keyWord.remove("nightlife");
                }
                Log.i("keywords", keyWord.toString());
            });
            natureCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    keyWord.add("nature");
                } else {
                    keyWord.remove("nature");
                }
                Log.i("keywords", keyWord.toString());
            });
            religionCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    keyWord.add("religion");
                } else {
                    keyWord.remove("religion");
                }
                Log.i("keywords", keyWord.toString());
            });
            foodCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    keyWord.add("food");
                } else {
                    keyWord.remove("food");
                }
                Log.i("keywords", keyWord.toString());
            });
            spaCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    keyWord.add("health");
                    keyWord.add("wellness");
                } else {
                    keyWord.remove("health");
                    keyWord.remove("wellness");
                }
                Log.i("keywords", keyWord.toString());
            });
            footballCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    keyWord.add("sports");
                } else {
                    keyWord.remove("sports");
                }
                Log.i("keywords", keyWord.toString());
            });
            allCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
                for (int i = 0; i < checkTable.getChildCount(); i++) {
                    View child = checkTable.getChildAt(i);

                    if (child instanceof CheckBox) {
                        ((CheckBox) child).setChecked(isChecked);
                    }
                    else if (child != null) {
                        TableRow row = (TableRow) child;
                        for (int j = 0; j < row.getChildCount(); j++) {
                            View rowChild = row.getChildAt(j);
                            if (rowChild instanceof CheckBox) {
                                ((CheckBox) rowChild).setChecked(isChecked);
                            }
                        }
                    }
                }
                Log.i("keywords", keyWord.toString());
            });


        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = FragmentManager.findFragment(view.findViewById(R.id.autocomplete_fragment));
        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(List.of(Place.Field.SHORT_FORMATTED_ADDRESS));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO: Get info about the selected place.
               autocompleteFragment.setText(place.getShortFormattedAddress());
               address = place.getShortFormattedAddress();
            }


            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                Log.i("TAG", "An error occurred: " + status);
            }
        });



        Button button = view.findViewById(R.id.submit_button);
        onSubmitButtonClicked(button);

    }
    public void onSubmitButtonClicked(View view){
        Intent intent = new Intent(view.getContext(), PlacesFragment.class);
        requireContext().startActivity(intent);
    }

}