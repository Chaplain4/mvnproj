package homework.list.task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private List<Student> students;
    private Lecturer teacher;
    private String subject;
    private HashMap<Student, Double> studentGrades;
    private int courseNum;

    public HashMap<Student, Double> getStudentGrades() {
        return studentGrades;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Lecturer getTeacher() {
        return teacher;
    }

    public void setTeacher(Lecturer teacher) {
        teacher.getTaughtCourses().add(this.subject);
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public Course(String subject, int courseNum) {
        this.subject = subject;
        this.courseNum = courseNum;
        this.studentGrades = new HashMap<>();
        this.students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        student.getCourses().add(this.subject);
        this.studentGrades.put(student, null);
        return this.getStudents().add(student);
    }

    public boolean removeStudent(Student student) {
        student.getCourses().remove(this.subject);
        this.studentGrades.remove(student);
        return this.getStudents().remove(student);
    }

    public void getNumberOfStudents() {
        System.out.println("Number of students :" + students.size());
    }

    //Реализуйте механизм выставления отметок за дисциплину
    public void setStudentGrade(Student student, double grade) {
        studentGrades.put(student, grade);
    }
}
