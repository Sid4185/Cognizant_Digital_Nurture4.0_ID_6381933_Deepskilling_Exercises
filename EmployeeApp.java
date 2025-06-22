class Employee {
    String employeeId, name, position;
    double salary;

    Employee(String id, String name, String pos, double sal) {
        this.employeeId = id;
        this.name = name;
        this.position = pos;
        this.salary = sal;
    }
}

class EmployeeSystem {
    private Employee[] employees = new Employee[100];
    private int count = 0;

    public void add(Employee e) { employees[count++] = e; }

    public Employee search(String id) {
        for (int i = 0; i < count; i++)
            if (employees[i].employeeId.equals(id)) return employees[i];
        return null;
    }

    public void delete(String id) {
        for (int i = 0; i < count; i++)
            if (employees[i].employeeId.equals(id)) {
                employees[i] = employees[--count];
                break;
            }
    }

    public void show() {
        for (int i = 0; i < count; i++)
            System.out.println(employees[i].name + " " + employees[i].employeeId);
    }
}

public class EmployeeApp {
    public static void main(String[] args) {
        EmployeeSystem sys = new EmployeeSystem();
        sys.add(new Employee("E1", "Nina", "Manager", 90000));
        sys.show();
        sys.delete("E1");
    }
}
