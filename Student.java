import java.util.ArrayList;
import java.util.Calendar;

public class Student {
    private static University university;
    private String name;
    private String id;
    private ArrayList<Term> terms;
    private ArrayList<String> untakenRequiredCourses;
    private String programId;
    private String minor;

    public Student(String name, String id, String programId, ArrayList<CourseRecord> takenCourses) {
        this.name = name;
        this.id = id;
        this.programId = programId;
        untakenRequiredCourses = new ArrayList<>();
        addTakenCourses(takenCourses);
        calcUntakenRequiredCourses();
        calcAllTerms();
        //here we also need to calculate the program requirements
    }

    //This term is supposed to calculate the terms to finish the entire program
    public void calcAllTerms(){

    }

    public boolean readyToGraduate(ArrayList<Term> terms){
        ArrayList<String> courses = new ArrayList<String>();
        if(!courses.addAll(university.getDegrees().get(programId).getMandatory())){
            System.out.println("Degree cannot be empty.")
            return false;
        }

        for (Term t : terms) {
            for (CourseRecord k : t.getCourseRecords()) {
                int temp = courses.indexOf(k.getCourseId());
                if (temp >= 0) {
                    courses.remove(temp);
                }
            }
        }
        return courses.size()==0;
    }
    public boolean readyToGraduate() {

        ArrayList<String> courses = new ArrayList<String>();
        if(!courses.addAll(university.getDegrees().get(programId).getMandatory())){
            System.out.println("Degree cannot be empty.")
            return false;
        }

        for (Term t : terms) {
            for (CourseRecord k : t.getCourseRecords()) {
                int temp = courses.indexOf(k.getCourseId());
                if (temp >= 0) {
                    courses.remove(temp);
                }
            }
        }
        return courses.size()==0;
    }

    private void calcUntakenRequiredCourses() {
        untakenRequiredCourses.addAll(university.getDegrees().get(programId).getMandatory());
    }

    private void addTakenCourses(ArrayList<CourseRecord> arr) {
        for (CourseRecord i : arr) {
            boolean foundTerm = false;
            for (Term term : terms) {
                if (term.getId().equals(i.getTermId())) {
                    term.getCourseRecords().add(i);
                    foundTerm = true;
                    break;
                }
            }
            if (!foundTerm) {
                continue;
            }
            int temp = CoursePicker.getYear(i.getCourseId());
            if (temp > Calendar.getInstance().get(Calendar.YEAR)) {
                System.out.println("ERROR. Taken course cannot be in the future.");
                continue;
            } else if (temp < 0) {
                System.out.println("ERROR. Incorrect course id.");
                continue;
            }
            terms.add(new Term(i.getTermId(), temp));
        }
    }

    public static University getUniversity() {
        return university;
    }

    public static void setUniversity(University university) {
        Student.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getRequiredCourses() {
        return untakenRequiredCourses;
    }

    public void setRequiredCourses(ArrayList<String> untakenRequiredCourses) {
        this.untakenRequiredCourses = untakenRequiredCourses;
    }

    public String getProgram() {
        return programId;
    }

    public void setProgram(String program) {
        this.programId = program;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String toString() {
        return name + "\n" + id + "\n" + programId;

    }
}
