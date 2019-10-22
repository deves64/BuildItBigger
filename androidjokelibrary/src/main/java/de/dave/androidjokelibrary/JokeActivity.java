package de.dave.androidjokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String RANDOM_JOKE_KEY = "random.joke.key";

    static String RANDOM_JOKE = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();

        if (!intent.hasExtra(RANDOM_JOKE_KEY)) {

        }

        RANDOM_JOKE = intent.getStringExtra(RANDOM_JOKE_KEY);

        TextView jokeTextView = findViewById(R.id.jokeTextView);
        jokeTextView.setText(RANDOM_JOKE);
    }
}
