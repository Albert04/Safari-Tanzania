package com.example.safari;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.safari.dashboard.DashboardActivity;
import com.example.safari.dashboard.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginRragment extends Fragment {

    EditText email, password;
    TextView forgetpass;
    Button login;
    float v = 0;
    FirebaseAuth fAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.input_email);
        password = root.findViewById(R.id.input_password);
        forgetpass = root.findViewById(R.id.forget_pass);
        login = root.findViewById(R.id.btn_login1);

        email.setTranslationY(300);
        password.setTranslationY(300);
        forgetpass.setTranslationY(300);
        login.setTranslationY(300);

        email.setAlpha(v);
        password.setAlpha(v);
        forgetpass.setAlpha(v);
        login.setAlpha(v);


        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpass.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(500).start();
        login.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(700).start();


        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1 = email.getText().toString().trim();
                String pass1 = password.getText().toString().trim();

                if (TextUtils.isEmpty(email1)) {
                    email.setError("User name is required");
                    return;
                }
                if (TextUtils.isEmpty((pass1))) {
                    password.setError("Password is required");
                    return;

                }

                //Authonticate the user

                fAuth.signInWithEmailAndPassword(email1, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                           // Toast.makeText(MainActivity.this, "Logged in successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(), DashboardActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.
                          //  Toast.makeText(MainActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });


            }
        });


        //Register if you don't have account
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RegisterActivity.class));
            }
        });
        return root;

    }
}

