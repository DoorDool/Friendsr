package com.example.dorin.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private RatingBar rating;
    private SharedPreferences.Editor editor;
    private Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        // to store which friend is clicked on
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView image = findViewById(R.id.imageView);
        // set image
        image.setImageResource(retrievedFriend.getDrawableId());
        // set text
        TextView text = findViewById(R.id.textView);
        text.setText(retrievedFriend.getName() + "\n" + "\n" + retrievedFriend.getBio());

        // set rating of friend
        rating = findViewById(R.id.ratingBar);
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        editor = prefs.edit();
        // get float of ratingBar
        float ratingFloat = prefs.getFloat(retrievedFriend.getName(), (float) 0.0);
        rating.setRating(ratingFloat);

        // if click on ratingBar new ratingFloat
        rating.setOnRatingBarChangeListener(new RatingBarChangeListener());
    }

    private class RatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            // save float
            editor.putFloat(retrievedFriend.getName(), v);
            editor.apply();
            // set rating
            retrievedFriend.setRating(v);

        }
    }

}
