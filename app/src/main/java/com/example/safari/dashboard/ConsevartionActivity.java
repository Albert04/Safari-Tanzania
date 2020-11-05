package com.example.safari.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.safari.R;

public class ConsevartionActivity extends AppCompatActivity {

TextView ngorongoro, caves;
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consevartion);

        ngorongoro = findViewById(R.id.ngoto_national_park);
        caves = findViewById(R.id.cave_national_park);







        ngorongoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_web_view);

                wv1 = findViewById(R.id.webView);
                WebSettings webSettings = wv1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wv1.loadUrl("https://www.ngorongorocrater.org/");
                // startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });

        caves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_web_view);

                wv1 = findViewById(R.id.webView);
                WebSettings webSettings = wv1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wv1.loadUrl("http://www.tangatimes.co.tz/");
                // startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });


    }
}