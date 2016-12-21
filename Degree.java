import java.util.ArrayList;

public class Degree {
	
	private String name;
	private ArrayList<String> mandatory;
	private ArrayList<ArrayList<Course>> options;
	private ArrayList<Course> special;
	private ArrayList<Course> elective;
	public Degree(String name, ArrayList<String> mandatory){
		this.name=name;
		this.mandatory=mandatory;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getMandatory() {
        return mandatory;
    }

    public void setMandatory(ArrayList<String> mandatory) {
        this.mandatory = mandatory;
    }

    public ArrayList<ArrayList<Course>> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<ArrayList<Course>> options) {
        this.options = options;
    }

    public ArrayList<Course> getSpecial() {
        return special;
    }

    public void setSpecial(ArrayList<Course> special) {
        this.special = special;
    }

    public ArrayList<Course> getElective() {
        return elective;
    }

    public void setElective(ArrayList<Course> elective) {
        this.elective = elective;
    }
}
