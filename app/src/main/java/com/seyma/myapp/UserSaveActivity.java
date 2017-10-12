package com.seyma.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UserSaveActivity extends AppCompatActivity {

    private Button   buttonKaydet;
    private EditText editTextName;
    private EditText editTextAge;

    private FirebaseDatabase database;
    private DatabaseReference userReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_save);

        database = FirebaseDatabase.getInstance();
        userReference = database.getReference().child("users");

        buttonKaydet= (Button) findViewById(R.id.ButtonKaydet);
        editTextName= (EditText) findViewById(R.id.EditTextName);
        editTextAge= (EditText) findViewById(R.id.EditTextAge);


        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int age = Integer.parseInt(editTextAge.getText().toString());

                User newUser = new User();
                newUser.setName(name);
                newUser.setAge(age);
                userReference.push().setValue(newUser);

                /* guncelleme */
                /*
                HashMap<String, Object> updateInfoMap = new HashMap<>();
                updateInfoMap.put("age", 26);
                userReference.child("2").updateChildren(updateInfoMap);
                */
            }
        });
    }
}
