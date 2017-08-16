package rray.me.androidresume;

/**
 * Created by RRay on 8/16/2017.
 */

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

//import rray.me.androidresume.models.Education;
//import rray.me.androidresume.util.DateUtils;

public class EducationEditActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back button
    }

    //get called when clicked on back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish(); //finish current activity
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //called when clicked on save
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_education, menu);
        return true;
    }
}
