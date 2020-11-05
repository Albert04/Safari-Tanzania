package com.example.safari.dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.safari.R;


public class HomeFragment extends Fragment {




    CardView hotel, restaurant,nationalPark,ConservationArea,woldHeritage, museum,culture,kili;
    RelativeLayout header;

    float v = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        hotel = root.findViewById(R.id.hotel_card);
        restaurant = root.findViewById(R.id.restaurant_card);
        nationalPark = root.findViewById(R.id.national_park_card);
        ConservationArea = root.findViewById(R.id.conservation_card);
        header = root.findViewById(R.id.header);
        woldHeritage = root.findViewById(R.id.unesco_card);
        museum = root.findViewById(R.id.museum_card);
        culture = root.findViewById(R.id.culture_card);
        kili = root.findViewById(R.id.kilimanjaro_card);




        // Onclick listener for all the card view
        nationalPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), NationparkActivity.class));
            }
        });

        ConservationArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ConsevartionActivity.class));
            }
        });

        woldHeritage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), woldHeritegeActivity.class));
            }
        });

        kili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), KilimanjaroActivity.class));
            }
        });

        museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MuseumActivity.class));
            }
        });

        culture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CultureActivity.class));
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RestaurantActivity.class));
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HotelActivity.class));
            }
        });



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

      return root;
    }

}