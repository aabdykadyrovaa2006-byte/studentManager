
    import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class MainGUI extends JFrame {

        StudentManager manager = new StudentManager();

        JTextField nameField = new JTextField(10);
        JTextField idField = new JTextField(5);
        JTextField gradeField = new JTextField(5);

        JTextArea output = new JTextArea(15, 30);

        public MainGUI() {
            setTitle("Student Management System");
            setSize(500, 500);
            setLayout(new FlowLayout());
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            // Стиль
            getContentPane().setBackground(new Color(30, 30, 30));
            output.setBackground(Color.BLACK);
            output.setForeground(Color.GREEN);

            add(new JLabel("Name:")); add(nameField);
            add(new JLabel("ID:")); add(idField);
            add(new JLabel("Grade:")); add(gradeField);

            JButton addBtn = new JButton("Add Student");
            JButton gradeBtn = new JButton("Add Grade");
            JButton searchBtn = new JButton("Search");
            JButton deleteBtn = new JButton("Delete");
            JButton sortBtn = new JButton("Sort by GPA");

            add(addBtn);
            add(gradeBtn);
            add(searchBtn);
            add(deleteBtn);
            add(sortBtn);

            add(new JScrollPane(output));

            // 🔘 Actions

            addBtn.addActionListener(e -> {
                String name = nameField.getText();
                int id = Integer.parseInt(idField.getText());

                manager.addStudent(new Student(name, id));
                showAll();
            });

            gradeBtn.addActionListener(e -> {
                int id = Integer.parseInt(idField.getText());
                int grade = Integer.parseInt(gradeField.getText());

                Student s = manager.findStudent(id);
                if (s != null) {
                    s.addGrade(grade);
                }
                showAll();
            });

            searchBtn.addActionListener(e -> {
                int id = Integer.parseInt(idField.getText());
                Student s = manager.findStudent(id);

                output.setText("");
                if (s != null) {
                    output.append(s.toString());
                } else {
                    output.append("Not found");
                }
            });

            deleteBtn.addActionListener(e -> {
                int id = Integer.parseInt(idField.getText());
                manager.removeStudent(id);
                showAll();
            });

            sortBtn.addActionListener(e -> {
                manager.sortByGPA();
                showAll();
            });

            setVisible(true);
        }

        private void showAll() {
            output.setText("");
            for (Student s : manager.getStudents()) {
                output.append(s + "\n");
            }
        }

        public static void main(String[] args) {
            new MainGUI();
        }
    }

