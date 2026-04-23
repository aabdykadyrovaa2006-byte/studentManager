import java.util.ArrayList;

public class Student {
    private String name;
    private int id;
    private ArrayList<Integer> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getGPA() {
        if (grades.isEmpty()) return 0;

        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }

    public String getName() { return name; }
    public int getId() { return id; }

    public String toString() {
        return name + " (ID: " + id + ") GPA: " + String.format("%.2f", getGPA());
    }
}
