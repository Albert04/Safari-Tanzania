package com.example.safari.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.safari.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import static java.security.AccessController.getContext;

public class BookingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText fisrtName,lastName, date;
    ProgressDialog dialog;
    DatePickerDialog datePickerDialog;;
    Button btnbooking;
    // Create an ArrayAdapter using the string array and a default spinner

    String[] roomNames = new String[] { "Presidential Suite ", "Family Suite", "Single Suite","Standard Room " };
    float v= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Spinner spinner = (Spinner) findViewById(R.id.roomType);

        fisrtName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        date = (EditText) findViewById(R.id.bookingDate);
        btnbooking = findViewById(R.id.hotelBook);


        //Getting the instance of Spinner and applying OnItemSelectedListener on it

        spinner.setOnItemSelectedListener(this);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),roomNames);
        spinner.setAdapter(customAdapter);



        //dialog box

        dialog = new ProgressDialog(this);
        dialog.setTitle("Processing");
        dialog.setMessage("Please wait...");

        //Animation
        fisrtName.setTranslationY(300);
        lastName.setTranslationY(300);
        spinner.setTranslationY(300);

        btnbooking.setTranslationY(300);


        fisrtName.setAlpha(v);
        lastName.setAlpha(v);
        spinner.setAlpha(v);

        btnbooking.setAlpha(v);


        fisrtName.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(500).start();
        lastName.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(700).start();
        spinner.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();

        btnbooking.animate().translationY(0).setDuration(800).alpha(1).setStartDelay(500).start();






//        //Performing action onItemSelected and onNothing selected
//        @Override
//        public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
//            Toast.makeText(getApplicationContext(), roomNames[position], Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg0) {
//            // TODO Auto-generated method stub
//        }


        //Datepicker process

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(BookingActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"+ (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        //booking  Process

        btnbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start by receiving data from the user
                String firstname, lastname, phone, bookingDate1,dates, hotelrooms;
                firstname = fisrtName.getText().toString();
                lastname = lastName.getText().toString();
                hotelrooms = spinner.getContext().toString();
                dates = date.getText().toString();


//ok
                if (firstname.isEmpty()){
                    fisrtName.setError("Please enter first name");
                }else if (lastname.isEmpty()){
                    lastName.setError("Please enter last name");

                }else if (dates.isEmpty()){
                    date.setError("Please enter date");
                }else {
                    //Connect to our database table/Child
                    long time = System.currentTimeMillis();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Booking/"+time);
                    Booking booking = new Booking (firstname+"",lastname+"","Excecutive Lounge",hotelrooms+"",dates+"",String.valueOf(time));
                    dialog.show();
                    ref.setValue(booking).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override

                        // ipo i dont have audio, hotelname,
                        // sorry, labda jaribu kuiondoa tuone kama itafanya kazi
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                                message("SUCCESS","Booking successful");
                                clear();
                            }else {
                                message("FAILED!!","Booking failed");
                            }
                        }
                    });

                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> agr0, View agr1, int position, long id) {
        Toast.makeText(getApplicationContext(), roomNames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void message(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    public void clear(){
        fisrtName.setText("");
        lastName.setText("");
        date.setText("");
    }
}