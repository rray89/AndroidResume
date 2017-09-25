package rray.me.androidresume;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import rray.me.androidresume.models.BasicInfo;
import rray.me.androidresume.models.Education;
import rray.me.androidresume.models.Project;
import rray.me.androidresume.models.WorkExperience;
import rray.me.androidresume.util.DateUtils;
import rray.me.androidresume.util.ImageUtils;
import rray.me.androidresume.util.ModelUtils;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_EDIT_BASIC_INFO = 100;
    private static final int REQ_CODE_EDIT_EDUCATION = 101;
    private static final int REQ_CODE_EDIT_PROJECT = 102;
    private static final int REQ_CODE_EDIT_WORK_EXPERIENCE = 103;

    private static final String MODEL_BASIC_INFO = "basic_info";
    private static final String MODEL_EDUCATIONS = "educationList";
    private static final String MODEL_PROJECTS = "projectList";
    private static final String MODEL_WORK_EXPERIENCES = "work_experiences";

    private BasicInfo basicInfo;
    private List<Education> educationList;
    private List<WorkExperience> workExperienceList;
    private List<Project> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //fakeData();
        loadData();
        setUpUI();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQ_CODE_EDIT_BASIC_INFO:
                    BasicInfo basicInfo = data.getParcelableExtra(BasicInfoEditActivity.KEY_BASIC_INFO);
                    updateBasicInfo(basicInfo);
                    break;
//                case REQ_CODE_EDIT_EDUCATION:
//                    String educationID = data.getStringExtra(EducationEditActivity.KEY_EDUCATION_ID);
//                    if (educationID != null) {
//                        deleteEducation(educationID);
//                    } else {
//                        Education education = data.getParcelableExtra(EducationEditActivity.KEY_EDUCATION);
//                        updateEducation(education);
//                    }
//                    break;
//                case REQ_CODE_EDIT_WORK_EXPERIENCE:
//                    String workExperienceId = data.getStringExtra(WorkExperienceEditActivity.KEY_WORK_EXPERIENCE_ID);
//                    if (workExperienceId != null) {
//                        deleteWorkExperience(workExperienceId);
//                    } else {
//                        WorkExperience workExperience = data.getParcelableExtra(WorkExperienceEditActivity.KEY_WORK_EXPERIENCE);
//                        updateWorkExperience(workExperience);
//                    }
//                    break;
//                case REQ_CODE_EDIT_PROJECT:
//                    String projectId = data.getStringExtra(ProjectEditActivity.KEY_PROJECT_ID);
//                    if (projectId != null) {
//                        deleteProject(projectId);
//                    } else {
//                        Project project = data.getParcelableExtra(ProjectEditActivity.KEY_PROJECT);
//                        updateProject(project);
//                    }
//                    break;
            }
        }
    }

    //
    private void setUpUI() {
        setContentView(R.layout.activity_main);

        //activate edit education button
//        ImageButton addEducationBtn = (ImageButton) findViewById(R.id.ib_add_education_btn);
//        addEducationBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, EducationEditActivity.class);
//                startActivityForResult(intent, REQ_CODE_EDIT_EDUCATION);
//
//            }
//        });
//
//        ImageButton addWorkExperienceBtn = (ImageButton) findViewById(R.id.ib_add_work_experience_btn);
//        addWorkExperienceBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, WorkExperienceEditActivity.class);
//                startActivityForResult(intent, REQ_CODE_EDIT_WORK_EXPERIENCE);
//
//            }
//        });
//
//        ImageButton addProjectBtn = (ImageButton) findViewById(R.id.ib_add_project_btn);
//        addProjectBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ProjectEditActivity.class);
//                startActivityForResult(intent, REQ_CODE_EDIT_PROJECT);
//
//            }
//        });

        setupBasicInfoUI();
//        setupEducationsUI();
//        setupProjectsUI();
//        setupWorkExperiencesUI();
    }

    //method setupBasicInfoUI to display BasicInfo session
    private void setupBasicInfoUI() {
        String name, email, personalSite;

        name = TextUtils.isEmpty(basicInfo.getName()) ? "Your name" : basicInfo.getName();
        email = TextUtils.isEmpty(basicInfo.getEmail()) ? "Your email" : basicInfo.getEmail();
        personalSite = TextUtils.isEmpty(basicInfo.getPersonalSite())
                ? "Your personal site" : basicInfo.getPersonalSite();

        ((TextView) findViewById(R.id.tv_name)).setText(name);
        ((TextView) findViewById(R.id.tv_email)).setText(email);
        ((TextView) findViewById(R.id.tv_personal_site)).setText(personalSite);

        ImageView userPicture = (ImageView) findViewById(R.id.iv_user_picture);
        if (basicInfo.getImageUri() != null) {
            ImageUtils.loadImage(this, basicInfo.getImageUri(), userPicture);
        } else {
            userPicture.setImageResource(R.drawable.ic_account_circle_black_48dp);
        }

        findViewById(R.id.ib_edit_basic_info_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BasicInfoEditActivity.class);
                intent.putExtra(BasicInfoEditActivity.KEY_BASIC_INFO, basicInfo);
                startActivityForResult(intent, REQ_CODE_EDIT_BASIC_INFO);
            }
        });
    }

    //method setupEducation to display Educations session
//    private void setupEducationsUI() {
//
//        LinearLayout educationLayout = (LinearLayout) findViewById(R.id.ll_education_list);
//        educationLayout.removeAllViews();
//        for (Education education: educationList) {
//            View educationView = getLayoutInflater().inflate(R.layout.education_item, null);
//            setupEducationView(educationView, education);
//            educationLayout.addView(educationView);
//        }
//
//    }

    //method setupEducationView
//    private void setupEducationView(View educationView, final Education education) {
//
//        ((TextView) educationView.findViewById(R.id.tv_education_institution_name))
//                .setText(education.getInstitutionName());
//        ((TextView) educationView.findViewById(R.id.tv_education_degree))
//                .setText(education.getDegree());
//
//        String dateString = DateUtils.dateToString(education.getStartDate())
//                + " - " +DateUtils.dateToString(education.getEndDate());
//
//        ((TextView) educationView.findViewById(R.id.tv_education_school_start_end_date))
//                .setText(dateString);
//        ((TextView) educationView.findViewById(R.id.tv_education_courses))
//                .setText(bulletFormatString(education.getCourses()));
//
//        ImageButton editEducation = (ImageButton) educationView.findViewById(R.id.ib_edit_education_item_btn);
//        editEducation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, EducationEditActivity.class);
//                intent.putExtra(EducationEditActivity.KEY_EDUCATION, education);
//                startActivityForResult(intent, REQ_CODE_EDIT_EDUCATION);
//            }
//        });
//    }

    //method setupWorkExperiencesUI to display Work Experiences session
//    private void setupWorkExperiencesUI() {
//        LinearLayout workExperienceLayout = (LinearLayout) findViewById(R.id.ll_work_experience_list);
//        workExperienceLayout.removeAllViews();
//        for (WorkExperience w: workExperienceList) {
//            View workExperienceView = getLayoutInflater().inflate(R.layout.work_experience_item, null);
//            setupWorkExperienceView(workExperienceView, w);
//            workExperienceLayout.addView(workExperienceView);
//        }
//    }

    //
//    private void setupWorkExperienceView(View workExperienceView, final WorkExperience workExperience) {
//
//        ((TextView) workExperienceView.findViewById(R.id.tv_work_experience_company_name))
//                .setText(workExperience.getCompanyName());
//        ((TextView) workExperienceView.findViewById(R.id.tv_work_experience_job_title))
//                .setText(workExperience.getJobTitle());
//
//        String dateString = DateUtils.dateToString(workExperience.getStartDate())
//                + " - " +DateUtils.dateToString(workExperience.getEndDate());
//
//        ((TextView) workExperienceView.findViewById(R.id.tv_work_experience_job_start_end_date))
//                .setText(dateString);
//        ((TextView) workExperienceView.findViewById(R.id.tv_work_experience_job_description))
//                .setText(bulletFormatString(workExperience.getJobDescription()));
//
//        ImageButton editEducation = (ImageButton) workExperienceView.findViewById(R.id.ib_edit_work_experience_item_btn);
//        editEducation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, WorkExperienceEditActivity.class);
//                intent.putExtra(WorkExperienceEditActivity.KEY_WORK_EXPERIENCE, workExperience);
//                startActivityForResult(intent, REQ_CODE_EDIT_WORK_EXPERIENCE);
//            }
//        });
//    }


    //method setupProjectsUI
//    private void setupProjectsUI() {
//        LinearLayout projectLayout = (LinearLayout) findViewById(R.id.ll_project_list);
//        projectLayout.removeAllViews();
//        for (Project project: projectList) {
//            View projectView = getLayoutInflater().inflate(R.layout.project_item, null);
//            setupProjectView(projectView, project);
//            projectLayout.addView(projectView);
//        }
//    }

//    private void setupProjectView(@NonNull View projectView, final Project project) {
//
//        ((TextView) projectView.findViewById(R.id.tv_project_name))
//                .setText(project.getProjectName());
//        ((TextView) projectView.findViewById(R.id.tv_project_description))
//                .setText(bulletFormatString(project.getProjectDetails()));
//
//        projectView.findViewById(R.id.ib_edit_project_item_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ProjectEditActivity.class);
//                intent.putExtra(ProjectEditActivity.KEY_PROJECT, project);
//                startActivityForResult(intent, REQ_CODE_EDIT_PROJECT);
//            }
//        });
//    }

    //method fake data to create fake data for basic info, education and work experience
//    private void fakeData() {

        //fake data for basic info
//        basicInfo = new BasicInfo();
//        basicInfo.setName("Chao Wang");
//        basicInfo.setEmail("rray@hotmail.ca");
//        basicInfo.setPersonalSite("github.com/fakeAccount");
//
//        //fake data for education
//        educationList = new ArrayList<>();
//        Education e1 = new Education();
//        e1.setInstitutionName("MIT");
//        e1.setStartDate(DateUtils.stringToDate("09/2010"));
//        e1.setEndDate(DateUtils.stringToDate("05/2014"));
//        e1.setDegree("Bachelor of Computer Science");
//        List<String> e1Courses = new ArrayList<>();
//        e1Courses.add("Database");
//        e1Courses.add("Network");
//        e1Courses.add("OS");
//        e1.setCourses(e1Courses);
//
//        educationList.add(e1);
//
//        Education e2 = new Education();
//        e2.setInstitutionName("Harvard");
//        e2.setStartDate(DateUtils.stringToDate("09/2014"));
//        e2.setEndDate(DateUtils.stringToDate("05/2015"));
//        e2.setDegree("Master of Computer Science");
//        List<String> e2Courses = new ArrayList<>();
//        e2Courses.add("Adv Database");
//        e2Courses.add("Adv Network");
//        e2Courses.add("Adv OS");
//        e2.setCourses(e2Courses);
//
//        educationList.add(e2);

        //fake data for work experience
//        workExperienceList = new ArrayList<>();
//        WorkExperience w1 = new WorkExperience();
//        w1.setCompanyName("Massachusetts Institute of Technology - Faculty of Computer Science");
//        w1.setJobTitle("Teaching Assistant");
//        w1.setStartDate(DateUtils.stringToDate("09/2012"));
//        w1.setEndDate(DateUtils.stringToDate("08/2015"));
//
//        List<String> w1JobDescription = new ArrayList<>();
//        w1JobDescription.add("Hosted Q&A sessions");
//        w1JobDescription.add("Marked assignments");
//        w1JobDescription.add("Invigilated exams");
//
//        w1.setJobDescription(w1JobDescription);
//        workExperienceList.add(w1);
//
//        projectList = new ArrayList<>();
//        Project p1 = new Project();
//        p1.setProjectName("Android Developing Project");
//        p1.setStartDate(DateUtils.stringToDate("10/2010"));
//        p1.setEndDate(DateUtils.stringToDate("10/2011"));
//        List<String> p1Description = new ArrayList<>();
//        p1Description.add("do something");
//        p1Description.add("something else");
//        p1Description.add("other things");
//        p1.setProjectDetails(p1Description);
//        projectList.add(p1);
//    }

    private void loadData() {
        BasicInfo savedBasicInfo = ModelUtils.read(this,
                MODEL_BASIC_INFO,
                new TypeToken<BasicInfo>(){});
        basicInfo = savedBasicInfo == null ? new BasicInfo() : savedBasicInfo;

//        List<Education> savedEducation = ModelUtils.read(this,
//                MODEL_EDUCATIONS,
//                new TypeToken<List<Education>>(){});
//        educationList = savedEducation == null ? new ArrayList<Education>() : savedEducation;
//
//        List<WorkExperience> savedWorkExperience = ModelUtils.read(this,
//                MODEL_WORK_EXPERIENCES,
//                new TypeToken<List<WorkExperience>>(){});
//        workExperienceList = savedWorkExperience == null ? new ArrayList<WorkExperience>() : savedWorkExperience;
//
//        List<Project> savedProjects = ModelUtils.read(this,
//                MODEL_PROJECTS,
//                new TypeToken<List<Project>>(){});
//        projectList = savedProjects == null ? new ArrayList<Project>() : savedProjects;
    }

    public static String bulletFormatString (List<String> strings) {

        StringBuilder sb = new StringBuilder();
        for (String string: strings) {
            sb.append('\t').append('-').append(' ').append(string).append('\n');
        }
        return sb.toString();

    }

    private void updateBasicInfo(BasicInfo basicInfo) {
        ModelUtils.save(this, MODEL_BASIC_INFO, basicInfo);

        this.basicInfo = basicInfo;
        setupBasicInfoUI();
    }

//    private void updateEducation(Education education) {
//        boolean found = false;
//        for (int i = 0; i < educationList.size(); i++) {
//            Education e = educationList.get(i);
//            if (TextUtils.equals(e.getId(), education.getId())) {
//                found = true;
//                educationList.set(i, education);
//                break;
//            }
//        }
//
//        if (!found) {
//            educationList.add(education);
//        }
//
//        ModelUtils.save(this, MODEL_EDUCATIONS, educationList);
//        setupEducationsUI();
//    }

//    private void updateWorkExperience(WorkExperience workExperience) {
//        boolean found = false;
//        for (int i = 0; i < workExperienceList.size(); i++) {
//            WorkExperience w = workExperienceList.get(i);
//            if (TextUtils.equals(w.getId(), workExperience.getId())) {
//                found = true;
//                workExperienceList.set(i, workExperience);
//                break;
//            }
//        }
//
//        if (!found) {
//            workExperienceList.add(workExperience);
//        }
//
//        ModelUtils.save(this, MODEL_WORK_EXPERIENCES, workExperienceList);
//        setupWorkExperiencesUI();
//    }

//    private void updateProject(Project project) {
//        boolean found = false;
//        for (int i = 0; i < projectList.size(); i++) {
//            Project p = projectList.get(i);
//            if (TextUtils.equals(p.getId(), project.getId())) {
//                found = true;
//                projectList.set(i, project);
//                break;
//            }
//        }
//
//        if (!found) {
//            projectList.add(project);
//        }
//
//        ModelUtils.save(this, MODEL_PROJECTS, projectList);
//        setupProjectsUI();
//    }


//    private void deleteEducation(@NonNull String educationID) {
//        for (int i = 0; i < educationList.size(); i++) {
//            Education e = educationList.get(i);
//            if (TextUtils.equals(e.getId(), educationID)) {
//                educationList.remove(i);
//                break;
//            }
//        }
//
//        ModelUtils.save(this, MODEL_EDUCATIONS, educationList);
//        setupEducationsUI();
//    }

//    private void deleteWorkExperience(@NonNull String workExperienceID) {
//        for (int i = 0; i < workExperienceList.size(); i++) {
//            WorkExperience w = workExperienceList.get(i);
//            if (TextUtils.equals(w.getId(), workExperienceID)) {
//                workExperienceList.remove(i);
//                break;
//            }
//        }
//
//        ModelUtils.save(this, MODEL_WORK_EXPERIENCES, workExperienceList);
//        setupWorkExperiencesUI();
//    }

//    private void deleteProject(@NonNull String projectID) {
//        for (int i = 0; i < projectList.size(); i++) {
//            Project p = projectList.get(i);
//            if (TextUtils.equals(p.getId(), projectID)) {
//                projectList.remove(i);
//                break;
//            }
//        }
//
//        ModelUtils.save(this, MODEL_PROJECTS, projectList);
//        setupProjectsUI();
//    }
}
