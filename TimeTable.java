import java.util.EmptyStackException;
import java.util.HashMap;
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
		else
			throw new EmptyStackException();
	}
	public Course getCourse(String id){
		return courses.get(id);
	}
}
