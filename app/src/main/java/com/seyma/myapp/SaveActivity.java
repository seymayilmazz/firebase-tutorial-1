package com.seyma.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SaveActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        database=FirebaseDatabase.getInstance();
        DatabaseReference userReference =database.getReference().child("users");

        /* 1. yol
        HashMap<String, Object> values = new HashMap<>();
        values.put("name", "Berkan");
        values.put("age", 22);
        userReference.child("3").setValue(values);
        */

        /* 2.yol */
        User newUser = new User();
        newUser.setName("Berkan");
        newUser.setAge(22);
        userReference.child("3").setValue(newUser);
    }
}
