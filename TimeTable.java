import java.util.EmptyStackException;
import java.util.HashMap;


/*
 *TimeTable basically keeps track of all the available courses in the university
 *
 */
public class TimeTable {
	HashMap <String,Course>courses;
	TimeTable(){
		courses= new HashMap<String,Course>();
	}
	public void addSection(Section s){
		if(s!=null) {
			if (!courses.containsKey(s.getCRN())) {
                courses.put(s.getSubject()+s.getCourseNumber(), new Course(s.getSubject(), s.getCourseNumber()));
			}
			Course co=courses.get(s.getSubject()+s.getCourseNumber());
			if(co!=null) {
                co.getSections().add(s);
            }
		}
	}
	public Course getCourse(String id){
	    return courses.get(id);
	}
}
