package com.example.safari.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.safari.R;

public class DashboardActivity extends AppCompatActivity {

    CardView hotel, restaurant,nationalPark,ConservationArea,woldHeritage, museum,culture,kili;
    RelativeLayout header;

    float v = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        hotel = findViewById(R.id.hotel_card);
        restaurant = findViewById(R.id.restaurant_card);
        nationalPark = findViewById(R.id.national_park_card);
        ConservationArea = findViewById(R.id.conservation_card);
        header =findViewById(R.id.header);
        woldHeritage = findViewById(R.id.unesco_card);
        museum = findViewById(R.id.museum_card);
        culture = findViewById(R.id.culture_card);
        kili= findViewById(R.id.kilimanjaro_card);



//Animations
        nationalPark.setTranslationY(300);
        ConservationArea.setTranslationY(300);
        woldHeritage.setTranslationY(300);
        kili.setTranslationY(300);
        museum.setTranslationY(300);
        culture.setTranslationY(300);
        restaurant.setTranslationY(300);
        hotel.setTranslationY(300);



        nationalPark.setAlpha(v);
        ConservationArea.setAlpha(v);
        woldHeritage.setAlpha(v);
        //     tabLayout.setAlpha(v);
        kili.setAlpha(v);
        museum.setAlpha(v);
        culture.setAlpha(v);
        restaurant.setAlpha(v);
        hotel.setAlpha(v);


        nationalPark.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        ConservationArea.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        woldHeritage.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(500).start();
        kili.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(700).start();
        museum.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(700).start();

        culture.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        restaurant.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        hotel.animate().translationY(0).setDuration(1000).alpha(1).setStartDelay(800).start();
//        tabLayout.animate().translationY(0).setDuration(1000).alpha(1).setStartDelay(100).start();

        // Onclick listener for all the card view
        nationalPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NationparkActivity.class));
            }
        });

        ConservationArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ConsevartionActivity.class));
            }
        });

        woldHeritage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), woldHeritegeActivity.class));
            }
        });

        kili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), KilimanjaroActivity.class));
            }
        });

        museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MuseumActivity.class));
            }
        });

        culture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CultureActivity.class));
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RestaurantActivity.class));
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HotelActivity.class));
            }
        });
    }
}