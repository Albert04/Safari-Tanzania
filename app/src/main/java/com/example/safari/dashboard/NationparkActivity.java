package com.example.safari.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.safari.R;

public class NationparkActivity extends AppCompatActivity {

    TextView serengeti,mikumi,saadan,manyara;
    CardView sere;
    private WebView wv1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nationpark);
        serengeti = findViewById(R.id.sere_national_park);
        mikumi = findViewById(R.id.mikum_national_park);
        saadan = findViewById(R.id.sada_national_park);
        manyara = findViewById(R.id.manyar_national_park);






        serengeti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_web_view);

                wv1 = findViewById(R.id.webView);
                WebSettings webSettings = wv1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wv1.loadUrl("https://www.serengeti.com/");
               // startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });

        mikumi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_web_view);

                wv1 = findViewById(R.id.webView);
                WebSettings webSettings = wv1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wv1.loadUrl("https://www.mikuminationalpark.net/");
                // startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });

        saadan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_web_view);

                wv1 = findViewById(R.id.webView);
                WebSettings webSettings = wv1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wv1.loadUrl("https://www.tanzaniatourism.go.tz/en/destination/saadani-national-park");
                // startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });

        manyara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_web_view);

                wv1 = findViewById(R.id.webView);
                WebSettings webSettings = wv1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wv1.loadUrl("https://www.lakemanyara.net/");
                // startActivity(new Intent(getApplicationContext(), WebViewActivity.class));
            }
        });
    }
}