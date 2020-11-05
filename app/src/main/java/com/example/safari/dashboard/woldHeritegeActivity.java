package com.example.safari.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.safari.R;

public class woldHeritegeActivity extends AppCompatActivity {

    private WebView wv1 = null;
    TextView stoneTown, selous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wold_heritege);

        stoneTown = findViewById(R.id.stone_national_park);
        selous = findViewById(R.id.selous_national_park);






        stoneTown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_web_view);

                wv1 = findViewById(R.id.webView);
                WebSettings webSettings = wv1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wv1.loadUrl("https://www.afar.com/places/stone-town-zanzibar-town");
                // startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });

        selous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_web_view);

                wv1 = findViewById(R.id.webView);
                WebSettings webSettings = wv1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wv1.loadUrl("https://www.selousgamereserve.net/");
                // startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });


    }
}