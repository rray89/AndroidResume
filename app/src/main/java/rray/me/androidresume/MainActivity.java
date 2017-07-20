package rray.me.androidresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import rray.me.androidresume.models.BasicInfo;
import rray.me.androidresume.models.Education;
import rray.me.androidresume.models.WorkExperience;
import rray.me.androidresume.util.DateUtils;

public class MainActivity extends AppCompatActivity {

    private BasicInfo basicInfo;
    private List<Education> educations;
    private List<WorkExperience> workExperiences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fakeData();
        setupBasicInfoUI();
        setupEducations();
        setupWorkExperiences();
    }

    //method setupBasicInfoUI to display BasicInfo session
    private void setupBasicInfoUI() {
        ((TextView) findViewById(R.id.tv_name)).setText(basicInfo.getName());
        ((TextView) findViewById(R.id.tv_address)).setText(basicInfo.getAddress());
        ((TextView) findViewById(R.id.tv_email)).setText(basicInfo.getEmail());
        ((TextView) findViewById(R.id.tv_github)).setText(basicInfo.getGithub());
        ((TextView) findViewById(R.id.tv_phone_number)).setText(basicInfo.getPhoneNumber());
    }

    //method setupEducation to display Educations session
    private void setupEducations() {
        ((TextView) findViewById(R.id.tv_institution_name)).setText(educations.get(0).getInstitution_name());
        ((TextView) findViewById(R.id.tv_degree)).setText(educations.get(0).getDegree());
        ((TextView) findViewById(R.id.tv_school_start_end_date)).setText(formatDate(educations.get(0)));
        ((TextView) findViewById(R.id.tv_education_courses)).setText(bulletFormatString(educations.get(0).getCourses()));
    }

    //method setupWorkExperiences to display Work Experiences session
    private void setupWorkExperiences() {
        ((TextView) findViewById(R.id.tv_company_name)).setText(workExperiences.get(0).getCompanyName());
        ((TextView) findViewById(R.id.tv_job_title)).setText(workExperiences.get(0).getJobTitle());
        ((TextView) findViewById(R.id.tv_job_start_end_date)).setText(formatDate(workExperiences.get(0)));
        ((TextView) findViewById(R.id.tv_job_description)).setText(bulletFormatString(workExperiences.get(0).getJobDescription()));
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
        e1.setInstitution_name("MIT");
        e1.setStartDate(DateUtils.stringToDate("09/2010"));
        e1.setEndDate(DateUtils.stringToDate("05/2014"));
        e1.setDegree("Bachelor of Computer Science");

        List<String> e1Courses = new ArrayList<>();
        e1Courses.add("Database");
        e1Courses.add("Network");
        e1Courses.add("Operating System");

        e1.setCourses(e1Courses);

        educations.add(e1);

        //fake data for work experience
        workExperiences = new ArrayList<>();
        WorkExperience w1 = new WorkExperience();
        w1.setCompanyName("MIT - Faculty of Computer Science");
        w1.setJobTitle("Teaching Assistant");
        w1.setStartDate(DateUtils.stringToDate("09/2012"));
        w1.setEndDate(DateUtils.stringToDate("08/2015"));

        List<String> w1JobDescription = new ArrayList<>();
        w1JobDescription.add("Hosted Q&A sessions");
        w1JobDescription.add("Marked assignments");
        w1JobDescription.add("Invigilated exams");

        w1.setJobDescription(w1JobDescription);
        workExperiences.add(w1);


    }

    public static String bulletFormatString (List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (String string: strings) {
            sb.append(' ').append('-').append(' ').append(string).append('\n');
        }
        return sb.toString();
    }

    public static <T> String formatDate (T object) {
        if(object instanceof Education)
            return (DateUtils.dataToString(((Education) object).getStartDate()) + " - " + DateUtils.dataToString(((Education) object).getEndDate()));
        if(object instanceof WorkExperience)
            return (DateUtils.dataToString(((WorkExperience) object).getStartDate()) + " - " + DateUtils.dataToString(((WorkExperience) object).getEndDate()));

        return "Something wrong with date";
    }
}
