import java.util.ArrayList;

/**
 * Created by Technoligest on 2016-12-20.
 */
public class CourseNode {
    String courseId;
    CourseNode parent;
    ArrayList<CourseNode> children;
    public CourseNode(String courseId){
        this.courseId=courseId;
    }

    public CourseNode getParent() {
        return parent;
    }

    public void setParent(CourseNode parent) {
        this.parent = parent;
    }

    public ArrayList<CourseNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<CourseNode> children) {
        this.children = children;
    }
}
