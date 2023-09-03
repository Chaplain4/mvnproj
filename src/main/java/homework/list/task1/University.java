package homework.list.task1;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class University {
    private List<Course> courses;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    //Метод List printStudents(List students, int course), который получает список студентов и номер курса и печатает в
    // консоль имена тех студентов из списка, которые обучаются на данном курсе.

    /**
     * По условию задачи метод должен и печатать имена, и возвращать список.
     *
     * @param students
     * @param courseNum
     * @return
     */
    public List<Student> printStudents(List<Student> students, int courseNum) {
        for (int i = students.size() - 1; i >= 0; i--) {
            if (students.get(i).getCourseNum() != courseNum) {
                students.remove(i);
            }
        }
        for (Student s : students) {
            System.out.println(s.getName());
            System.out.println();
        }
        return students;
    }

    /**
     * метод добавляет первокурсника и записывает его на все предметы первого курса
     * @param name
     * @param email
     */
    public void addStudent(String name, String email) {
        Student student = new Student(name, email);
        this.students.add(student);
        for (Course course : this.getCourses()) {
            if (course.getCourseNum() == student.getCourseNum()) {
                course.addStudent(student);
            }
        }
    }

    /**
     * Метод переводит студента на новый курс, выписывает студента из всех предметов предыдушего курса,и записывает
     * на все предметы текущего. Если студент учился на последнем курсе, он успешно заканчивает универ.
     * @param student
     */
    private void passStudent(Student student) {
        for (Course course : courses) {
            course.removeStudent(student);
        }
        student.getCourses().clear();
        student.setCourseNum(student.getCourseNum() + 1);
        if (student.getCourseNum() > 5) {
            System.out.println("Student " + student.getName() + " has successfully graduated");
        } else {
            for (Course course : this.getCourses()) {
                if (course.getCourseNum() == student.getCourseNum()) {
                    course.addStudent(student);
                }
            }
        }
    }

    //List getStudents(List students, Lecturer lecturer ) , который получает список студентов и конкретного
    // преподавателя и возвращает только тех студентов из списка, которые обучаются у этого преподавателя.
    public List<Student> getStudents(List<Student> students, Lecturer lecturer) {
        for (int i = students.size() - 1; i >= 0; i--) {
            boolean isPresent = false;
            for (String j : students.get(i).getCourses()) {
                if (lecturer.getTaughtCourses().contains(j)) {
                    isPresent = true;
                }
            }
            if (!(isPresent)) {
                students.remove(i);
            }
        }
        return students;
    }

    //List getStudents(List students, String subject) , который получает список студентов и конкретную дисциплину
    // и возвращает только тех студентов из списка, которые изучают дисциплину.
    public List<Student> getStudents(List<Student> students, String subject) {
        for (int i = students.size() - 1; i >= 0; i--) {
            if (!(students.get(i).getCourses().contains(subject))) {
                students.remove(i);
            }
        }
        return students;
    }

    //в случае не удовлетворительных результатов на последних курсах студент должен быть отчислен.
    /**
     * Я бы выгонял студента, если бы у него по итогам любого курса есть неуд по любому из предметов.
     * Если с успеваемостью всё ок - студент зачисляется на следующий курс или успешно выпускается.
     */
    public void checkStudent(Student student) {
        boolean isExpelled = false;
        for (Course course : this.getCourses()) {
            if (course.getCourseNum() == student.getCourseNum()) {
                if (course.getStudentGrades().get(student) < 3.0) {
                    isExpelled = true;
                }
            }
        }
        if (isExpelled) {
            for (Course course : courses) {
                course.removeStudent(student);
            }
            student.getCourses().clear();
            System.out.println("Student " + student.getName() + " is expelled due to low grades!");
        } else passStudent(student);
    }

    public University() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public University(List<Course> courses) {
        this.courses = courses;
        this.students = new ArrayList<>();
    }
}
