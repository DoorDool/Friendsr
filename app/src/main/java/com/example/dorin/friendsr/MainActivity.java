package com.example.dorin.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Integer IDdrawDonald = getResources().getIdentifier("Donald", "drawable","Donald Duck.png");
        Integer IDdrawPaddington = getResources().getIdentifier("Paddington", "drawable","BeertjePaddington.png");
        Integer IDdrawDiddle = getResources().getIdentifier("Diddle", "drawable","Diddle.png");
        Integer IDdrawKatrien = getResources().getIdentifier("Katrien", "drawable","KatrienDuck.png");
        Friend Donald = new Friend("Donald", "hello", IDdrawDonald);
        Friend Paddington = new Friend("Paddington", "hello", IDdrawPaddington);
        Friend Diddle = new Friend("Diddle", "hello", IDdrawDiddle);
        Friend Katrien = new Friend("Katrien", "hello", IDdrawKatrien);
        friends.add(Donald);
        friends.add(Paddington);
        friends.add(Diddle);
        friends.add(Katrien);

        FriendsAdapter adapter = new FriendsAdapter(",3,friends);

    }

}
