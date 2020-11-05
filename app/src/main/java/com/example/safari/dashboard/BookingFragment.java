package com.example.safari.dashboard;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.safari.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookingFragment extends Fragment {


    private RecyclerView recyclerView;
    AdapterBooking adapter; // Create Object of the Adapter class
    // Firebase Realtime Database
    ArrayList<Booking> bookings;
    ProgressDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_booking, container, false);
        recyclerView = root.findViewById(R.id.recycler1);
        // Create a instance of the database and get
        // its reference

        recyclerView.setHasFixedSize(true);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));

        bookings = new ArrayList();


        adapter = new AdapterBooking(getContext(), bookings);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
        dialog = new ProgressDialog(getContext());
        dialog.setTitle("Loading");
        dialog.setMessage("Please wait...");
        
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Booking");
        dialog.show();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bookings.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Booking booking = postSnapshot.getValue(Booking.class);
                    bookings.add(booking);
                    Collections.reverse(bookings);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Database locked", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
        
        
        return  root;
    }
    
}