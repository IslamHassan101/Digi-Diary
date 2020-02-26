package com.example.digi_diary;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.digi_diary.AppActivity.sqlLiteHelper;


public class SplashFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BottomNavigationView navbar =getActivity().findViewById(R.id.bottm_nav_bar);
        navbar.setVisibility(view.GONE);

        sqlLiteHelper = new SqlLiteHelper(getActivity(),"DiaresDB",null ,1);
        try {
            sqlLiteHelper.createTable();
            Toast.makeText(getActivity(),"database created",Toast.LENGTH_LONG).show();
            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    NavDirections action =
                            SplashFragmentDirections.actionSplashToHome();
                    Navigation.findNavController(view).navigate(action);
                }
            },1500);

        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}
