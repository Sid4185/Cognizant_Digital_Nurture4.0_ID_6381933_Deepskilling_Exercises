class Student {
    private String name;
    private String id;
    private String grade;
    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    public String getName() { return name; }
    public String getId() { return id; }
    public String getGrade() { return grade; }
}

class StudentView {
    public void displayStudentDetails(Student s) {
        System.out.println(s.getName() + " - " + s.getId() + " - " + s.getGrade());
    }
}

class StudentController {
    private Student model;
    private StudentView view;
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    public void updateView() { view.displayStudentDetails(model); }
}

public class Main10 {
    public static void main(String[] args) {
        Student s = new Student("Ravi", "001", "A");
        StudentView v = new StudentView();
        StudentController c = new StudentController(s, v);
        c.updateView();
    }
}
