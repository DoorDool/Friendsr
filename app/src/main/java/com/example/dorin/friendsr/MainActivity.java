package com.example.dorin.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Integer IDdrawDonald = getResources().getIdentifier("donaldduck", "drawable",getPackageName());
        Integer IDdrawPaddington = getResources().getIdentifier("beertjepaddington", "drawable",getPackageName());
        Integer IDdrawDiddle = getResources().getIdentifier("diddle", "drawable",getPackageName());
        Integer IDdrawKatrien = getResources().getIdentifier("katrienduck", "drawable",getPackageName());
        Friend Donald = new Friend("Donald", "Live in Duckcity.", IDdrawDonald);
        Friend Paddington = new Friend("Paddington", "I am a bear.", IDdrawPaddington);
        Friend Diddle = new Friend("Diddle", "Many people collected pictures of me.", IDdrawDiddle);
        Friend Katrien = new Friend("Katrien", "Friend of Donald Duck.", IDdrawKatrien);
        friends.add(Donald);
        friends.add(Paddington);
        friends.add(Diddle);
        friends.add(Katrien);

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);

        }
    }

}
