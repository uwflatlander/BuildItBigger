package com.testinprod.courtjester;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeDisplay extends AppCompatActivity {
    public static final String EXTRA_JOKE = JokeDisplay.class.getSimpleName() + ".JOKE";

    public static Intent buildIntent(Context context, String jokeForDisplay)
    {
        Intent intent = new Intent(context, JokeDisplay.class);
        intent.putExtra(EXTRA_JOKE, jokeForDisplay);
        return intent;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String joke = getIntent().getExtras().getString(EXTRA_JOKE);
        TextView tvJoke = (TextView) findViewById(R.id.tvJoke);
        tvJoke.setText(joke);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_joke_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
