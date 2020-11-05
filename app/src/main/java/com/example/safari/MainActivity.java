package com.example.safari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safari.dashboard.DashboardActivity;
import com.example.safari.dashboard.HomeActivity;
import com.example.safari.dashboard.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fb, google, microsoft;
    EditText txtemail, password;
    TextView forgetpass;
    Button login, btnRegister;
    ProgressBar progressBar;
    float v = 0;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtemail = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        forgetpass = findViewById(R.id.forget_pass);
        login = findViewById(R.id.btn_login1);
        btnRegister = findViewById(R.id.btn_regPage);
        progressBar = findViewById(R.id.progressBar);
        fb = findViewById(R.id.fab_facebook);
        google = findViewById(R.id.fab_google);
        microsoft = findViewById(R.id.fab_microsoft);


        fAuth = FirebaseAuth.getInstance();


//        if (fAuth.getCurrentUser() != null) {
//            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
//            finish();
//        }



        txtemail.setTranslationY(300);
        password.setTranslationY(300);
        forgetpass.setTranslationY(300);
        login.setTranslationY(300);
        btnRegister.setTranslationY(300);

        google.setTranslationY(300);
        microsoft.setTranslationY(300);
        fb.setTranslationY(300);
  //      tabLayout.setTranslationY(300);

        google.setAlpha(v);
        microsoft.setAlpha(v);
        fb.setAlpha(v);
   //     tabLayout.setAlpha(v);
        txtemail.setAlpha(v);
        password.setAlpha(v);
        forgetpass.setAlpha(v);
        login.setAlpha(v);
        btnRegister.setAlpha(v);


        txtemail.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpass.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(500).start();
        login.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(700).start();
        btnRegister.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(700).start();

        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        microsoft.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        fb.animate().translationY(0).setDuration(1000).alpha(1).setStartDelay(800).start();
//        tabLayout.animate().translationY(0).setDuration(1000).alpha(1).setStartDelay(100).start();


        //Login button

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtemail.getText().toString();
                final String password1 = password.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password1)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Authonticate the user

                fAuth.signInWithEmailAndPassword(email, password1)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        password.setError("Authentication failed. the password is less than six");
                                    } else {
                                        Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });



            }
        });


        //Go to register page when the register button is pressed


    }

    public void register(View view) {
       // Toast.makeText(this, "Clciked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), NewregisterActivity.class));
    }
}