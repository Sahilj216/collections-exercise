import java.util.HashMap;
import java.util.Map;

public class Answer4 {
    public static void main(String[] args) {
        Map<Employee, Integer> mp = new HashMap<>();
        Employee e1 = new Employee("Sahil", 30, "TL");
        Employee e5 = new Employee("Sahil", 30, "TL");
        Employee e2 = new Employee("Ram", 30, "TL");
        Employee e3 = new Employee("Shyam", 20, "Trainee");

        mp.put(e1, 2400000);
        mp.put(e2, 24000000);
        mp.put(e3, 3400000);
        mp.put(e5, 5400000); // e1 and e5 are equal, so value is updated

        System.out.println("Salary for e1: " + mp.get(e1)); // Output: 5400000
    }
}

class Employee {
    private String name;
    private int age;
    private String designation;

    public Employee(String name, int age, String designation) {
        this.name = name;
        this.age = age;
        this.designation = designation;
    }

    @Override
    public int hashCode() {
        int result = 31 + age;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (designation == null ? 0 : designation.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee other)) return false;
        return age == other.age &&
               name.equals(other.name) &&
               designation.equals(other.designation);
    }
}

