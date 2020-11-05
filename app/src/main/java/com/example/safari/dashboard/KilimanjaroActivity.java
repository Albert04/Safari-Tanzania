package com.example.safari.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.safari.R;

public class KilimanjaroActivity extends AppCompatActivity {


    TextView kilimanjaro;
    private WebView wv1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilimanjaro);

        kilimanjaro = findViewById(R.id.stone_national_park);





        kilimanjaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_web_view);

                wv1 = findViewById(R.id.webView);
                WebSettings webSettings = wv1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wv1.loadUrl("https://www.tanzaniaparks.go.tz/");
                // startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });




    }
}