package homework.list.task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Student implements Person {
    private String name;
    private String emailAddress;
    private List<String> Courses;
    private int courseNum;

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<String> getCourses() {
        return Courses;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    public Student(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.courseNum = 1;
        this.setCourses(new ArrayList<>());
    }
}
