//package com.example.litsaandroid.ui.home;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//
//import com.example.litsaandroid.R;
//import com.example.litsaandroid.model.Places;
//import com.example.litsaandroid.ui.mainActivity.MainActivity;
//import com.google.android.gms.common.api.Status;
//import com.google.android.libraries.places.api.model.Place;
//import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
//import com.google.android.libraries.places.api.net.PlacesClient;
//import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
//import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
//
//import java.util.List;
//import java.util.Objects;
//
//public class Autosearch extends Fragment {
//
//    Places placesModel;
//    MainActivity main;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        //initialise Places
//        com.google.android.libraries.places.api.Places.initializeWithNewPlacesApiEnabled(getActivity().getApplicationContext(),main.key);
//        PlacesClient placesClient = com.google.android.libraries.places.api.Places.createClient(getActivity());
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
//
//    }
//
//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        // Initialize the AutocompleteSupportFragment.
//        AutocompleteSupportFragment autocompleteFragment = FragmentManager.findFragment(view.findViewById(R.id.autocomplete_fragment));
//        // Specify the types of place data to return.
//        autocompleteFragment.setPlaceFields(List.of(Place.Field.SHORT_FORMATTED_ADDRESS));
//
//        // Set up a PlaceSelectionListener to handle the response.
//        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
//            @Override
//            public void onPlaceSelected(@NonNull Place place) {
//                // TODO: Get info about the selected place.
//                autocompleteFragment.setText(place.getShortFormattedAddress());
//                double latitude = place.getLocation().latitude;
//                double longitude = place.getLocation().longitude;
//            }
//
//
//            @Override
//            public void onError(@NonNull Status status) {
//                // TODO: Handle the error.
//                Log.i("TAG", "An error occurred: " + status);
//            }
//        });
//
//    }
//}
