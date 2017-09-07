/*
* Abstract class EditBaseActivity<T>
* Used as base for creating EditEducationActivity, EditWorkExperienceActivity
* and EditProjectActivity.
*
*
* */

package rray.me.androidresume;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public abstract class EditBaseActivity<T> extends AppCompatActivity {

    private T data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = initialzeData();
        if(data != null) {
            setupUIForEdit(data);
        } else {
            setupUIForCreate();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish(); //finish current activity
                return true;
            case R.id.menu_save:
                saveAndExit(data);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
    protected abstract int getLayoutId();

    protected abstract void setupUIForCreate();

    protected abstract void setupUIForEdit(@NonNull T data);

    protected abstract void saveAndExit(@Nullable T data);

    protected abstract T initialzeData();
}
