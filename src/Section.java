import java.util.ArrayList;

public class Section {
	
	private String term;
	private String subject;
	private String courseNumber;
	private String section;
	private String CRN;
	private String schedule;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String beginTime;
	private String endTime;
	private String building;
	private String room;
	private String max;
	private String actual;
	private String waitListCapacity;
	private String waitListCount;
	private String instructors;
	private String restrictions;
	private String signiture;
	private String crossListing;


	public Section(String[]input){
		
		term=input[0];
		subject=input[1];
		courseNumber=input[2];
		section=input[3];
		CRN=input[4];
		schedule=input[5];
		monday=input[6];
		tuesday=input[7];
		wednesday=input[8];
		thursday=input[9];
		friday=input[10];
		beginTime=input[11];
		endTime=input[12];
		building=input[13];
		room=input[14];
		max=input[15];
		actual=input[16];
		waitListCapacity=input[17];
		waitListCount=input[18];
		instructors=input[19];
		restrictions=input[20];
		signiture=input[21];
		crossListing=input[22];
		
	}
	public Section(ArrayList<String> input){
		
		term=input.get(0);
		subject=input.get(1);
		courseNumber=input.get(2);
		section=input.get(3);
		CRN=input.get(4);
		schedule=input.get(5);
		monday=input.get(6);
		tuesday=input.get(7);
		wednesday=input.get(8);
		thursday=input.get(9);
		friday=input.get(10);
		beginTime=input.get(11);
		endTime=input.get(12);
		building=input.get(13);
		room=input.get(14);
		max=input.get(15);
		actual=input.get(16);
		waitListCapacity=input.get(17);
		waitListCount=input.get(18);
		instructors=input.get(19);
		restrictions=input.get(20);
		signiture=input.get(21);
		crossListing=input.get(22);
		
	}

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCRN() {
        return CRN;
    }

    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getWaitListCapacity() {
        return waitListCapacity;
    }

    public void setWaitListCapacity(String waitListCapacity) {
        this.waitListCapacity = waitListCapacity;
    }

    public String getWaitListCount() {
        return waitListCount;
    }

    public void setWaitListCount(String waitListCount) {
        this.waitListCount = waitListCount;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getSigniture() {
        return signiture;
    }

    public void setSigniture(String signiture) {
        this.signiture = signiture;
    }

    public String getCrossListing() {
        return crossListing;
    }

    public void setCrossListing(String crossListing) {
        this.crossListing = crossListing;
    }
}
