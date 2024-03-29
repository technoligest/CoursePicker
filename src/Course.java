import java.util.ArrayList;

public class Course {
    private ArrayList<Section> sections;
    private ArrayList<String> prereq;
    private String subject;
    private String courseNumber;

    public Course(String subject, String courseNumber) {
        this.subject = subject;
        this.courseNumber = courseNumber;
        sections = new ArrayList<Section>();
        prereq = new ArrayList<String>();
    }

    public ArrayList<String> getPrereq() {
        return prereq;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourseNumber() {
        return courseNumber;
    }
}
