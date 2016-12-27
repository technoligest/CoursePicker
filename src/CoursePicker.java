/**
 * Created by Technoligest on 2016-12-19.
 */
public class CoursePicker {

    //given the id of a string, return the year.
    public static int getYear(String courseId){
        try{
            int result = Integer.parseInt(courseId.substring(0,3));
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
