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
        Integer IDdrawAsterix = getResources().getIdentifier("asterix", "drawable",getPackageName());
        Integer IDdrawDora = getResources().getIdentifier("dora", "drawable",getPackageName());
        Integer IDdrawSuske = getResources().getIdentifier("suske", "drawable",getPackageName());
        Integer IDdrawMickey = getResources().getIdentifier("mickeymouse", "drawable",getPackageName());
        Integer IDdrawSmurf = getResources().getIdentifier("smurf", "drawable",getPackageName());
        Integer IDdrawWiske = getResources().getIdentifier("wiske", "drawable",getPackageName());
        Integer IDdrawWoody = getResources().getIdentifier("woody", "drawable",getPackageName());
        Integer IDdrawPinkPanther = getResources().getIdentifier("pinkpanther", "drawable",getPackageName());
        Integer IDdrawGoofy = getResources().getIdentifier("goofy", "drawable",getPackageName());
        Integer IDdrawKuifje = getResources().getIdentifier("kuifje", "drawable",getPackageName());
        Friend Donald = new Friend("Donald", "Live in Duckcity.", IDdrawDonald);
        Friend Paddington = new Friend("Paddington", "I am a bear.", IDdrawPaddington);
        Friend Diddle = new Friend("Diddle", "Many people collected pictures of me.", IDdrawDiddle);
        Friend Katrien = new Friend("Katrien", "Friend of Donald Duck.", IDdrawKatrien);
        Friend Asterix = new Friend("Asterix", "Best friend of Obelix.", IDdrawAsterix);
        Friend Dora = new Friend("Dora", "I am an explorer.", IDdrawDora);
        Friend Suske = new Friend("Suske", "Wiske is my friend.", IDdrawSuske);
        Friend Mickey = new Friend("Mickey", "Is smarter than Goofy.", IDdrawMickey);
        Friend Smurf = new Friend("Smurf", "Very little person.", IDdrawSmurf);
        Friend Wiske = new Friend("Wiske", "Suske is my friend.", IDdrawWiske);
        Friend Woody = new Friend("Woody", "I am a woodpecker", IDdrawWoody);
        Friend PinkPanther = new Friend("PinkPanther", "Very still panther", IDdrawPinkPanther);
        Friend Goofy = new Friend("Goofy", "Mickey is my smart friend", IDdrawGoofy);
        Friend Kuifje = new Friend("Kuifje", "Has a dog", IDdrawKuifje);
        friends.add(Donald);
        friends.add(Paddington);
        friends.add(Diddle);
        friends.add(Katrien);
        friends.add(Asterix);
        friends.add(Dora);
        friends.add(Suske);
        friends.add(Mickey);
        friends.add(Smurf);
        friends.add(Wiske);
        friends.add(Woody);
        friends.add(PinkPanther);
        friends.add(Goofy);
        friends.add(Kuifje);

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
