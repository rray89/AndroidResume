package rray.me.androidresume;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import rray.me.androidresume.models.BasicInfo;
import rray.me.androidresume.models.Education;
import rray.me.androidresume.models.Project;
import rray.me.androidresume.models.WorkExperience;
import rray.me.androidresume.util.DateUtils;

public class MainActivity extends AppCompatActivity {

    static final int REQ_CODE_EDUCATION_EDIT = 100;

    private BasicInfo basicInfo;
    private List<Education> educations;
    private List<WorkExperience> workExperiences;
    private List<Project> projects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fakeData();
        setUpUI();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_OK && requestCode == REQ_CODE_EDUCATION_EDIT) {
            Education newEducation = data.getParcelableExtra(EducationEditActivity.KEY_EDUCATION);
            educations.add(newEducation);
            setupEducationsUI();
        }
    }

    //
    private void setUpUI() {
        setupBasicInfoUI();
        setupEducationsUI();

        //activate edit education button
        ImageButton addEducationButton = (ImageButton) findViewById(R.id.ib_add_education_btn);
        addEducationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EducationEditActivity.class);
                startActivityForResult(intent, REQ_CODE_EDUCATION_EDIT);
                //startActivity(indent);
            }
        });

        setupProjectsUI();
        setupWorkExperiencesUI();
    }

    //method setupBasicInfoUI to display BasicInfo session
    private void setupBasicInfoUI() {
        ((TextView) findViewById(R.id.tv_name)).setText(basicInfo.getName());
        ((TextView) findViewById(R.id.tv_address)).setText(basicInfo.getAddress());
        ((TextView) findViewById(R.id.tv_email)).setText(basicInfo.getEmail());
        ((TextView) findViewById(R.id.tv_personal_site)).setText(basicInfo.getGithub());
        ((TextView) findViewById(R.id.tv_phone_number)).setText(basicInfo.getPhoneNumber());
    }

    //method setupEducation to display Educations session
    private void setupEducationsUI() {

        LinearLayout educationLayout = (LinearLayout) findViewById(R.id.ll_education_list);
        educationLayout.removeAllViews();
        for (Education education: educations) {
            View educationView = getLayoutInflater().inflate(R.layout.education_item, null);
            setupEducationView(educationView, education);
            educationLayout.addView(educationView);
        }

    }

    //method setupEducationView
    private void setupEducationView(View educationView, @Nullable Education education) {

        ((TextView) educationView.findViewById(R.id.tv_institution_name))
                .setText(education.getInstitutionName());
        ((TextView) educationView.findViewById(R.id.tv_education_degree))
                .setText(education.getDegree());

        String dateString = DateUtils.dateToString(education.getStartDate())
                + " - " +DateUtils.dateToString(education.getEndDate());

        ((TextView) educationView.findViewById(R.id.tv_school_start_end_date))
                .setText(dateString);
        ((TextView) educationView.findViewById(R.id.tv_education_courses))
                .setText(bulletFormatString(education.getCourses()));

        //view.findViewById(R.id.)

        //return view;

    }

    //method setupWorkExperiencesUI to display Work Experiences session
    private void setupWorkExperiencesUI() {
        LinearLayout educationLayout = (LinearLayout) findViewById(R.id.ll_work_experience_list);

        for (WorkExperience workExperience: workExperiences) {
            educationLayout.addView(getWorkExperienceView(workExperience));
        }
    }

    //Helper method getWorkExperienceView
    private View getWorkExperienceView(WorkExperience workExperience) {
        View view = getLayoutInflater().inflate(R.layout.work_experience_item, null);
        ((TextView) view.findViewById(R.id.tv_company_name))
                .setText(workExperience.getCompanyName());
        ((TextView) view.findViewById(R.id.tv_job_title))
                .setText(workExperience.getJobTitle());

        String dateString = DateUtils.dateToString(workExperience.getStartDate())
                + " - " + DateUtils.dateToString(workExperience.getEndDate());
        ((TextView) view.findViewById(R.id.tv_job_start_end_date))
                .setText(dateString);
        ((TextView) view.findViewById(R.id.tv_job_description))
                .setText(bulletFormatString(workExperience.getJobDescription()));

        return view;
    }

    //method setupProjectsUI
    private void setupProjectsUI() {
        LinearLayout educationLayout = (LinearLayout) findViewById(R.id.ll_project_list);

        for (Project project: projects) {
            educationLayout.addView(getProjectView(project));
        }


    }

    //Helper method
    private View getProjectView(Project project) {

        View view = getLayoutInflater().inflate(R.layout.project_item, null);

        ((TextView) view.findViewById(R.id.tv_project_name))
                .setText(project.getProject_name());

        String dateString = DateUtils.dateToString(project.getStartDate())
                + " - " + DateUtils.dateToString(project.getEndDate());
        ((TextView) view.findViewById(R.id.tv_project_start_end_date)).setText(dateString);

        ((TextView) view.findViewById(R.id.tv_project_description))
                .setText(bulletFormatString(project.getProject_details()));

        return view;
    }

    //method fake data to create fake data for basic info, education and work experience
    private void fakeData() {

        //fake data for basic info
        basicInfo = new BasicInfo();
        basicInfo.setName("Chao Wang");
        basicInfo.setAddress("1234 Fake St");
        basicInfo.setEmail("rray@hotmail.ca");
        basicInfo.setPhoneNumber("(123) 456-7890");
        basicInfo.setGithub("github.com/fakeAccount");

        //fake data for education
        educations = new ArrayList<>();
        Education e1 = new Education();
        e1.setInstitutionName("MIT");
        e1.setStartDate(DateUtils.stringToDate("09/2010"));
        e1.setEndDate(DateUtils.stringToDate("05/2014"));
        e1.setDegree("Bachelor of Computer Science");
        List<String> e1Courses = new ArrayList<>();
        e1Courses.add("Database");
        e1Courses.add("Network");
        e1Courses.add("OS");
        e1.setCourses(e1Courses);

        educations.add(e1);
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
//        educations.add(e2);

        //fake data for work experience
        workExperiences = new ArrayList<>();
        WorkExperience w1 = new WorkExperience();
        w1.setCompanyName("Massachusetts Institute of Technology - Faculty of Computer Science");
        w1.setJobTitle("Teaching Assistant");
        w1.setStartDate(DateUtils.stringToDate("09/2012"));
        w1.setEndDate(DateUtils.stringToDate("08/2015"));

        List<String> w1JobDescription = new ArrayList<>();
        w1JobDescription.add("Hosted Q&A sessions");
        w1JobDescription.add("Marked assignments");
        w1JobDescription.add("Invigilated exams");

        w1.setJobDescription(w1JobDescription);
        workExperiences.add(w1);

        projects = new ArrayList<>();
        Project p1 = new Project();
        p1.setProject_name("Android Developing Project");
        p1.setStartDate(DateUtils.stringToDate("10/2010"));
        p1.setEndDate(DateUtils.stringToDate("10/2011"));
        List<String> p1Descrition = new ArrayList<>();
        p1Descrition.add("do something");
        p1Descrition.add("something else");
        p1Descrition.add("other things");
        p1.setProject_details(p1Descrition);
        projects.add(p1);
    }

    public static String bulletFormatString (List<String> strings) {

        StringBuilder sb = new StringBuilder();
        for (String string: strings) {
            sb.append('\t').append('-').append(' ').append(string).append('\n');
        }
        return sb.toString();

    }

}
