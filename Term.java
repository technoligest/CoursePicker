import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Technoligest on 2016-12-19.
 */
public class Term {
    private int year;
    private String id; //YYYYBB, BB=10=fall, BB=20=winter, BB=30=summer
    private ArrayList<CourseRecord> courseRecords;

    public Term(String id, int year) {
        this.id = id;
        this.year = year;
    }

    public ArrayList<CourseRecord> getCourseRecords() {
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

    public boolean canAdd(Section section) {
        try {
            for (CourseRecord record : courseRecords) {
                if (!(Integer.parseInt(record.getSection().getBeginTime()) > Integer.parseInt(section.getEndTime()) ||
                        Integer.parseInt(record.getSection().getEndTime()) < Integer.parseInt(section.getBeginTime())
                )) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
        return true;
    }

}