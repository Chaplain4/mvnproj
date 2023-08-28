package collections;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    private boolean asc; // desc
    public StudentComparator (boolean asc) {
        this.asc = asc;
    }
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAvg() == o2.getAvg())
            return 0;
        else if (o1.getAvg() > o2.getAvg())
            return asc? -1 : 1;
        else return asc? 1 : -1;
    }
}
