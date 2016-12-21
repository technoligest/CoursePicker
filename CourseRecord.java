/**
 * Created by Technoligest on 2016-12-19.
 */
public class CourseRecord {
    String termId;
    String courseId;
    String grade;
    public CourseRecord(String courseId){
        this.courseId=courseId;
    }
    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
