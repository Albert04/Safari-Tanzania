package com.example.safari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.safari.dashboard.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class NewregisterActivity extends AppCompatActivity {


    EditText userName,phone_no,Email,input_password ;
    FirebaseAuth fAuth;
  //  ProgressDialog dialog;
    ProgressBar progressBar;
    Button btn_register;
    float v = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newregister);

        Email = findViewById(R.id.input_email);
        phone_no = findViewById(R.id.input_phone);
        input_password = findViewById(R.id.input_password);
        userName = findViewById(R.id.input_username);
        btn_register = findViewById(R.id.btn_reg);
        progressBar =  findViewById(R.id.progressBar_reg);
//        //Animation
//        userName.setTranslationY(300);
//        phone_no.setTranslationY(300);
//        Email.setTranslationY(300);
//        input_password.setTranslationY(300);
//        btn_register.setTranslationY(300);
//
//
//        userName.setAlpha(v);
//        phone_no.setAlpha(v);
//        Email.setAlpha(v);
//        input_password.setAlpha(v);
//        btn_register.setAlpha(v);
//
//
//        userName.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(500).start();
//        phone_no.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(700).start();
//        Email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
//        input_password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
//        btn_register.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(500).start();
//
//        fAuth = FirebaseAuth.getInstance();
//
//        // check if the user is already login
//
//        if (fAuth.getCurrentUser() != null) {
//
//            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
//            finish();
//        }

        fAuth = FirebaseAuth.getInstance();


        //Register new user
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString().trim();
                String password = input_password.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                fAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(NewregisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(NewregisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(NewregisterActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(NewregisterActivity.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });


            }

        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
