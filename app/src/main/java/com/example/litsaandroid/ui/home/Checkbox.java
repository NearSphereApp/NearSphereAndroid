//package com.example.litsaandroid.ui.home;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//
//import com.example.litsaandroid.R;
//import com.example.litsaandroid.model.Places;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Checkbox  {
//    private CheckBox booksCheck;
//    private CheckBox nightlifeCheck;
//    private CheckBox natureCheck;
//    private CheckBox religionCheck;
//    private CheckBox foodCheck;
//    private CheckBox spaCheck;
//    private CheckBox footballCheck;
//    private CheckBox allCheck;
//    public List<String> keyWord;
//    public Places places;
//
//    public Checkbox() {
//    }
//
//    public void onChecked(@NonNull View view) {
//
//        CheckBox artCheck = view.findViewById(R.id.CheckBoxArt);
//        booksCheck = view.findViewById(R.id.CheckBoxBooks);
//        nightlifeCheck = view.findViewById(R.id.CheckBoxNight);
//        natureCheck = view.findViewById(R.id.CheckBoxNature);
//        religionCheck = view.findViewById(R.id.CheckBoxReligion);
//        foodCheck = view.findViewById(R.id.CheckBoxFood);
//        spaCheck = view.findViewById(R.id.CheckBoxSpa);
//        footballCheck = view.findViewById(R.id.CheckBoxFootball);
//        allCheck = view.findViewById(R.id.CheckBoxALL);
//
//        TableLayout checkTable = view.findViewById(R.id.check_table);
//
//        keyWord = new ArrayList<>();
//
//        artCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                keyWord.add("culture");
//                keyWord.add("entertainment");
//            } else {
//                keyWord.remove("culture");
//                keyWord.remove("entertainment");
//            }
//            Log.i("keywords", keyWord.toString());
//
//        });
//        booksCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                keyWord.add("books");
//            } else {
//                keyWord.remove("books");
//            }
//            Log.i("keywords", keyWord.toString());
//        });
//        nightlifeCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                keyWord.add("nightlife");
//            } else {
//                keyWord.remove("nightlife");
//            }
//            Log.i("keywords", keyWord.toString());
//        });
//        natureCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                keyWord.add("nature");
//            } else {
//                keyWord.remove("nature");
//            }
//            Log.i("keywords", keyWord.toString());
//        });
//        religionCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                keyWord.add("religion");
//            } else {
//                keyWord.remove("religion");
//            }
//            Log.i("keywords", keyWord.toString());
//        });
//        foodCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                keyWord.add("food");
//            } else {
//                keyWord.remove("food");
//            }
//            Log.i("keywords", keyWord.toString());
//        });
//        spaCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                keyWord.add("health");
//                keyWord.add("wellness");
//            } else {
//                keyWord.remove("health");
//                keyWord.remove("wellness");
//            }
//            Log.i("keywords", keyWord.toString());
//        });
//        footballCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                keyWord.add("sports");
//            } else {
//                keyWord.remove("sports");
//            }
//            Log.i("keywords", keyWord.toString());
//        });
//        allCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            for (int i = 0; i < checkTable.getChildCount(); i++) {
//                View child = checkTable.getChildAt(i);
//
//                if (child instanceof CheckBox) {
//                    ((CheckBox) child).setChecked(isChecked);
//                } else if (child != null) {
//                    TableRow row = (TableRow) child;
//                    for (int j = 0; j < row.getChildCount(); j++) {
//                        View rowChild = row.getChildAt(j);
//                        if (rowChild instanceof CheckBox) {
//                            ((CheckBox) rowChild).setChecked(isChecked);
//                        }
//                    }
//                }
//            }
//            Log.i("keywords", keyWord.toString());
//        });
//        places.setKeyWord(keyWord);
//    }
//
//}
