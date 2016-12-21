import java.util.HashMap;

/**
 * Created by Technoligest on 2016-12-17.
 */
public class University {

    private String name;
    private HashMap<String, Degree> degrees;
    private TimeTable timeTable;
    public University(String name, HashMap<String, Degree>degrees, TimeTable timeTable){
        this.name=name;
        this.degrees=degrees;
        this.timeTable=timeTable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(HashMap<String, Degree> degrees) {
        this.degrees = degrees;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }
}
