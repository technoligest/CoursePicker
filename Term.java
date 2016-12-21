import java.util.ArrayList;

/**
 * Created by Technoligest on 2016-12-19.
 */
public class Term {
    private int year;
    private String id;
    private ArrayList<CourseRecord> courseRecords;
    public Term(String id, int year){
        this.id=id;
        this.year=year;
    }
    public ArrayList<CourseRecord> getCourseRecords(){
        return courseRecords;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
