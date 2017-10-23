
/*
 *
 *
 *
 */

package rray.me.androidresume;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import rray.me.androidresume.models.Education;
import rray.me.androidresume.util.DateUtils;

public class EducationEditActivity extends EditBaseActivity<Education>{

    public static final String KEY_EDUCATION = "education";
    public static final String KEY_EDUCATION_ID = "education_id";


    @Override
    protected int getLayoutId() {
        return R.layout.activity_education_edit;
    }

    //set DELETE button invisible when create a new Education experience
    @Override
    protected void setupUIForCreate() {
        findViewById(R.id.tv_education_edit_delete).setVisibility(View.GONE);
    }

    @Override
    protected void setupUIForEdit(@NonNull final Education education) {

        ((EditText) findViewById(R.id.et_education_edit_institution_name))
                .setText(education.getInstitutionName());
        ((EditText) findViewById(R.id.et_education_edit_degree)).setText(education.getDegree());
        ((EditText) findViewById(R.id.et_education_edit_start_date))
                .setText(DateUtils.dateToString(education.getStartDate()));
        ((EditText) findViewById(R.id.et_education_edit_end_date))
                .setText(DateUtils.dateToString(education.getEndDate()));
        ((EditText) findViewById(R.id.et_education_edit_courses))
                .setText(TextUtils.join("\n", education.getCourses()));

        findViewById(R.id.tv_education_edit_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_EDUCATION_ID, education.getId());
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }


    //method saveAndExit: save text in text field and set corresponding values
    protected void saveAndExit(@Nullable Education education) {
        if (education == null) {
            education = new Education();
        }

        //String institutionName ;
        //String degree ;
        //Date startDate;
        //Date endDate;
        //List<String> courses;

        String institutionName = ((EditText) findViewById(R.id.et_education_edit_institution_name))
                .getText().toString();
        String degree = ((EditText) findViewById(R.id.et_education_edit_degree)).getText().toString();
        Date startDate = DateUtils.stringToDate(
                ((EditText) findViewById(R.id.et_education_edit_start_date)).getText().toString());
        Date endDate = DateUtils.stringToDate(
                ((EditText) findViewById(R.id.et_education_edit_end_date)).getText().toString());
        List<String> courses = Arrays.asList(TextUtils.split(
                ((EditText) findViewById(R.id.et_education_edit_courses)).getText().toString(), "\n"
        ));

        education.setInstitutionName(institutionName);
        education.setDegree(degree);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setCourses(courses);

        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_EDUCATION, education);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected Education initializeData() {
        return getIntent().getParcelableExtra(KEY_EDUCATION);
    }

}
