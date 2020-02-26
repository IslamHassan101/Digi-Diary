package com.example.digi_diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AppActivity extends AppCompatActivity {
    FloatingActionButton compose_button;

    public static SqlLiteHelper sqlLiteHelper ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

//this lines of code for connect all fragments
        BottomNavigationView navView= findViewById(R.id.bottm_nav_bar);
        final NavHostFragment navHostFragment=(NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView,navHostFragment.getNavController());

        compose_button=findViewById(R.id.compose_button_fab_app_a);
        compose_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navHostFragment.getNavController().navigate(R.id.action_splash_to_add_new_diary);


            }
        });






    }
}
