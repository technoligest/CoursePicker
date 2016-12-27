import java.util.ArrayList;

/**
 * Created by Technoligest on 2016-12-20.
 * CourseNode is a way of representing a course in order to contruct a tree for the
 * courses that are needed in order to complete a degree.
 * This helps us model them so only courses that already have fulfilled prerequisites can be taken
 * The parent of every node is a prerequisite of that course.
 */
public class CourseNode {
    String courseId;
    ArrayList<CourseNode> parents;
    ArrayList<CourseNode> children;
    public CourseNode(String courseId){
        this.courseId=courseId;
    }

    public String getCourseId(){
        return courseId;
    }

    public void addParent(CourseNode parent){
        boolean found=false;
        for(CourseNode p:parents){
            if(p.getCourseId()==parent.getCourseId()){
                found=true;
                break;
            }
        }
        if(!found){
            parents.add(parent);
        }
    }
    public void addChild(CourseNode child){
        boolean found=false;
        for(CourseNode c:children){
            if(c.getCourseId()==child.getCourseId()){
                found=true;
                break;
            }
        }
        if(!found){
            children.add(child);
        }
    }

    public ArrayList<CourseNode> getParents() {
        return parents;
    }

    public void setParents(ArrayList<CourseNode> parents) {
        this.parents = parents;
    }

    public ArrayList<CourseNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<CourseNode> children) {
        this.children = children;
    }
}
