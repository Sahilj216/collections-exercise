import java.util.*;

public class Answer2 {
    public static void main(String[] args) {
        List<Employee> ls = new ArrayList<>();
        ls.add(new Employee(23.0, 500000.0, "Ram", "Jain"));
        ls.add(new Employee(28.0, 650000.0, "Sita", "Verma"));
        ls.add(new Employee(35.0, 800000.0, "Lakshman", "Rao"));
        ls.add(new Employee(30.0, 700000.0, "Bharat", "Kapoor"));
        ls.add(new Employee(25.0, 550000.0, "Shyam", "Mehta"));

        System.out.println("Sorted by Name:");
        Collections.sort(ls);
        ls.forEach(System.out::println);

        System.out.println("\nSorted by Salary:");
        ls.sort(Comparator.comparingDouble(Employee::getSalary));
        ls.forEach(System.out::println);
    }
}

class Employee implements Comparable<Employee> {
    Double age;
    Double salary;
    String firstName;
    String lastName;

    public Employee(Double age, Double salary, String firstName, String lastName) {
        this.age = age;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        return (firstName + lastName).compareTo(other.firstName + other.lastName);
    }

    @Override
    public String toString() {
        return "Employee{age=" + age + ", salary=" + salary + ", firstName=" + firstName + ", lastName=" + lastName + "}";
    }
}

