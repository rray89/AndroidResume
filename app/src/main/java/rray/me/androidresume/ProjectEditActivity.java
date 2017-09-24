package rray.me.androidresume;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import java.util.Arrays;
import java.util.List;
import rray.me.androidresume.models.Project;

/*
 * Created by RRay on 9/22/2017.
 */

public class ProjectEditActivity extends EditBaseActivity<Project> {

    public static final String KEY_PROJECT = "project";
    public static final String KEY_PROJECT_ID = "project_id";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_project_edit;
    }

    @Override
    protected void setupUIForCreate() {
        findViewById(R.id.tv_project_edit_delete).setVisibility(View.GONE);
    }

    @Override
    protected void setupUIForEdit(@NonNull final Project project) {
        ((EditText) findViewById(R.id.et_project_edit_project_name))
                .setText(project.getProjectName());

        ((EditText) findViewById(R.id.et_project_edit_project_details))
                .setText(TextUtils.join("\n", project.getProjectDetails()));

        findViewById(R.id.tv_project_edit_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_PROJECT_ID, project.getId());
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    @Override
    protected void saveAndExit(@Nullable Project project) {

        if (project == null) {
            project = new Project();
        }

        String projectName;
        List<String> projectDetails;

        projectName = ((EditText) findViewById(R.id.et_project_edit_project_name))
                .getText().toString();

        projectDetails = Arrays.asList( TextUtils.split(
                ((EditText) findViewById(R.id.et_project_edit_project_details)).getText().toString(), "\n"
        ));

        project.setProjectName(projectName);
        project.setProjectDetails(projectDetails);

        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_PROJECT_ID, project);
        setResult(RESULT_OK, resultIntent);
        finish();

    }

    @Override
    protected Project initializeData() {
        return getIntent().getParcelableExtra(KEY_PROJECT);
    }
}
