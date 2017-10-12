package com.seyma.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewExampleActivity extends AppCompatActivity {

    private ListView userListView;
    private UsersAdapter usersAdapter;

    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);

        userList = new ArrayList<>();

        User user1 = new User();
        user1.setName("Şeyma");
        user1.setAge(23);

        User user2 = new User();
        user2.setName("Burak");
        user2.setAge(23);

        userList.add(user1);
        userList.add(user2);

        /* listview'e eristik */
        userListView= (ListView) findViewById(R.id.userListView);
        /* users adapter'i olusturduk */
        usersAdapter = new UsersAdapter(ListViewExampleActivity.this, userList);
        /* adapterle listview'i iliskilendirmek lazim */
        userListView.setAdapter(usersAdapter);
    }
}
