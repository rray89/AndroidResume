package rray.me.androidresume;

/**
 * Created by RRay on 8/16/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import rray.me.androidresume.models.Education;
import rray.me.androidresume.util.DateUtils;

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
            case R.id.ic_save:
                //saveAndExit();
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


    //method saveAndExit: save text in text field and set corresponding values
    //Exit after that
    protected void saveAndExit(@Nullable Education education) {
        if (education == null) {
            education = new Education();
        }

        String institutionName;
        String degree;
        Date startDate;
        Date endDate;
        List<String> courses;

        institutionName = ((EditText) findViewById(R.id.et_education_edit_institution_name))
                .getText().toString();
        degree = ((EditText) findViewById(R.id.et_education_edit_degree)).getText().toString();
        startDate = DateUtils.stringToDate(
                ((EditText) findViewById(R.id.et_education_edit_start_date)).getText().toString());
        endDate = DateUtils.stringToDate(
                ((EditText) findViewById(R.id.et_education_edit_end_date)).getText().toString());
        courses = Arrays.asList( TextUtils.split(
                ((EditText) findViewById(R.id.et_education_edit_courses)).getText().toString(), "\n"
        ));

        education.setInstitutionName(institutionName);
        education.setDegree(degree);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setCourses(courses);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("education", education);
        setResult(RESULT_OK, resultIntent);

    }

}
