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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.safari.dashboard.DashboardActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterFragment extends Fragment {


    EditText userName,phone_no,email,password ;
    FirebaseAuth fAuth;

    Button btn_register;
    float v = 0;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.register_tab_fragment,container,false);

        email = root.findViewById(R.id.input_email);
        phone_no = root.findViewById(R.id.input_phone);
        password = root.findViewById(R.id.input_password);
        userName = root.findViewById(R.id.input_username);
        btn_register = root.findViewById(R.id.btn_reg);



        userName.setTranslationY(300);
        phone_no.setTranslationY(300);
        email.setTranslationY(300);
        password.setTranslationY(300);
        btn_register.setTranslationY(300);


        userName.setAlpha(v);
        phone_no.setAlpha(v);
        email.setAlpha(v);
        password.setAlpha(v);
        btn_register.setAlpha(v);


        userName.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(500).start();
        phone_no.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(700).start();
        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        btn_register.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(500).start();

        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null) {

            startActivity(new Intent(getContext(), DashboardActivity.class));
            //finish();
        }


        //Register new user
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String user = userName.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
//
//                if (TextUtils.isEmpty(user)) {
//                    userName.setError("User name is required");
//                    return;
                 if (TextUtils.isEmpty(email1)) {
                    email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty((pass))) {
                    password.setError("Password is required");
                    return;

                }
                if(pass.length()<6){
                    password.setError("Password must be >= 6 Characters");
                }

                fAuth.createUserWithEmailAndPassword(email1, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                           // Toast.makeText(RegisterFragment.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(), DashboardActivity.class));

                        } else {
                           // Toast.makeText()
                        }

                        // ...
                    }
                });

            }

        });



        return root;
    }
}
