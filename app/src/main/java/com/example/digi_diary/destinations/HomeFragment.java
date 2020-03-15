package com.example.digi_diary.destinations;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digi_diary.Adapters.DiaryAdapter;
import com.example.digi_diary.Models.DiaryModel;
import com.example.digi_diary.destinations.AppActivity;

import com.example.digi_diary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView re_diaries;
    DiaryAdapter diaryAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationView navbar =getActivity().findViewById(R.id.bottm_nav_bar);
        navbar.setVisibility(view.VISIBLE);


        AppActivity.diaries= new ArrayList<>();
    }
    private void getDiareis(final View view){
        diaryAdapter = new DiaryAdapter(AppActivity.diaries, new DiaryAdapter.SelectionPropagator() {
            @Override
            public void propagateSelection(DiaryModel diary) {

            }

            @Override
            public void addToFavourites(DiaryModel diary) {
                AppActivity.sqlLiteHelper.addDiaryToFavourites(diary.getLocaldiary_id());
            }

            @Override
            public void removeFromFavourites(DiaryModel diary) {
                AppActivity.sqlLiteHelper.removeDiaryFromFavourites(diary.getLocaldiary_id());
            }
        });
    }

}
