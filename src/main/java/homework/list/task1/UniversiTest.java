package homework.list.task1;

import java.util.ArrayList;
import java.util.Arrays;

public class UniversiTest {
    public static void main(String[] args) {

        Course logic = new Course("Logic", 1);
        Course javaBasics = new Course("JAVA Basics", 1);
        Course math = new Course("Math", 1);
        Course computerScienceBasics = new Course("Computer Science Basics", 1);

        Course algorithms = new Course("Algorithms", 2);
        Course javaCore = new Course("JAVA core", 2);
        Course algebra = new Course("Algebra", 2);
        Course computerScience = new Course("Computer Science", 2);

        Course appliedMath = new Course("Applied Math", 3);
        Course javaEE = new Course("JAVA EE", 3);
        Course webApps = new Course("Web Apps", 3);
        Course frontEnd = new Course("Front End", 3);

        Course advancedAppliedMath = new Course("Advanced Applied Math", 4);
        Course qa = new Course("QA", 4);
        Course advancedComputerScience = new Course("Advanced Computer Science", 4);
        Course backEnd = new Course("Back End", 4);

        Course studyProject = new Course("Study Project", 5);

        University javaUniversity = new University(Arrays.asList(logic,javaBasics,math,computerScienceBasics,algorithms,
                javaCore,algebra,computerScience,appliedMath,javaEE,webApps,frontEnd,advancedAppliedMath,qa,
                advancedComputerScience,backEnd,studyProject));


        Lecturer arkady = new Lecturer("Arkady", "Arkady@gmail.com", new ArrayList<>());
        logic.setTeacher(arkady);
        algorithms.setTeacher(arkady);
        appliedMath.setTeacher(arkady);
        advancedAppliedMath.setTeacher(arkady);
        backEnd.setTeacher(arkady);
        Lecturer valentina = new Lecturer("Valentina", "Valentina@gmail.com", new ArrayList<>());
        math.setTeacher(valentina);
        algebra.setTeacher(valentina);
        qa.setTeacher(valentina);
        frontEnd.setTeacher(valentina);
        Lecturer valeriy = new Lecturer("Valeriy", "Valeriy@gmail.com", new ArrayList<>());
        javaBasics.setTeacher(valeriy);
        javaCore.setTeacher(valeriy);
        javaEE.setTeacher(valeriy);
        studyProject.setTeacher(valeriy);
        Lecturer anatoly = new Lecturer("Anatoly", "Anatoly@gmail.com", new ArrayList<>());
        computerScienceBasics.setTeacher(anatoly);
        computerScience.setTeacher(anatoly);
        advancedComputerScience.setTeacher(anatoly);
        webApps.setTeacher(anatoly);

        javaUniversity.addStudent("Ivan", "Ivan@gmail.com");
        javaUniversity.addStudent("Peter", "Peter@gmail.com");

        System.out.println(javaUniversity.getStudents(logic.getStudents(),arkady));
        System.out.println(javaUniversity.getStudents(logic.getStudents(),"Logic"));
        javaUniversity.printStudents(logic.getStudents(),1);

        logic.getStudentGrades().put(javaUniversity.getStudents().get(1),2.0);
        javaBasics.getStudentGrades().put(javaUniversity.getStudents().get(1),3.0);
        math.getStudentGrades().put(javaUniversity.getStudents().get(1),3.0);
        computerScienceBasics.getStudentGrades().put(javaUniversity.getStudents().get(1),3.0);

        logic.getStudentGrades().put(javaUniversity.getStudents().get(0),4.0);
        javaBasics.getStudentGrades().put(javaUniversity.getStudents().get(0),5.0);
        math.getStudentGrades().put(javaUniversity.getStudents().get(0),4.0);
        computerScienceBasics.getStudentGrades().put(javaUniversity.getStudents().get(0),4.0);
        for (int i = javaUniversity.getStudents().size()-1; i >= 0; i--) {
            javaUniversity.checkStudent(javaUniversity.getStudents().get(i));
        }
    }
}
