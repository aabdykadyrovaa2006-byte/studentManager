import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void sortByGPA() {
        students.sort(Comparator.comparingDouble(Student::getGPA).reversed());
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}