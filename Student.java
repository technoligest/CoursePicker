import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Student {
    private static University university;
    private String name;
    private String id;
    private ArrayList<Term> terms; //The list of terms, teken or future ones.
    private ArrayList<String> untakenRequiredCourses; //the list of courses that need to be taken to fulfil a degree
    private ArrayList<String> takenCourses;
    private ArrayList<CourseNode> courseForest; //forest of courses that need to be taken
    private String programId;
    private String minorId;

    public Student(String name, String id, String programId, ArrayList<CourseRecord> takenCourses) {
        this.name = name;
        this.id = id;
        this.programId = programId;
        untakenRequiredCourses = new ArrayList();
        courseForest = new ArrayList();
        this.takenCourses = new ArrayList();
        addTakenCourses(takenCourses); //calculates both past terms and taken courses;
        calcUntakenRequiredCourses();
        calcCourseForest();
        calcAllTerms();
    }

    public void calcCourseForest() {
        HashMap<String, CourseNode> map = new HashMap(); //all nodes
        ArrayList<CourseNode> result = new ArrayList(); //only roots
        ArrayList<CourseNode> courses = new ArrayList();
        for (String id : untakenRequiredCourses) {
            courses.add(new CourseNode(id));
        }

        while (!courses.isEmpty()) {
            CourseNode currentCourseNode = courses.get(courses.size() - 1);
            courses.remove(courses.size() - 1);
            Course currentCourse = university.getTimeTable().getCourse(currentCourseNode.getCourseId());
            if (currentCourse.getPrereq().isEmpty()) {
                if (!map.containsKey(currentCourseNode.getCourseId())) {
                    map.put(currentCourseNode.getCourseId(), currentCourseNode);
                    result.add(currentCourseNode);
                }
            } else {
                for (String prerequisite : currentCourse.getPrereq()) {
                    CourseNode temp = new CourseNode(prerequisite);
                    temp.addChild(currentCourseNode);
                    currentCourseNode.addParent(temp);
                    courses.add(temp);
                }
                if (!map.containsKey(currentCourseNode.getCourseId())) {
                    map.put(currentCourseNode.getCourseId(), currentCourseNode);
                }
            }
        }


        courseForest.addAll(result);
    }

    //This term is supposed to calculate the terms to finish the entire program
    public boolean calcAllTerms() {
        ArrayList<CourseNode> courses = new ArrayList(courseForest);
        int year;
        int termNum;
        if (Calendar.getInstance().get(Calendar.MONTH) > 8) {
            year = Calendar.getInstance().get(Calendar.YEAR) + 1;
            termNum = 20;
        } else if (Calendar.getInstance().get(Calendar.MONTH) > 4) {
            year = Calendar.getInstance().get(Calendar.YEAR);
            termNum = 10;
        } else {
            year = Calendar.getInstance().get(Calendar.YEAR);
            termNum = 30;
        }

        for (int i = 0; i < 12 && !courses.isEmpty(); ++i) {
            String termId = "" + year + termNum;
            Term thisTerm = new Term(termId, year);
            for (CourseNode c : courses) {
                Course currentCourse = university.getTimeTable().getCourse(c.getCourseId());

                for(Section section: currentCourse.getSections()){
                    if(thisTerm.canAdd(section)){
                        CourseRecord record = new CourseRecord(currentCourse.getCourseNumber(), section);
                        record.setTermId(termId);
                        thisTerm.getCourseRecords().add(record);
                        break;
                    }
                }
            }

            terms.add(thisTerm);
            if ((termNum += 10) == 40)
                termNum = 10;
            if (termNum == 20)
                ++year;
        }
        return courses.isEmpty();
    }


    public boolean readyToGraduate(ArrayList<Term> terms) {
        ArrayList<String> courses = new ArrayList<String>();
        if (!courses.addAll(university.getDegrees().get(programId).getMandatory())) {
            System.out.println("Degree cannot be empty.");
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
        return courses.size() == 0;
    }

    public boolean readyToGraduate() {

        ArrayList<String> courses = new ArrayList<String>();
        if (!courses.addAll(university.getDegrees().get(programId).getMandatory())) {
            System.out.println("Degree cannot be empty.");
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
        return courses.isEmpty();
    }

    //Here we need to figure out the untaken courses.
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
        for (CourseRecord r : arr)
            takenCourses.add(r.getCourseId());
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

    public String getMinorId() {
        return minorId;
    }

    public void setMinorId(String minorId) {
        this.minorId = minorId;
    }

    public String toString() {
        return name + "\n" + id + "\n" + programId;

    }
}
