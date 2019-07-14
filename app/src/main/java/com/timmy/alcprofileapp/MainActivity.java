package com.timmy.alcprofileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonActions();
    }

    public void buttonActions(){
        Button profile_btn=  findViewById(R.id.my_profile);
        Button about_btn=  findViewById(R.id.about_alc);
        profile_btn.setOnClickListener(v -> {
            Intent profileIntent = new Intent(this, ProfileActivity.class);
            if (profileIntent.resolveActivity(this.getPackageManager()) != null) {
                this.startActivity(profileIntent);
            }
        });
        about_btn.setOnClickListener((v)-> {
            Intent aboutIntent = new Intent(this,AboutActivity.class);
            if(aboutIntent.resolveActivity(getPackageManager()) != null){
                startActivity(aboutIntent);
            }

        });
    }
}
