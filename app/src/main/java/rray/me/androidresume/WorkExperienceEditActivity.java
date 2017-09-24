package rray.me.androidresume;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import rray.me.androidresume.models.Education;
import rray.me.androidresume.models.WorkExperience;
import rray.me.androidresume.util.DateUtils;

public class WorkExperienceEditActivity extends EditBaseActivity<WorkExperience> {

    public static final String KEY_WORK_EXPERIENCE = "work_experience";
    public static final String KEY_WORK_EXPERIENCE_ID = "work_experience_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_experience_edit;
    }

    @Override
    protected void setupUIForCreate() {
        findViewById(R.id.tv_work_experience_edit_delete).setVisibility(View.GONE);
    }

    @Override
    protected void setupUIForEdit(@NonNull final WorkExperience workExperience) {
        ((EditText) findViewById(R.id.et_work_experience_company_name))
                .setText(workExperience.getCompanyName());
        ((EditText) findViewById(R.id.et_work_experience_job_title))
                .setText(workExperience.getJobTitle());
        ((EditText) findViewById(R.id.et_work_experience_edit_start_date))
                .setText(DateUtils.dateToString(workExperience.getStartDate()));
        ((EditText) findViewById(R.id.et_work_experience_edit_end_date))
                .setText(DateUtils.dateToString(workExperience.getEndDate()));
        ((EditText) findViewById(R.id.et_education_edit_courses))
                .setText(TextUtils.join("\n", workExperience.getJobDescription()));

        findViewById(R.id.tv_education_edit_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_WORK_EXPERIENCE, workExperience.getId());
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    @Override
    protected void saveAndExit(@Nullable WorkExperience workExperience) {
        if (workExperience == null) {
            workExperience = new WorkExperience();
        }

        String companyName;
        String jobTitle;
        Date startDate;
        Date endDate;
        List<String> jobDescription;

        companyName = ((EditText) findViewById(R.id.et_work_experience_company_name))
                .getText().toString();
        jobTitle = ((EditText) findViewById(R.id.et_work_experience_job_title))
                .getText().toString();
        startDate = DateUtils.stringToDate(((EditText) findViewById
                (R.id.et_work_experience_edit_start_date)).getText().toString());
        endDate = DateUtils.stringToDate(((EditText) findViewById
                (R.id.et_work_experience_edit_end_date)).getText().toString());
        jobDescription = Arrays.asList( TextUtils.split(((EditText) findViewById
                (R.id.et_work_experience_job_description)).getText().toString(), "\n"
        ));

        workExperience.setCompanyName(companyName);
        workExperience.setJobTitle(jobTitle);
        workExperience.setStartDate(startDate);
        workExperience.setEndDate(endDate);
        workExperience.setJobDescription(jobDescription);

        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_WORK_EXPERIENCE_ID, workExperience);
        setResult(RESULT_OK, resultIntent);
        finish();

    }

    @Override
    protected WorkExperience initializeData() {
        return null;
    }
}
