# Question 1 Write Java code to define List. Insert 5 floating point numbers in List, and using an iterator, find the sum of the numbers in List.

# Answer 1

```java
public class Sol1 {

    public static void main(String[] args) {
        List<Float> ls = new ArrayList<>();
        ls.add(1.1f);
        ls.add(1.4f);
        ls.add(2.1f);
        ls.add(5.1f);
        ls.add(6.1f);
        float sum = 0;
        Iterator<Float> itr = ls.iterator();
        while (itr.hasNext()) {
            sum += itr.next();
        }
        System.out.println(sum);
    }

}
```


# Question 2 Given the following class Employee class{ Double Age; Double Salary; String Name} Design the class in such a way that the default sorting should work on firstname and lastname. Also, Write a program to sort Employee objects based on salary using Comparator.

# Answer 2

```java

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sol2 {

    public static void main(String[] args) {
        List<Employee> ls = new ArrayList<>();
        ls.add(new Employee(23.0, 500000.0, "Ram", "Jain"));
        ls.add(new Employee(28.0, 650000.0, "Sita", "Verma"));
        ls.add(new Employee(35.0, 800000.0, "Lakshman", "Rao"));
        ls.add(new Employee(30.0, 700000.0, "Bharat", "Kapoor"));
        ls.add(new Employee(25.0, 550000.0, "Shyam", "Mehta"));
        Collections.sort(ls);
        System.out.println(ls);
        Collections.sort(ls, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        });
        System.out.println(ls);
    }
}

class Employee implements Comparable<Employee> {
    Double age;
    Double salary;
    String firstName;
    String lastName;

    public Employee(Double age, Double salary, String firstName,
            String lastName) {
        this.age = age;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Employee other) {
        String fullName = firstName + lastName;
        return fullName.compareTo(other.getFirstName() + other.getLastName());
    }

    public Double getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{age=" + age + ", salary=" + salary +
                ", firstName=" + firstName + ", lastName=" + lastName + "}";
    }
}

```

# Question 3 Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. (Expected complexity ­ O(1))

# Answer 3

```java
public class CollectionSol {

    public static void main(String[] args) {
        var ls = new SpecialStack(5);
        ls.push(5);
        ls.push(50);
        ls.push(2);
        ls.push(65);
        ls.push(1);
        System.out.println(ls.getMin());  // 1
        ls.pop();
        System.out.println(ls.getMin()); // 2
    }
}
class SpecialStack{

    class Pair{
        int val;
        int min;

        public Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
        public int getVal() {
            return val;
        }
        public void setVal(int val) {
            this.val = val;
        }
        public int getMin() {
            return min;
        }
        public void setMin(int min) {
            this.min = min;
        }

    }

    private Pair[] stack;
    private int maxSize;
    private int top;
    private int min;

    SpecialStack(int size){
       this.stack = new Pair[size];
       this.maxSize = size;
       this.min = Integer.MAX_VALUE;
       this.top = -1;
    }

    public void push(int data){
        if (isFull()) {
            System.out.println("Stack is full");
           return; 
        }
        top++;
        min = Math.min(min, data);
        stack[top] = new Pair(data, min);
    }

    public int pop(){
       if (isEmpty()) {
           return -1;
       } 
       return stack[top--].getVal();
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
       return top == maxSize - 1; 
    }

    public int getMin(){
        if (isEmpty()) {
           return -1; 
        }
        return stack[top].getMin();
    }
}

```

# Question 4 Create class Employee with attributes name,age,designation and use instances of these class as keys in a Map and their salary as value

# Answer 4

```java

import java.util.HashMap;
import java.util.Map;

public class Sol4 {

    public static void main(String[] args) {
        Map<Employee, Integer> mp = new HashMap<>();
        Employee e1 = new Employee("Sahil", 30, "TL");
        Employee e5 = new Employee("Sahil", 30, "TL");
        Employee e2 = new Employee("Ram", 30, "TL");
        Employee e3 = new Employee("Shyam", 20, "Trainee");
        mp.put(e1, 2400000);
        mp.put(e2, 24000000);
        mp.put(e3, 3400000);

        // this will update e1 value to this as the key hashcode will be same
        mp.put(e5, 5400000);

        // Output is 5400000
        System.out.println(mp.get(e1));
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

    // created using IDE feature
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + ((designation == null) ? 0 : designation.hashCode());
        return result;
    }

    // created using IDE feature
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (age != other.age) {
            return false;
        }
        if (designation == null) {
            if (other.designation != null) {
                return false;
            }
        } else if (!designation.equals(other.designation)) {
            return false;
        }
        return true;
    }
}

```
