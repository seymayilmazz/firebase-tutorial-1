package com.seyma.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        DatabaseReference usersReference = database.getReference()
                .child("users");

        usersReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                /* yeni bir cocuk eklendiginde, bir kereye mahsus tum cocuklar icin calisir */
                Log.i(LOG_TAG, "User eklendi");
                Log.i(LOG_TAG, "datasnapshot : " + dataSnapshot);
                Log.i(LOG_TAG, "string : " + s);


                String userId = dataSnapshot.getKey();
                /* 1.yol
                String name = (String) dataSnapshot.child("name").getValue();
                long age = (long) dataSnapshot.child("age").getValue();
                */

                /* 2.yol */
                User user = dataSnapshot.getValue(User.class);

                /* 3.yol, hashmap */
                Log.i(LOG_TAG, "user id : " + userId);
                Log.i(LOG_TAG, "name : " + user.getName() + ", age : " + user.getAge());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                /* cocugun icerisinde degisiklik oldugunda */
                Log.i(LOG_TAG, "User degisitirildi");
                Log.i(LOG_TAG, "datasnapshot : " + dataSnapshot);
                Log.i(LOG_TAG, "string : " + s);

                String UserId=dataSnapshot.getKey();
                String name= (String) dataSnapshot.child("name").getValue();
                long age= (long) dataSnapshot.child("age").getValue();

                Log.i(LOG_TAG,"UserId : " + UserId);
                Log.i(LOG_TAG,"name:" + name +",age:" + age);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                /* cocuk silindiginde */
                Log.i(LOG_TAG, "User silindi");
                Log.i(LOG_TAG, "datasnapshot : " + dataSnapshot);

                String userId = dataSnapshot.getKey();
                Log.i(LOG_TAG, "deleted user id : " + userId);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
